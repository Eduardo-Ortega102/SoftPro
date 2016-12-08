package softpro.Controller.Operations;

import java.time.LocalDate;
import java.util.HashMap;
import softpro.Model.Scrum.ScrumProject;
import softpro.Model.Scrum.Sprint;
import static softpro.Persistence.IdGenerator.generateNewIdForTable;
import static java.lang.Integer.valueOf;
import java.util.Map;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.ActionOverProject;


public class CreateSprint implements ActionOverProject<ScrumProject> {

    @Override
    public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
        LocalDate start_date = LocalDate.parse(arguments.get("start_date"));
        for (Sprint sprint : project)
            if (sprint.getFecha_inicio().equals(start_date)) return false;
        Sprint sprint = project.create(generateNewIdForTable("sprints"), start_date, valueOf(arguments.get("weeks")));
        return sprint == null ? false :
               insertSprintInDatabase(sprint, project) ? true :
               undoOperation(project, sprint);
    }

    private boolean insertSprintInDatabase(Sprint sprint, ScrumProject project) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", sprint.getId());
        map.put("start_date", sprint.getFecha_inicio());
        map.put("weeks", sprint.getWeeks());
        map.put("project", project.getId());
        return new SqliteInterface().insertInto("sprints", map);
    }

    private boolean undoOperation(ScrumProject project, Sprint sprint) {
        project.delete(sprint);
        return false;
    }
    
}
