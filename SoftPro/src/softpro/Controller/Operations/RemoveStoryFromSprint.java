package softpro.Controller.Operations;

import static java.lang.Integer.valueOf;
import java.util.HashMap;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.Sprint;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.ActionOverProject;

public class RemoveStoryFromSprint implements ActionOverProject<ScrumProject> {

    @Override
    public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
        Sprint sprint = project.findSprint(valueOf(arguments.get("sprintID")));
        UserStory story = project.getBacklog().findStory(valueOf(arguments.get("storyID")));
        if(sprint == null) return false;
        if(story == null) return false;
        if(databaseDeleteStoryFromSprintError(sprint.getId(),story.getId())==false) return false;
        return sprint.removeUserStory(story);
    }
    
    private boolean databaseDeleteStoryFromSprintError(int sprintID, int storyID){
        String row = "story = "+storyID+ " AND sprint = " + sprintID;
        return new SqliteInterface().deleteFrom("sprints",row);
    }
}
