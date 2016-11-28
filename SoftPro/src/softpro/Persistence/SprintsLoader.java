package softpro.Persistence;

import static java.lang.Integer.valueOf;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.Sprint;
import softpro.Model.Task;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.Database.SqliteInterface;

public class SprintsLoader {

    private static final SqliteInterface sqliteInterface = new SqliteInterface();

    private static List<HashMap<String, String>> select(String table, String filter) {
        return sqliteInterface.selectFrom(table, new String[]{"*"}, filter);
    }

    public static void loadSprintsOf(ScrumProject project) {
        loadSprints(project, select("sprints", "project = " + project.getId()));
        loadTasks(project);
    }

    private static void loadSprints(ScrumProject project, List<HashMap<String, String>> list) {
        for (HashMap<String, String> map : list)
            project.create(valueOf(map.get("id")), LocalDate.parse(map.get("start_date")), getDateIn(map.get("start_date")));
    }

    private static LocalDate getDateIn(String string) {
        return !string.equals("Unset") ? LocalDate.parse(string) : null;
    }

    private static void loadTasks(ScrumProject project) {
        for (Sprint sprint : project) 
            sprint.setTaskList(getTasksOf(project, sprint));
    }

    private static List<Task> getTasksOf(ScrumProject project, Sprint sprint) {
        List<Task> tasks = new ArrayList<>();
        for (HashMap<String, String> map : select("sprint_backlog", "sprint = " + sprint.getId())) 
            for (UserStory userStory : project.getBacklog()) 
                for (Task task : userStory) 
                    if (task.getId() == valueOf(map.get("task"))) tasks.add(task);
        return tasks;
    }
}
