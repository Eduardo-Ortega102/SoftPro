package softpro.Persistence;

import static java.lang.Integer.valueOf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import softpro.Model.Project;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.User;
import softpro.Persistence.Database.SqliteInterface;

public class ProjectLoader {

    private static final SqliteInterface sqliteInterface = new SqliteInterface();

    private static List<HashMap<String, String>> select(String table, String filter) {
        return sqliteInterface.selectFrom(table, new String[]{"*"}, filter);
    }

    public static Project loadIncrementalProject(int id, String name) {
        return null;
    }

    public static ScrumProject loadScrumProject(int id) {
        ScrumProject project = new ScrumProject(id, getProjectName(id));
        for (User user : getUsersOfProject(select("teams", "project = " + id)))
            project.addUser(user);
        //loadRisks(project, select("risks", "project = " + id));
        BacklogLoader.loadBacklogOf(project);
        SprintsLoader.loadSprintsOf(project);
        return project;
    }

    private static String getProjectName(int id) {
        return select("projects", "id = " + id).get(0).get("name");
    }
    
    private static List<User> getUsersOfProject(List<HashMap<String, String>> list) {
        List<User> users = new ArrayList<>();
        for (HashMap<String, String> map : list) 
            for (HashMap<String, String> userMap : select("staff", "id = " + map.get("staff"))) 
                users.add(new User(valueOf(userMap.get("id")), userMap.get("name"),
                                   userMap.get("phone"), userMap.get("email"), map.get("rol")));
        return users;
    }

    private static void loadRisks(Project project, List<HashMap<String, String>> select) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
