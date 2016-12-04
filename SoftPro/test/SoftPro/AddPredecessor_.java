package SoftPro;

import java.util.HashMap;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import softpro.Controller.CommandSet;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.ProjectLoader;
import softpro.View.ActionSet;
import softpro.View.Operation;


public class AddPredecessor_ {
    
    private ScrumProject project;
    private ActionSet actionSet;
    
    
    @Before
    public void setUp(){
        project = ProjectLoader.loadScrumProject(2);
        actionSet = new CommandSet();
    }
/*
    Este test debe estar comentado porque una vez ejecutado la primera vez, 
    no puedes volver a añadir la misma historia de nuevo. Osea, la segunda ejecución falla.
    
    @Test
    public void add_predecessor_to_a_story(){
        HashMap<String,String> arguments = new HashMap<>();
        arguments.put("storyID", "3");
        arguments.put("predecessorID", "1");
        boolean result = actionSet.getProjectAction(Operation.ADD_PREDECESSOR_OF_STORY).execute(project, arguments);
        assertTrue(result);
    }
*/
    
    @Test
    public void story_2_has_story_1_as_predecessor(){
        assertNotNull(project.getBacklog().findStory(2).findPredecessor(1));
    }

    @Test
    public void story_3_has_story_1_as_predecessor(){
        assertNotNull(project.getBacklog().findStory(3).findPredecessor(1));
    }
    
    @Test
    public void should_not_add_existing_predecessor_to_a_story(){
        HashMap<String,String> arguments = new HashMap<>();
        arguments.put("storyID", "2");
        arguments.put("predecessorID", "1");
        boolean result = actionSet.getProjectAction(Operation.ADD_PREDECESSOR_OF_STORY).execute(project, arguments);
        assertFalse(result);
    }

    @Test
    public void should_not_add_inexistent_story_as_predecessor_of_a_story(){
        HashMap<String,String> arguments = new HashMap<>();
        arguments.put("storyID", "2");
        arguments.put("predecessorID", "9999999");
        boolean result = actionSet.getProjectAction(Operation.ADD_PREDECESSOR_OF_STORY).execute(project, arguments);
        assertFalse(result);
    }
    
    
}
