package softpro.Model;

import java.util.HashMap;
import java.util.Map;
import softpro.Persistence.Database.SqliteInterface;

public class IncrementalProject extends Project{
    
    public IncrementalProject(String name) {
        super(name);
    }
    
    //TODO - Check ID
    public void saveProject(){
        SqliteInterface sqliteInterface = new SqliteInterface();
        Map<String, Object> mapaValores = new HashMap<>();    
        mapaValores.put("id", 0);
        mapaValores.put("nombre", name);
        mapaValores.put("tipo", "Incremental");
        sqliteInterface.insertInto("project", mapaValores);  
    }
}
