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
        int id = generateNewIdForTable("features");
        String description = arguments.get("description");
        String details = "";
        int priority = Integer.valueOf(arguments.get("priority"));
        int points = Integer.valueOf(arguments.get("points"));
        UserStory story = project.getBacklog().create(id, description, details, points, priority);
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
        String responsibleID = story.getResponsible() == null ? " " : story.getResponsible().getId() + "";
        map.put("responsible", responsibleID);
        map.put("state", story.getState().toString());
        return new SqliteInterface().insertInto("features", map);
    }
}
