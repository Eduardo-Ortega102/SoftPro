package softpro.Controller.Operations;

import java.util.HashMap;
import softpro.Model.Project;
import softpro.Model.Team;
import softpro.Model.User;
import softpro.View.ActionOverProject;
import static java.lang.Integer.valueOf;
import java.util.Map;
import softpro.Persistence.Database.SqliteInterface;

public class AddUserToTeam implements ActionOverProject<Project> {

    private final SqliteInterface dbInterface = new SqliteInterface();
    
    @Override
    public boolean execute(Project project, HashMap<String, String> arguments) {
        Team team = project.getTeam();
        if (team.findUser(valueOf(arguments.get("userID"))) != null) return false;
        User user = getUser(arguments.get("userID"), arguments.get("rol"));
        return !couldInsertIntoDatabase(user, project) ? false : team.addUser(user);
    }

    private User getUser(String id, String rol) {
        HashMap<String, String> user = dbInterface.selectFrom("staff", new String[]{"*"}, "id = " + id).get(0);
        return new User(valueOf(id), user.get("name"), user.get("phone"), user.get("email"), rol);
    }

    private boolean couldInsertIntoDatabase(User user, Project project) {
        Map<String, Object> map = new HashMap<>();
        map.put("staff", user.getId());
        map.put("rol", user.getRol());
        map.put("project", project.getId());
        return dbInterface.insertInto("teams", map);
    }
    
}
