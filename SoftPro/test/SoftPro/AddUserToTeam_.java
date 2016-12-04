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

public class AddUserToTeam_ {

    private ScrumProject project;
    private ActionSet actionSet;

    @Before
    public void setUp() {
        project = ProjectLoader.loadScrumProject(2);
        actionSet = new CommandSet();
    }

//    @Test
//    public void should_add_user_5_to_team() {
//        HashMap<String, String> arguments = new HashMap<>();
//        arguments.put("userID", "5");
//        arguments.put("rol", "Developer");
//        boolean result = actionSet.getProjectAction(Operation.ADD_USER_TO_TEAM).execute(project, arguments);
//        assertTrue(result);
//    }
//
//    @Test
//    public void should_add_user_6_to_team() {
//        HashMap<String, String> arguments = new HashMap<>();
//        arguments.put("userID", "6");
//        arguments.put("rol", "Tester");
//        boolean result = actionSet.getProjectAction(Operation.ADD_USER_TO_TEAM).execute(project, arguments);
//        assertTrue(result);
//    }
    
    @Test
    public void user_5_is_in_team() {
        assertNotNull(project.getTeam().findUser(5));
    }
    
    @Test
    public void user_6_is_in_team() {
        assertNotNull(project.getTeam().findUser(6));
    }
    
    @Test
    public void should_not_add_existing_user_to_team() {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("userID", "6");
        arguments.put("rol", "Tester");
        boolean result = actionSet.getProjectAction(Operation.ADD_USER_TO_TEAM).execute(project, arguments);
        assertFalse(result);
    }

    @Test
    public void should_not_add_existing_user_with_different_rol_to_team() {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("userID", "6");
        arguments.put("rol", "Developer");
        boolean result = actionSet.getProjectAction(Operation.ADD_USER_TO_TEAM).execute(project, arguments);
        assertFalse(result);
    }
    
    
}
