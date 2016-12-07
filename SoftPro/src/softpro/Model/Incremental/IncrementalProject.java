package softpro.Model.Incremental;

import softpro.Model.Project;
import softpro.Model.User;

public class IncrementalProject extends Project{
    
    public IncrementalProject(int id, String name) {
        super(id, name);
    }

    @Override
    public String getType() {
        return "Incremental";
    }

    @Override
    public void addUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void removeUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
