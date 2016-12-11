package softpro.Controller.Operations;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import softpro.Controller.CommandSet;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.Sprint;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.Database.SqliteInterface;
import softpro.Persistence.ProjectLoader;
import softpro.View.ActionSet;
import softpro.View.AdministrativeAction;
import softpro.View.Operation;

public class DeleteProject implements AdministrativeAction {

    private static final SqliteInterface sqliteInterface = new SqliteInterface();
    private ActionSet actionSet;
    
    @Override
    public boolean execute(HashMap<String, String> arguments) {
        String projectID = arguments.get("projectID");
        return DeleteScrumProject(projectID);
    }
    
    private boolean DeleteScrumProject(String projectID){
        ScrumProject scrumProject = ProjectLoader.loadScrumProject(Integer.valueOf(projectID));
        actionSet = new CommandSet();
        List<String> iDs = new ArrayList<>();
        for (Sprint sprint : scrumProject) {
            iDs.add(""+sprint.getId());
        }
        for (String iD : iDs) {
            HashMap<String, String> arguments = new HashMap<>();
            arguments.put("sprintID", iD);
            actionSet.getProjectAction(Operation.DELETE_SPRINT).execute(scrumProject, arguments);
        }
        iDs = new ArrayList<>();
        for (UserStory story : scrumProject.getBacklog()) {
            iDs.add(""+story.getId());
        }
        for (String iD : iDs) {
            HashMap<String, String> arguments = new HashMap<>();
            arguments.put("storyID", iD);
            actionSet.getProjectAction(Operation.DELETE_STORY).execute(scrumProject, arguments);
        }
        if(databaseDeleteTeamProjectError(scrumProject.getId())==false) return false;
        return databaseDeleteProjectError(scrumProject.getId());
    }
    
    private boolean databaseDeleteTeamProjectError(int projectID){
        String where = "project = "+projectID;
        return new SqliteInterface().deleteFrom("teams",where);
    }
    
    private boolean databaseDeleteProjectError(int projectID){
        String where = "id = "+projectID;
        return new SqliteInterface().deleteFrom("projects",where);
    }
}
