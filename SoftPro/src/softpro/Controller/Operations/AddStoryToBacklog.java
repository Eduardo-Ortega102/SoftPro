package softpro.Controller.Operations;

import java.util.HashMap;
import java.util.Map;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.UserStory;
import softpro.Persistence.Database.SqliteInterface;
import static softpro.Persistence.IdGenerator.generateNewIdForTable;
import softpro.View.ActionOverProject;

public class AddStoryToBacklog implements ActionOverProject<ScrumProject> {

    @Override
    public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
        for (UserStory userStory : project.getBacklog())
            if (userStory.getDescription().equalsIgnoreCase(arguments.get("description"))) return false;
        UserStory story = project.getBacklog().create(generateNewIdForTable("features"), arguments.get("description"));
        return storeInDatabase(story, project);
    }

    private boolean storeInDatabase(UserStory story, ScrumProject project) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", story.getId());
        map.put("project", project.getId());
        map.put("type", "UserStory");
        map.put("description", story.getDescription());
        map.put("details", story.getDetails());
        map.put("points", story.getPoints());
        map.put("priority", story.getPriority());
        map.put("responsible", story.getResponsible().getId());
        map.put("state", story.getState().toString());
        return new SqliteInterface().insertInto("features", map);
    }
}
