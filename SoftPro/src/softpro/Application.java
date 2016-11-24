package softpro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import softpro.Persistence.Database.SqliteInterface;

public class Application {

    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {
                    
            SqliteInterface sqliteInterface = new SqliteInterface();
            
            Map<String, Object> mapaValores = new HashMap<>();
            mapaValores.put("id", null);
            mapaValores.put("telefono", 000000165);
            mapaValores.put("mail", "00001@gmail.com");
            mapaValores.put("nombre", "Donald Duck");
            sqliteInterface.insertInto("staff", mapaValores);
            
            
            String[] myStringArray = {"*"};
            List<String> result = sqliteInterface.selectFrom("staff", myStringArray);
            
            for (String string : result) {
                System.out.println(string);
            }
     //       sqliteInterface.deleteFrom("staff", "id = 4");
 //           Map<String, Object> mapaValores = new HashMap<>();
   //         mapaValores.put("nombre", "HDP");
            
     //       sqliteInterface.update("staff", mapaValores, "nombre = 'Donald'");
            
       //     result = sqliteInterface.selectFrom("staff", myStringArray);
         //   for (String string : result) System.out.println(string);
    }

}
