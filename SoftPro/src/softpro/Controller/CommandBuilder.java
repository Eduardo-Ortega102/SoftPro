package softpro.Controller;

import java.util.HashMap;
import softpro.Model.Scrum.ScrumProject;
import softpro.View.Operation;
import static softpro.Persistence.IdGenerator.generateNewIdForTable;
import softpro.View.Action;

public class CommandBuilder {

    public static HashMap<Operation, Action> createCommands() {
        HashMap<Operation, Action> commandMap = new HashMap<>();
        
        commandMap.put(Operation.ADD_STORY_TO_BACKLOG, new Action<ScrumProject>() {
            @Override
            public boolean execute(ScrumProject project, HashMap<String, String> arguments) {
                int id = generateNewIdForTable("features");
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        commandMap.put(Operation.ADD_STORY_TO_BACKLOG, (Action<ScrumProject>) (project, arguments) -> {
            int id = generateNewIdForTable("features");
            throw new UnsupportedOperationException("Not supported yet.");
        });

        commandMap.get(Operation.ADD_STORY_TO_BACKLOG).execute(new ScrumProject(0, "prueba"), new HashMap());
        return commandMap;
    }

}
