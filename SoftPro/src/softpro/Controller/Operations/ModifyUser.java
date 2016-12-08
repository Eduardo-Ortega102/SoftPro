package softpro.Controller.Operations;

import java.util.HashMap;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.AdministrativeAction;

public class ModifyUser implements AdministrativeAction {

    @Override
    public boolean execute(HashMap<String, String> arguments) {
        String id = arguments.remove("id");
        SqliteInterface dbInterface = new SqliteInterface();
        for (HashMap<String, String> mapa : dbInterface.selectFrom("staff", new String[]{"email"}, "id != " + id)) {
            if (mapa.get("email").equals(arguments.get("email"))) return false;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.putAll(arguments);
        return dbInterface.update("staff", map, "id = " + id);
    }

}
