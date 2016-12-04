/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softpro.Controller.Operations;

import static java.lang.Integer.valueOf;
import java.util.HashMap;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.Sprint;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.ActionOverProject;

/**
 *
 * @author Mictlan
 */
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
