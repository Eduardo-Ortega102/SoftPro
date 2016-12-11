package softpro.Controller.Operations;

import java.util.HashMap;
import static java.lang.Integer.valueOf;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.UserStory;
import static softpro.Model.State.parseState;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.ActionOverProject;

public class ModifyStory implements ActionOverProject<ScrumProject> {

    @Override
    public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
        UserStory story = project.getBacklog().findStory(valueOf(arguments.remove("id")));
        if (story == null) return false;
        story.setDetails(arguments.get("details"));
        story.setName(arguments.get("description"));
        story.setPoints(valueOf(arguments.get("points")));
        story.setPriority(valueOf(arguments.get("priority")));
        if (!arguments.get("responsible").equals(" "))
            story.setResponsible(project.getTeam().findUser(valueOf(arguments.get("responsible"))));
        story.setState(parseState(arguments.get("state")));
        HashMap<String, Object> map = new HashMap<>();
        map.putAll(arguments);
        return new SqliteInterface().update("features", map, "id = " + story.getId());
    }

}
