package softpro.Model.Scrum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import softpro.Model.Factories.UserStoryFactory;
import softpro.Model.State;
import softpro.Model.User;

public class ProductBacklog implements Iterable<UserStory>, UserStoryFactory {

    private final List<UserStory> stories;

    public ProductBacklog() {
        this.stories = new ArrayList<>();
    }

    @Override
    public Iterator<UserStory> iterator() {
        return this.stories.iterator();
    }

    @Override
    public UserStory create(int id, String description) {
        return create(id, description, "", 0, 0, State.ToDo, null);
    }

    @Override
    public UserStory create(int id, String description, String details) {
        return create(id, description, details, 0, 0, State.ToDo, null);
    }

    @Override
    public UserStory create(int id, String description, String details, int points) {
        return create(id, description, details, points, 0, State.ToDo, null);
    }

    @Override
    public UserStory create(int id, String description, String details, int points, int prioridad) {
        return create(id, description, details, points, prioridad, State.ToDo, null);
    }

    @Override
    public UserStory create(int id, String description, String details, int points, int prioridad, State state) {
        return create(id, description, details, points, prioridad, state, null);
    }

    @Override
    public UserStory create(int id, String description, String details, int points, int prioridad, State state, User responsible) {
        UserStory story = new UserStory(id, description, details, points, prioridad, state, responsible);
        stories.add(story);
        return story;
    }

    @Override
    public boolean delete(UserStory userStory) {
        return this.stories.remove(userStory);
    }

    public UserStory findStory(int id) {
        for (UserStory story : stories)
            if (story.getId() == id) return story;
        return null;
    }
    
    public String findIdStoryByDescription(String description) {
        for (UserStory story : stories)
            if (story.getDescription().equals(description)) return String.valueOf(story.getId());
        return null;
    }

}
