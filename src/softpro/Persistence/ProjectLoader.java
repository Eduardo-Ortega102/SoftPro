package softpro.Persistence;

import java.util.HashMap;
import java.util.List;
import softpro.Model.Project;
import softpro.Model.Scrum.ScrumProject;
import softpro.Persistence.Database.SqliteInterface;

public class ProjectLoader {

    private static final SqliteInterface sqliteInterface = new SqliteInterface();

    private static List<HashMap<String, String>> select(String table, String filter) {
        return sqliteInterface.selectFrom(table, new String[]{"*"}, filter);
    }

    public static Project loadIncrementalProject(int id, String name) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public static ScrumProject loadScrumProject(int id) {
        ScrumProject project = new ScrumProject(id, getProjectName(id));
        TeamLoader.loadTeamOf(project);
        BacklogLoader.loadBacklogOf(project);
        SprintsLoader.loadSprintsOf(project);
        return project;
    }

    private static String getProjectName(int id) {
        return select("projects", "id = " + id).get(0).get("name");
    }

}
