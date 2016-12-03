package softpro.View;

public interface ActionSet {

    ActionOverProject getProjectAction(Operation operation);

    AdministrativeAction getAdministrativeAction(Operation operation);
}
