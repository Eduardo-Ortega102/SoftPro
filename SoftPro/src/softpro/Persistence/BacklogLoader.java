package softpro.Persistence;

import java.util.HashMap;
import java.util.List;
import softpro.Model.Scrum.ProductBacklog;
import softpro.Model.State;
import softpro.Model.User;
import softpro.Persistence.Database.SqliteInterface;
import static java.lang.Integer.valueOf;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.UserStory;
import softpro.Model.Team;

public class BacklogLoader {

    private static final SqliteInterface sqliteInterface = new SqliteInterface();

    private static List<HashMap<String, String>> select(String table, String filter) {
        return sqliteInterface.selectFrom(table, new String[]{"*"}, filter);
    }

    public static void loadBacklogOf(ScrumProject project) {
        loadUserStories(project, select("features", "type = 'UserStory' AND project = " + project.getId()));
        loadStoriesPredecessors(project.getBacklog());
    }

    private static void loadUserStories(ScrumProject project, List<HashMap<String, String>> list) {
        ProductBacklog backlog = project.getBacklog();
        for (HashMap<String, String> map : list) 
            backlog.create(valueOf(map.get("id")), map.get("description"),
                           map.get("details"), valueOf(map.get("points")),
                           valueOf(map.get("priority")), State.parseState(map.get("state")),
                           getUser(map.get("responsible"), project.getTeam()));
    }

    private static User getUser(String responsible, Team team) {
        responsible = responsible.equals(" ") || responsible.equals("unset") ? "-1" : responsible;
        return team.findUser(valueOf(responsible));
    }

    private static void loadStoriesPredecessors(ProductBacklog backlog) {
        for (UserStory userStory : backlog) 
            for (HashMap<String, String> map : select("story_predecessors", "story = " + userStory.getId())) 
                userStory.addPredecessor(backlog.findStory(valueOf(map.get("id"))));
    }

}
