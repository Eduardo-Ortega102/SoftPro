package softpro.Controller;

import softpro.Controller.Operations.*;
import java.util.HashMap;
import java.util.Map;
import softpro.View.Operation;
import softpro.View.ActionOverProject;
import softpro.View.ActionSet;
import softpro.View.AdministrativeAction;

public class CommandSet implements ActionSet {

    private final Map<Operation, ActionOverProject> commandsOverProject;
    private final Map<Operation, AdministrativeAction> administrativeCommands;

    public CommandSet() {
        this.commandsOverProject = new HashMap<>();
        this.administrativeCommands = new HashMap<>();
        addProjectCommands();
        addAdministrativeCommands();
    }

    private void addProjectCommands() {
        commandsOverProject.put(Operation.ADD_PREDECESSOR_OF_STORY, new AddPredecessorOfStory());
        commandsOverProject.put(Operation.ADD_STORY_TO_BACKLOG, new AddStoryToBacklog());
        commandsOverProject.put(Operation.ADD_STORY_TO_SPRINT, new AddStoryToSprint());
        commandsOverProject.put(Operation.ADD_USER_TO_TEAM, new AddUserToTeam());

        commandsOverProject.put(Operation.CREATE_SPRINT, new CreateSprint());
        commandsOverProject.put(Operation.CREATE_RISK, new CreateRisk());

        commandsOverProject.put(Operation.MODIFY_PROJECT_DATA, new ModifyProjectData());
        commandsOverProject.put(Operation.MODIFY_RISK, new ModifyRisk());
        commandsOverProject.put(Operation.MODIFY_STORY, new ModifyStory());

        commandsOverProject.put(Operation.DELETE_RISK, new DeleteRisk());
        commandsOverProject.put(Operation.DELETE_SPRINT, new DeleteSprint());
        commandsOverProject.put(Operation.DELETE_STORY, new DeleteStory());

        commandsOverProject.put(Operation.REMOVE_PREDECESSOR_OF_STORY, new RemovePredecessorOfStory());
        commandsOverProject.put(Operation.REMOVE_STORY_FROM_SPRINT, new RemoveStoryFromSprint());
        commandsOverProject.put(Operation.REMOVE_USER_FROM_TEAM, new RemoveUserFromTeam());
    }

    private void addAdministrativeCommands() {
        administrativeCommands.put(Operation.CREATE_PROJECT, new CreateProject());
        administrativeCommands.put(Operation.CREATE_USER, new CreateUser());
        administrativeCommands.put(Operation.MODIFY_USER, new ModifyUser());
        administrativeCommands.put(Operation.DELETE_PROJECT, new DeleteProject());
        administrativeCommands.put(Operation.DELETE_USER, new DeleteUser());
    }

    @Override
    public ActionOverProject getProjectOperation(Operation operation) {
        return commandsOverProject.get(operation);
    }

    @Override
    public AdministrativeAction getAdministrativeOperation(Operation operation) {
        return administrativeCommands.get(operation);
    }
    
}