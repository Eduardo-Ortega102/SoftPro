package softpro.Persistence;

import java.util.HashMap;
import java.util.List;
import softpro.Model.ProductBacklog;
import softpro.Model.ScrumProject;
import softpro.Model.State;
import softpro.Model.UserStory;
import softpro.Model.User;
import softpro.Persistence.Database.SqliteInterface;
import static java.lang.Integer.valueOf;

public class ProductBacklogLoader {

    private static final SqliteInterface sqliteInterface = new SqliteInterface();

    private static List<HashMap<String, String>> select(String table, String filter) {
        return sqliteInterface.selectFrom(table, new String[]{"*"}, filter);
    }

    public static ProductBacklog loadBacklogOf(ScrumProject project) {
        ProductBacklog backlog = new ProductBacklog();
        loadUserStories(backlog, select("features", "type = 'UserStory' AND project = " + project.getId()));
        loadTasks(backlog);
        return backlog;
    }

    private static void loadUserStories(ProductBacklog backlog, List<HashMap<String, String>> list) {
        for (HashMap<String, String> map : list) 
            backlog.create(valueOf(map.get("id")), map.get("description"),
                           map.get("details"), valueOf(map.get("points")),
                           valueOf(map.get("priority")), State.parseState(map.get("state")));
    }

    private static void loadTasks(ProductBacklog backlog) {
        for (UserStory userStory : backlog) {
            loadTasks(userStory, select("tasks", "feature = " + userStory.getId()));
        }
    }

    private static void loadTasks(UserStory userStory, List<HashMap<String, String>> list) {
        for (HashMap<String, String> map : list)
            userStory.create(valueOf(map.get("id")), map.get("description"), 
                             map.get("details"), State.parseState(map.get("state")), 
                             getUser(map.get("responsible")), valueOf(map.get("estimated_duration")), 
                             valueOf(map.get("real_duration")));
    }

    private static User getUser(String responsible) {
        return null;
    }

}
