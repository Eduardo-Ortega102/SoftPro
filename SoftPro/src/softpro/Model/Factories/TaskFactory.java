package softpro.Model.Factories;

import softpro.Model.State;
import softpro.Model.Task;
import softpro.Model.User;

public interface TaskFactory {

    boolean delete(Task task);
    
    Task create(int id, String description);

    Task create(int id, String description, String details);

    Task create(int id, String description, String details, State state);

    Task create(int id, String description, String details, State state, User responsible);

    Task create(int id, String description, String details, State state, User responsible, int estimated_duration);

    Task create(int id, String description, String details, State state, User responsible, int estimated_duration, int real_duration);

}
