package softpro.Controller.Operations;

import java.util.HashMap;
import java.util.Map;
import softpro.Model.Project;
import softpro.Persistence.Database.SqliteInterface;
import softpro.View.ActionOverProject;

public class ModifyProjectData implements ActionOverProject<Project> {
    
    private final SqliteInterface dbInterface = new SqliteInterface();
    
    public ModifyProjectData() {
    }

    @Override
    public boolean execute(Project project, HashMap<String, String> arguments) {
        HashMap<String, Object> arg = castToObject(arguments);
        if (new CreateProject().checkAvailability(arguments.get("name"))){
            dbInterface.update("projects", arg, "name = '" + project.getName() + "'");
            project.setName(arguments.get("name"));
            return true;
        }
        return false;
    }

    private HashMap<String, Object> castToObject(HashMap<String, String> arguments) {
        HashMap<String, Object> argumentsToObject = new HashMap<>();
        for (Map.Entry<String, String> pair : arguments.entrySet()) {
            argumentsToObject.put(pair.getKey(), pair.getValue());
        }
        return argumentsToObject;
    }
    
}
