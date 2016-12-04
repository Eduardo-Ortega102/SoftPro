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

public class AddStoryToBacklog_ {

    private ScrumProject project;
    private ActionSet actionSet;

    @Before
    public void setUp() {
        project = ProjectLoader.loadScrumProject(2);
        actionSet = new CommandSet();
    }

//    @Test
//    public void add_story_to_backlog() {
//        HashMap<String, String> arguments = new HashMap<>();
//        arguments.put("description", "Historia 5");
//        boolean result = actionSet.getProjectAction(Operation.ADD_STORY_TO_BACKLOG).execute(project, arguments);
//        assertTrue(result);
//    }
    
    @Test
    public void story_5_exists(){
        assertNotNull(project.getBacklog().findStory(5));
    }

    @Test
    public void should_not_add_existing_story_to_backlog() {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("description", "Historia 3");
        boolean result = actionSet.getProjectAction(Operation.ADD_STORY_TO_BACKLOG).execute(project, arguments);
        assertFalse(result);
    }
}
