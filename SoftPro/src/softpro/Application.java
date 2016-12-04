package softpro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import softpro.Controller.CommandSet;
import softpro.Model.Project;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.Database.SqliteInterface;
import softpro.Model.Scrum.UserStory;
import softpro.View.Operation;
import static softpro.Persistence.IdGenerator.generateNewIdForTable;
import softpro.Persistence.ProjectLoader;
import softpro.View.ActionSet;

public class Application {

    private static final SqliteInterface sqliteInterface = new SqliteInterface();

    public static void main(String[] args) {
        ActionSet set = new CommandSet();
        new Application().start();
    }

    private static void load_BD_Mock_Projects(int project_id) {
        Map<String, Object> project = new HashMap<>();
        project.put("id", project_id);
        project.put("name", "SoftPro");
        project.put("type", "Scrum");
        sqliteInterface.insertInto("projects", project);

    }

    private static void load_BD_Mock_UserStories(int project_id) {
        Map<String, Object> userStory = new HashMap<>();
        userStory.put("id", generateNewIdForTable("features"));
        userStory.put("project", project_id);
        userStory.put("description", "Historia 1");
        userStory.put("details", "Los detalles de la Historia 1");
        userStory.put("points", 3);
        userStory.put("state", "ToDo");
        userStory.put("type", "UserStory");
        userStory.put("responsible", "unset");
        userStory.put("priority", 7);
        sqliteInterface.insertInto("features", userStory);

        userStory = new HashMap<>();
        userStory.put("id", generateNewIdForTable("features"));
        userStory.put("project", project_id);
        userStory.put("description", "Historia 2");
        userStory.put("details", "Los detalles de la Historia 2");
        userStory.put("points", 34);
        userStory.put("state", "ReadyForTest");
        userStory.put("type", "UserStory");
        userStory.put("responsible", "unset");
        userStory.put("priority", 0);
        sqliteInterface.insertInto("features", userStory);

        userStory = new HashMap<>();
        userStory.put("id", generateNewIdForTable("features"));
        userStory.put("project", project_id);
        userStory.put("description", "Historia 3");
        userStory.put("details", "Los detalles de la Historia 3");
        userStory.put("points", 3);
        userStory.put("state", "InProcess");
        userStory.put("type", "UserStory");
        userStory.put("responsible", "unset");
        userStory.put("priority", 6);
        sqliteInterface.insertInto("features", userStory);

        userStory = new HashMap<>();
        userStory.put("id", generateNewIdForTable("features"));
        userStory.put("project", project_id);
        userStory.put("description", "Historia 4");
        userStory.put("details", "Los detalles de la Historia 4");
        userStory.put("points", 8);
        userStory.put("state", "Done");
        userStory.put("type", "UserStory");
        userStory.put("responsible", "unset");
        userStory.put("priority", 7);
        sqliteInterface.insertInto("features", userStory);
    }

    private void start() {
        ScrumProject project = (ScrumProject) ProjectLoader.loadScrumProject(2);
        System.out.println("\nProyecto.......");
        System.out.println(project.getId());
        System.out.println(project.getName());
        System.out.println(project.getType());

        System.out.println("\nHistorias.......");
        for (UserStory story : project.getBacklog()) {
            System.out.println(story.getId());
            System.out.println(story.getDescription());
            System.out.println(story.getDetails());
            System.out.println(story.getPoints());
            System.out.println(story.getPriority());
            System.out.println(story.getResponsible());
            System.out.println(story.getState());
            System.out.println(".....");
        }

    }

}
