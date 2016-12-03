package softpro.View;

public interface ActionSet {

    ActionOverProject getProjectOperation(Operation operation);

    AdministrativeAction getAdministrativeOperation(Operation operation);
}
