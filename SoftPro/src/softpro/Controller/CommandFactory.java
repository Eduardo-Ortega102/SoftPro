
package softpro.Controller;

import java.util.HashMap;
import softpro.Model.Project;
import softpro.Model.Scrum.ScrumProject;
import softpro.View.Operation;
import softpro.View.OperationType;
import static softpro.Persistence.IdGenerator.generateIdForTable;

public class CommandFactory {
    
    public static HashMap<OperationType, Operation> createCommanMap(){
        HashMap<OperationType, Operation> commandMap = new HashMap<>();
        
        commandMap.put(OperationType.ADD_STORY_TO_BACKLOG, new Operation<ScrumProject>() {
            @Override
            public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
                int id = generateIdForTable("features");
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        Project project = new ScrumProject(0, "prueba");
        commandMap.get(OperationType.ADD_STORY_TO_BACKLOG).execute(project, new HashMap());
        return commandMap;
    }

}
