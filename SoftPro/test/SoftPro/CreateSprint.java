package SoftPro;

import java.util.HashMap;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import softpro.Controller.CommandSet;
import softpro.Model.Scrum.ScrumProject;
import softpro.Persistence.ProjectLoader;
import softpro.View.ActionSet;
import softpro.View.Operation;

public class CreateSprint {

    private ScrumProject project;
    private ActionSet actionSet;

    @Before
    public void setUp() {
        project = ProjectLoader.loadScrumProject(2);
        actionSet = new CommandSet();
    }

//    @Test
//    public void should_add_a_sprint_to_a_project() {
//        HashMap<String,String> arguments = new HashMap<>();
//        arguments.put("start_date", "2016-12-24");
//        arguments.put("weeks", "1");
//        assertTrue(actionSet.getProjectAction(Operation.CREATE_SPRINT).execute(project, arguments));
//    }

    @Test
    public void should_not_add_a_sprint_with_same_start_date() {
        HashMap<String,String> arguments = new HashMap<>();
        arguments.put("start_date", "2016-12-24");
        arguments.put("weeks", "3");
        assertFalse(actionSet.getProjectAction(Operation.CREATE_SPRINT).execute(project, arguments));
    }
}
