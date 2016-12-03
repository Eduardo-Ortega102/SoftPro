package softpro.Controller.Operations;

import static java.lang.Integer.valueOf;
import java.util.HashMap;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Team;
import softpro.Model.User;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.ActionOverProject;

public class RemoveUserFromTeam implements ActionOverProject<ScrumProject> {

    @Override
    public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
        Team team = project.getTeam();
        User user = team.findUser(valueOf(arguments.get("userID")));
        return user == null || !couldRemoveFromDatabase(user, project) ? false :
               team.removeUser(user);
    }

    private boolean couldRemoveFromDatabase(User user, ScrumProject project) {
        return new SqliteInterface().deleteFrom("teams", 
                "staff = " + user.getId() + " AND project = " + project.getId());
    }
    
}
