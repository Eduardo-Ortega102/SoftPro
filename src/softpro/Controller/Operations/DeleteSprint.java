package softpro.Controller.Operations;

import static java.lang.Integer.valueOf;
import java.util.HashMap;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.Sprint;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.ActionOverProject;

public class DeleteSprint implements ActionOverProject<ScrumProject> {

    @Override
    public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
        Sprint sprint = project.findSprint(valueOf(arguments.get("sprintID")));
        if(sprint == null) return false;
        if(databaseDeleteSprintError(sprint)==false) return false;
        if(databaseDeleteSprintBacklogError(sprint)==false) return false;
        return project.delete(sprint);
    }
    
    private boolean databaseDeleteSprintError(Sprint sprint){
        String id = "id="+sprint.getId();
        return new SqliteInterface().deleteFrom("sprints",id);
    }
    
    private boolean databaseDeleteSprintBacklogError(Sprint sprint){
        String id = "sprint="+sprint.getId();
        return new SqliteInterface().deleteFrom("sprint_backlog",id);
    }
}
