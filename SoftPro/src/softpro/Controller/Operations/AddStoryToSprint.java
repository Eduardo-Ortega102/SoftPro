package softpro.Controller.Operations;

import java.util.HashMap;
import java.util.Map;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.Sprint;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.ActionOverProject;
import static java.lang.Integer.valueOf;


public class AddStoryToSprint implements ActionOverProject<ScrumProject> {

    @Override
    public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
        Sprint sprint = project.findSprint(valueOf(arguments.get("sprintID")));
        UserStory story = project.getBacklog().findStory(valueOf(arguments.get("storyID")));
        return sprint == null || story == null ? false : 
               sprint.findStory(valueOf(arguments.get("storyID"))) != null ? false : 
               !couldInsertIntoDatabase(story, sprint) ? false : 
               sprint.addStory(story);
    }

    private boolean couldInsertIntoDatabase(UserStory story, Sprint sprint) {
        Map<String, Object> map = new HashMap<>();
        map.put("story", story.getId());
        map.put("sprint", sprint.getId());
        return new SqliteInterface().insertInto("sprint_backlog", map);
    }

}
