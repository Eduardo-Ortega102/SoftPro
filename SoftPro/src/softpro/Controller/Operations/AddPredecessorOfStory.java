package softpro.Controller.Operations;

import java.util.HashMap;
import java.util.Map;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.ActionOverProject;
import static java.lang.Integer.valueOf;

public class AddPredecessorOfStory implements ActionOverProject<ScrumProject> {

    @Override
    public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
        UserStory story = project.getBacklog().findStory(valueOf(arguments.get("storyID")));
        UserStory predecessor = project.getBacklog().findStory(valueOf(arguments.get("predecessorID")));
        return story == null || predecessor == null || 
               story.findPredecessor(valueOf(arguments.get("predecessorID"))) != null ? false : 
               !couldInsertIntoDatabase(story, predecessor) ? false:
               story.addPredecessor(predecessor);
    }

    private boolean couldInsertIntoDatabase(UserStory story, UserStory predecessor) {
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("story", story.getId());
        mapa.put("predecessor", predecessor.getId());
        return new SqliteInterface().insertInto("story_predecessors", mapa);
    }
    
}
