package softpro.Controller.Operations;

import static java.lang.Integer.valueOf;
import java.util.HashMap;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.ActionOverProject;

public class RemovePredecessorOfStory implements ActionOverProject<ScrumProject> {

    @Override
    public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
        UserStory story = project.getBacklog().findStory(valueOf(arguments.get("storyID")));
        UserStory predecessor = project.getBacklog().findStory(valueOf(arguments.get("predecessorID")));
        return story == null || predecessor == null || 
               !couldRemoveFromDatabase(story, predecessor) ? false:
               story.removePredecessor(predecessor);
    }

    private boolean couldRemoveFromDatabase(UserStory story, UserStory predecessor) {
        return new SqliteInterface().deleteFrom("story_predecessors", 
                "story = " + story.getId() + " AND predecessor = " + predecessor.getId());
    }
}
