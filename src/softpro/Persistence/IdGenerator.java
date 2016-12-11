package softpro.Persistence;

import java.util.HashMap;
import java.util.List;
import softpro.Persistence.Database.SqliteInterface;
import static java.lang.Integer.valueOf;

public class IdGenerator {

    public static int generateNewIdForTable(String table) {
        SqliteInterface sqliteInterface = new SqliteInterface();
        String[] max_id = {"MAX(id)"};
        List<HashMap<String, String>> result = sqliteInterface.selectFrom(table, max_id);
        int maxValue = 0;
        if (result.size() == 1){
            maxValue = result.get(0).get("MAX(id)") == null ? 0 : valueOf(result.get(0).get("MAX(id)"));
        }
        return (maxValue + 1);
    }
}
