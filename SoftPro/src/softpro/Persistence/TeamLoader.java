
package softpro.Persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import softpro.Model.Team;
import softpro.Model.User;
import softpro.Persistence.Database.SqliteInterface;
import static java.lang.Integer.valueOf;

public class TeamLoader {

    private static final SqliteInterface sqliteInterface = new SqliteInterface();

    private static List<HashMap<String, String>> select(String table, String filter) {
        return sqliteInterface.selectFrom(table, new String[]{"*"}, filter);
    }

    public static Team loadTeamOf(int id) {
        Team team = new Team();
        for (User user : getUsersOfProject(select("teams", "project = " + id))) 
            team.addUser(user);
        return team;
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
