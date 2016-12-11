package softpro.Controller.Operations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.AdministrativeAction;


public class DeleteUser implements AdministrativeAction {
    
    private static final SqliteInterface sqliteInterface = new SqliteInterface();
    
    @Override
    public boolean execute(HashMap<String, String> arguments) {
        String[] select = {"*"};
        List<HashMap<String, String>> features = sqliteInterface.selectFrom("features", select);
        for (HashMap<String, String> hashMap : features) {
            if(hashMap.get("responsible").equals(arguments.get("id"))) databaseRemoveResponsibleFromFeatures(hashMap);
        }
        if(databaseRemoveStaffFromTeam(Integer.valueOf(arguments.get("id")))==false) return false;
        return databaseRemoveStaff(Integer.valueOf(arguments.get("id")));
    }
    
    private boolean databaseRemoveResponsibleFromFeatures(HashMap<String, String> hashMap){
        Map<String, Object> map = new HashMap<>();
        map.put("id", hashMap.get("id"));
        map.put("project", hashMap.get("project"));
        map.put("type", hashMap.get("type"));
        map.put("description", hashMap.get("description"));
        map.put("details", hashMap.get("details"));
        map.put("points", hashMap.get("points"));
        map.put("priority", hashMap.get("priority"));
        map.put("responsible", null);
        map.put("state", hashMap.get("state"));
        String where = "id = "+hashMap.get("id");
        return new SqliteInterface().update("features",map,where);
    }
    
    private boolean databaseRemoveStaffFromTeam(int staff){
        String where = "staff = "+staff;
        return new SqliteInterface().deleteFrom("teams",where);
    }
    
    private boolean databaseRemoveStaff(int staff){
        String where = "id = "+staff;
        return new SqliteInterface().deleteFrom("staff",where);
    }
}
