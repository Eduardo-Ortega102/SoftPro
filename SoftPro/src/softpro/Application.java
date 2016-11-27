package softpro;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import softpro.Model.IncrementalProject;
import softpro.Model.ScrumProject;
import softpro.Model.Sprint;
import softpro.Model.UseCase;
import softpro.Persistence.Database.SqliteInterface;
import static softpro.Persistence.IdGetter.IdGetter;

public class Application {

    public static void main(String[] args) {
//        ScrumProject scrumProject = new ScrumProject(123, "GS1 SCRUM - TEST");
//        scrumProject.saveProject();
        
        /*for (UseCase useCase : scrumProject.cases()) {
            
        }
        
        for (Sprint sprint : scrumProject) {
            
        }*/
        
    
        
        
        
        //IncrementalProject incrementalProject = new IncrementalProject(134, "GS1 INCREMENTAL - TEST");
        //incrementalProject.saveProject();
        new Application().start();
    }

    private void start() {
                    
            SqliteInterface sqliteInterface = new SqliteInterface();
            Map<String, Object> mapaValores = new HashMap<>();
            
            mapaValores.put("id", IdGetter("staff"));
            mapaValores.put("phone", "000000001");
            mapaValores.put("email", "minnie@gmail.com");
            mapaValores.put("name", "Minnie Mouse");
            sqliteInterface.insertInto("staff", mapaValores);
            
            
            String[] myStringArray = {"*"};
            List<String> result = sqliteInterface.selectFrom("staff", myStringArray);
            
            //result.stream().forEach((string) -> {
            //    System.out.println(string);
            //});

//            result = sqliteInterface.selectFrom("projects", myStringArray);
//            result.stream().forEach((string) -> {
//                System.out.println(string);
//            });
            
            /*sqliteInterface.deleteFrom("staff", "id = 4");
            Map<String, Object> mapaValores = new HashMap<>();
            mapaValores.put("nombre", "HDP");
            sqliteInterface.update("staff", mapaValores, "nombre = 'Donald'");
            result = sqliteInterface.selectFrom("staff", myStringArray);

            for (String string : result)
            System.out.println(string);
            */
    }

}
