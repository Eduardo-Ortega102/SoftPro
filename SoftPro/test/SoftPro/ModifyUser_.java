package SoftPro;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import softpro.Controller.CommandSet;
import softpro.View.ActionSet;
import static softpro.View.Operation.*;

public class ModifyUser_ {

    private ActionSet actionSet;

    @Before
    public void setUp() {
        actionSet = new CommandSet();
    }

    @Test
    public void should_change_name_of_user() {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("id", "6");
        arguments.put("name", "Pumba");
        assertTrue(actionSet.getAdministrativeAction(MODIFY_USER).execute(arguments));
    }

    @Test
    public void should_change_email_of_user_if_not_exists() {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("id", "6");
        arguments.put("email", "pumba@gmail.com");
        assertTrue(actionSet.getAdministrativeAction(MODIFY_USER).execute(arguments));
    }

    @Test
    public void should_not_change_email_of_user_if_exists() {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("id", "6");
        arguments.put("email", "timon@gmail.com");
        assertFalse(actionSet.getAdministrativeAction(MODIFY_USER).execute(arguments));
    }
}
