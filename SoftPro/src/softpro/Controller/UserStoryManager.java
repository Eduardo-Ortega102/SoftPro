
package softpro.Controller;

import java.util.List;
import softpro.Model.Factories.UserStoryFactory;
import softpro.Model.Project;
import softpro.Model.State;
import softpro.Model.UserStory;
import softpro.Persistence.ObjectManager;

public class UserStoryManager implements UserStoryFactory, ObjectManager<UserStory, Project>{
    
    private final Project project;

    public UserStoryManager(Project project) {
        this.project = project;
    }

    @Override
    public UserStory create(String description, String details) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public UserStory create(int id, String description, String details) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public UserStory create(int id, String description, String details, int points) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public UserStory create(int id, String description, String details, int points, int prioridad) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public UserStory create(int id, String description, String details, int points, int prioridad, State state) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<UserStory> loadAll() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<UserStory> loadRelatedWith(Project record) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public UserStory load(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean exist(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean insert(UserStory element) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean update(UserStory element) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean delete(UserStory element) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
