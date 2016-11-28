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
//        Map<String, Object> mapaValores = new HashMap<>();
//
//        mapaValores.put("id", IdGetter("staff"));
//        mapaValores.put("phone", "000000999");
//        mapaValores.put("email", "Simba@gmail.com");
//        mapaValores.put("name", "Simba Pradera");
//        sqliteInterface.insertInto("staff", mapaValores);
//
        String[] all = {"*"};
//        List<HashMap<String, String>> result = sqliteInterface.selectFrom("staff", all);
//        for (HashMap<String, String> hashMap : result) {
//            for (String key : hashMap.keySet()) {
//                System.out.println(key + "---->" + hashMap.get(key));
//            }
//            System.out.println("\n");
//        }

//        result.stream().forEach((string) -> {
//            System.out.println(string);
//        });
//            result = sqliteInterface.selectFrom("projects", myStringArray);
//            result.stream().forEach((string) -> {
//                System.out.println(string);
//            });
        List<HashMap<String, String>> result = sqliteInterface.selectFrom("staff", all, "id = 5");

        for (HashMap<String, String> hashMap : result) {
            for (String key : hashMap.keySet()) {
                System.out.println(key + "---->" + hashMap.get(key));
            }
            System.out.println("\n");
        }

    }

}
