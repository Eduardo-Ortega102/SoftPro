package softpro.Persistence;

import static java.lang.Integer.valueOf;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import softpro.Model.Scrum.ProductBacklog;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.Sprint;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.Database.SqliteInterface;

public class SprintsLoader {

    private static final SqliteInterface sqliteInterface = new SqliteInterface();

    private static List<HashMap<String, String>> select(String table, String filter) {
        return sqliteInterface.selectFrom(table, new String[]{"*"}, filter);
    }

    public static void loadSprintsOf(ScrumProject project) {
        loadSprints(project, select("sprints", "project = " + project.getId()));
        loadUserStories(project);
    }

    private static void loadSprints(ScrumProject project, List<HashMap<String, String>> list) {
        for (HashMap<String, String> map : list)
            project.create(valueOf(map.get("id")), LocalDate.parse(map.get("start_date")));
    }

    private static void loadUserStories(ScrumProject project) {
        for (Sprint sprint : project) 
            addStoriesOf(project.getBacklog(), sprint);
    }

    private static void addStoriesOf(ProductBacklog backlog, Sprint sprint) {
        for (HashMap<String, String> map : select("sprint_backlog", "sprint = " + sprint.getId())) 
            for (UserStory story : backlog) 
                    if (story.getId() == valueOf(map.get("story"))) sprint.addUserStory(story);
    }
}
