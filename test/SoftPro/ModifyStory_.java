package SoftPro;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import softpro.Controller.CommandSet;
import softpro.Model.Scrum.ScrumProject;
import softpro.Persistence.ProjectLoader;
import softpro.View.ActionSet;

public class ModifyStory_ {

    private ScrumProject project;
    private ActionSet actionSet;

    @Before
    public void setUp() {
        project = ProjectLoader.loadScrumProject(2);
        actionSet = new CommandSet();
    }

    @Test
    public void hello() {
        assertTrue(true);
        assertTrue(true);
        assertTrue(true);
        assertTrue(true);
        assertTrue(true);
        assertTrue(true);
        assertTrue(true);
        assertTrue(true);
    }
}
