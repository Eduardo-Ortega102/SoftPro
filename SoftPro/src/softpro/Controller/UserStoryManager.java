
package softpro.Controller;

import java.util.List;
import softpro.Model.Project;
import softpro.Model.UserStory;
import softpro.Persistence.ObjectManager;

public class UserStoryManager implements ObjectManager<UserStory, Project>{
    
    private final Project project;

    public UserStoryManager(Project project) {
        this.project = project;
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
