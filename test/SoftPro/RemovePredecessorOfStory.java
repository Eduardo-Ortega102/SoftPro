package SoftPro;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import softpro.Controller.CommandSet;
import softpro.Model.Scrum.ScrumProject;
import softpro.Persistence.ProjectLoader;
import softpro.View.ActionSet;
import softpro.View.Operation;

public class RemovePredecessorOfStory {

    private ScrumProject project;
    private ActionSet actionSet;

    @Before
    public void setUp() {
        project = ProjectLoader.loadScrumProject(2);
        actionSet = new CommandSet();
    }

//    @Test
//    public void should_remove_predecessor_of_a_story(){
//        HashMap<String,String> arguments = new HashMap<>();
//        arguments.put("storyID", "2");
//        arguments.put("predecessorID", "1");
//        boolean result = actionSet.getProjectAction(Operation.REMOVE_PREDECESSOR_OF_STORY).execute(project, arguments);
//        assertTrue(result);
//    }
    
    @Test
    public void story_2_has_not_story_1_as_predecessor(){
        assertNull(project.getBacklog().findStory(2).findPredecessor(1));
    }

    @Test
    public void story_3_has_story_1_as_predecessor(){
        assertNotNull(project.getBacklog().findStory(3).findPredecessor(1));
    }
    
    @Test
    public void should_not_remove_unexisting_predecessor_to_a_story(){
        HashMap<String,String> arguments = new HashMap<>();
        arguments.put("storyID", "2");
        arguments.put("predecessorID", "666666");
        boolean result = actionSet.getProjectAction(Operation.REMOVE_PREDECESSOR_OF_STORY).execute(project, arguments);
        assertFalse(result);
    }

}
