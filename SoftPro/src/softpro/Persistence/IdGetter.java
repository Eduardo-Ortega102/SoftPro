package softpro.Persistence;

import java.util.List;
import softpro.Persistence.Database.SqliteInterface;

public class IdGetter {
    
    public static int IdGetter(String table){
        SqliteInterface sqliteInterface = new SqliteInterface();
        String[] all = {"*"};
        List<String> result = sqliteInterface.selectFrom(table, all);
        int maxValue = 0;
        
        for(int i=0;i<result.size();i++){
            if(Integer.valueOf(result.get(i).substring(5, result.get(i).indexOf
("\n"))) > maxValue) {
                    maxValue = Integer.valueOf(result.get(i).substring(5, result.get
(i).indexOf("\n")));
                }
        }
        return (maxValue+1);
    }
}