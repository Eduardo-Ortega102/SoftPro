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

public class AddStoryToSprint_ {

    private ScrumProject project;
    private ActionSet actionSet;

    @Before
    public void setUp() {
        project = ProjectLoader.loadScrumProject(2);
        actionSet = new CommandSet();
    }

//    @Test
//    public void add_story_1_to_sprint() {
//        HashMap<String, String> arguments = new HashMap<>();
//        arguments.put("sprintID", "0");
//        arguments.put("storyID", "1");
//        boolean result = actionSet.getProjectAction(Operation.ADD_STORY_TO_SPRINT).execute(project, arguments);
//        assertTrue(result);
//    }
//
//    @Test
//    public void add_story_2_to_sprint() {
//        HashMap<String, String> arguments = new HashMap<>();
//        arguments.put("sprintID", "0");
//        arguments.put("storyID", "2");
//        boolean result = actionSet.getProjectAction(Operation.ADD_STORY_TO_SPRINT).execute(project, arguments);
//        assertTrue(result);
//    }

    @Test
    public void story_1_is_in_sprint() {
        assertNotNull(project.findSprint(0).findStory(1));
    }

    @Test
    public void story_2_is_in_sprint() {
        assertNotNull(project.findSprint(0).findStory(2));
    }

    @Test
    public void should_not_add_existing_story_to_sprint() {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("sprintID", "0");
        arguments.put("storyID", "1");
        boolean result = actionSet.getProjectAction(Operation.ADD_STORY_TO_SPRINT).execute(project, arguments);
        assertFalse(result);
    }

    @Test
    public void should_not_add_unexisting_story_to_sprint() {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("sprintID", "0");
        arguments.put("storyID", "9999999");
        boolean result = actionSet.getProjectAction(Operation.ADD_STORY_TO_SPRINT).execute(project, arguments);
        assertFalse(result);
    }

}
