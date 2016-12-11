package softpro.Controller.Operations;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import softpro.Persistence.Database.SqliteInterface;
import softpro.Persistence.IdGenerator;
import softpro.View.AdministrativeAction;

public class CreateProject implements AdministrativeAction {

    private final SqliteInterface dbInterface = new SqliteInterface();
    
    @Override
    public boolean execute(HashMap<String, String> arguments) {
        HashMap<String, Object> argumentsToObject = new HashMap<>();
        if(!checkAvailability(arguments.get("name"))) return false;
        argumentsToObject.put("name", arguments.get("name"));
        argumentsToObject.put("id", IdGenerator.generateNewIdForTable("projects"));
        argumentsToObject.put("type", "Scrum");
        return dbInterface.insertInto("projects", argumentsToObject);
    }

    public boolean checkAvailability(String name) {
        List<HashMap<String, String>> selectFrom = dbInterface.selectFrom("projects", new String[]{"name"});
        for (HashMap<String, String> hashMap : selectFrom) {
            for (Map.Entry<String,String> project : hashMap.entrySet()) {
                if (name.equals(project.getValue()))
                    return false;
            }
        }
        return true;
    }
}
