package softpro.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import softpro.Model.Factories.UserStoryFactory;

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
        return create(id, description, "", 0, 0, State.ToDo);
    }

    @Override
    public UserStory create(int id, String description, String details) {
        return create(id, description, details, 0, 0, State.ToDo);
    }

    @Override
    public UserStory create(int id, String description, String details, int points) {
        return create(id, description, details, points, 0, State.ToDo);
    }

    @Override
    public UserStory create(int id, String description, String details, int points, int prioridad) {
        return create(id, description, details, points, prioridad, State.ToDo);
    }

    @Override
    public UserStory create(int id, String description, String details, int points, int prioridad, State state) {
        UserStory story = new UserStory(description, details, points, id, prioridad, state);
        stories.add(story);
        return story;
    }

    @Override
    public boolean delete(UserStory userStory) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
