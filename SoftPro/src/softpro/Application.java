package softpro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import softpro.Persistence.Database.SqliteInterface;
import static softpro.Persistence.IdGenerator.generateIdForTable;

public class Application {

    private static final SqliteInterface sqliteInterface = new SqliteInterface();

    public static void main(String[] args) {
        //int project_id = IdGenerator("projects");
        //load_BD_Mock_Projects(project_id);
        //load_BD_Mock_UserStories(project_id);
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
        userStory.put("id", generateIdForTable("features"));
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
        userStory.put("id", generateIdForTable("features"));
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
        userStory.put("id", generateIdForTable("features"));
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
        userStory.put("id", generateIdForTable("features"));
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
        System.out.println("\nProyectos.......");
        String[] all = {"*"};
        List<HashMap<String, String>> result = sqliteInterface.selectFrom("projects", all);
        for (HashMap<String, String> hashMap : result) {
            for (String key : hashMap.keySet()) {
                System.out.println(key + "---->" + hashMap.get(key));
            }
            System.out.println("\n");
        }
        
        System.out.println("\nHistorias.......");
        result = sqliteInterface.selectFrom("features", all);
        for (HashMap<String, String> hashMap : result) {
            for (String key : hashMap.keySet()) {
                System.out.println(key + "---->" + hashMap.get(key));
            }
            System.out.println("\n");
        }

    }

}
