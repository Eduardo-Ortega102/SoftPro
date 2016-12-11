package softpro.Persistence;

import static java.lang.Integer.valueOf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import softpro.Model.Project;
import softpro.Model.User;
import softpro.Persistence.Database.SqliteInterface;

public class TeamLoader {
    private static final SqliteInterface sqliteInterface = new SqliteInterface();

    private static List<HashMap<String, String>> select(String table, String filter) {
        return sqliteInterface.selectFrom(table, new String[]{"*"}, filter);
    }
    
    public static void loadTeamOf(Project project) {
        for (User user : getUsersOfProject(select("teams", "project = " + project.getId())))
            project.addUser(user);
    }
        
    private static List<User> getUsersOfProject(List<HashMap<String, String>> list) {
        List<User> users = new ArrayList<>();
        for (HashMap<String, String> map : list) 
            for (HashMap<String, String> userMap : select("staff", "id = " + map.get("staff"))) 
                users.add(new User(valueOf(userMap.get("id")), userMap.get("name"),
                                   userMap.get("phone"), userMap.get("email"), map.get("rol")));
        return users;
    }
}
