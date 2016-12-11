package softpro.Controller.Operations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import softpro.Persistence.Database.SqliteInterface;
import softpro.Persistence.IdGenerator;
import softpro.View.AdministrativeAction;

public class CreateUser implements AdministrativeAction {

    private final SqliteInterface dbInterface = new SqliteInterface();
    
    @Override
    public boolean execute(HashMap<String, String> arguments) {
        HashMap<String, Object> argumentsToObject = new HashMap<>();
        for (Map.Entry<String, String> pair : arguments.entrySet()) {
            argumentsToObject.put(pair.getKey(), pair.getValue());            
            if (pair.getKey().equals("email") && !checkAvailability(pair.getValue()))
                return false;
        }
        argumentsToObject.put("id", IdGenerator.generateNewIdForTable("staff"));
        return dbInterface.insertInto("staff", argumentsToObject);
    }
    
    public boolean checkAvailability(String param) {
        List<HashMap<String, String>> selectFrom = dbInterface.selectFrom("staff", new String[]{"email"});
        for (HashMap<String, String> hashMap : selectFrom) {
            for (Map.Entry<String,String> project : hashMap.entrySet()) {
                if (param.equals(project.getValue()))
                    return false;
            }
        }
        return true;
    }
}