
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
        return null;
    }
    
    public static Project loadScrumProject(int id, String name) {
        ScrumProject project = new ScrumProject(id, name);
        project.setTeam(TeamLoader.loadTeamOf(id));
        BacklogLoader.loadBacklogOf(project);
        //loadRisks(project, select("risks", "project = " + id));
        return project;
    }

    private static void loadRisks(Project project, List<HashMap<String, String>> select) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
