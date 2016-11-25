package softpro.Model;

public class IncrementalProject extends Project{
    
    public IncrementalProject(int id, String name) {
        super(id, name);
    }

    @Override
    public String getType() {
        return "Incremental";
    }
    
    
}
