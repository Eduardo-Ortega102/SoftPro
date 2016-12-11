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

public class RemoveUserFromTeam {
 
    private ScrumProject project;
    private ActionSet actionSet;

    @Before
    public void setUp() {
        project = ProjectLoader.loadScrumProject(2);
        actionSet = new CommandSet();
    }

//    @Test
//    public void should_remove_user_5_to_team() {
//        HashMap<String, String> arguments = new HashMap<>();
//        arguments.put("userID", "5");
//        boolean result = actionSet.getProjectAction(Operation.REMOVE_USER_FROM_TEAM).execute(project, arguments);
//        assertTrue(result);
//    }

    
    @Test
    public void user_5_is_not_in_team() {
        assertNull(project.getTeam().findUser(5));
    }
    
    @Test
    public void user_6_is_in_team() {
        assertNotNull(project.getTeam().findUser(6));
    }
    
    @Test
    public void should_not_remove_unexisting_user_from_team() {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("userID", "99999999");
        boolean result = actionSet.getProjectAction(Operation.REMOVE_USER_FROM_TEAM).execute(project, arguments);
        assertFalse(result);
    }

}
