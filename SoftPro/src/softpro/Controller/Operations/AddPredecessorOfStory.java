/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softpro.Controller.Operations;

import java.util.HashMap;
import java.util.Map;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.Database.BDInterface;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.ActionOverProject;
import static java.lang.Integer.valueOf;

public class AddPredecessorOfStory implements ActionOverProject<ScrumProject> {

    @Override
    public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
        UserStory story = project.getBacklog().findStory(valueOf(arguments.get("storyID")));
        UserStory predecessor = project.getBacklog().findStory(valueOf(arguments.get("predecessorID")));
        return story == null || predecessor == null ? false : 
               databaseInsertionError(story, predecessor) ? false:
               story.addPredecessor(predecessor);
    }

    private boolean databaseInsertionError(UserStory story, UserStory predecessor) {
        BDInterface sqliteInterface = new SqliteInterface();
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("story", story.getId());
        mapa.put("predecessor", predecessor.getId());
        return sqliteInterface.insertInto("story_predecessors", mapa);
    }
    
}
