package softpro.Model.Factories;

import softpro.Model.State;
import softpro.Model.Scrum.UserStory;
import softpro.Model.User;

public interface UserStoryFactory {

    boolean delete(UserStory userStory);

    UserStory create(int id, String description);

    UserStory create(int id, String description, String details);

    UserStory create(int id, String description, String details, int points);

    UserStory create(int id, String description, String details, int points, int prioridad);

    UserStory create(int id, String description, String details, int points, int prioridad, State state);

    UserStory create(int id, String description, String details, int points, int prioridad, State state, User responsible);

}
