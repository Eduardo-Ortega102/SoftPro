package softpro.Persistence.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteInterface implements BDInterface {

    private final Statement statement;

    public SqliteInterface() {
        this.statement = SqliteConnection.connect("src/softpro/Persistence/Database/BDSoftpro.db");
    }

    @Override
    public List<String> selectFrom(String table, String[] params) {
        return selectFrom(table, params, null);
    }
    
    @Override
    public List<String> selectFrom(String table, String[] params, String where) {
         try{
            List<String> list = new ArrayList<>();
            String sql = generateSelect(params, table);
            
            if (where != null)sql += " WHERE "+where;
           
            return generateResultList(sql, list);
        }catch (SQLException ex) {
             ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public boolean insertInto(String table, Map<String, Object> mapa) {
        try {
            String sql = generateSql(table, mapa);
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqliteInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(String table, Map<String, Object> mapa, String where) {
        String sql = "UPDATE "+table+" SET";
        Set<String> keySet= mapa.keySet();
        for (String string : keySet){
            sql += " "+string +" = '"+mapa.get(string)+"',";
        }
        sql = sql.substring(0, sql.length()-1)+" where "+where;
        
        System.out.println(sql);
        
        try {
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }        
         
    }
    
        @Override
    public boolean deleteFrom(String table, String where) {
        String sql = "DELETE from "+table+" where "+where;
        try {
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }

    private List<String> generateResultList(String sql, List<String> list) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData rsm = rs.getMetaData();
        while (rs.next()){
            String texto = "";
            for (int i = 1; i <= rsm.getColumnCount(); i++)
                texto += rsm.getColumnName(i)+":  "+rs.getString(rsm.getColumnName(i))+"\n";
            list.add(texto);
        }
        return list;
    }

    private String generateSelect(String[] params, String table) {
        return isAll(params)? "SELECT * FROM "+table : insertParamsIntoQuery(params, table);
    }

    private String insertParamsIntoQuery(String[] params, String table) {
        String sql = "SELECT";
        for (String param : params) sql+= " "+param+",";
        sql = sql.substring(0, sql.length()-1) + " FROM "+table;
        return sql;
    }

    private static boolean isAll(String[] params) {
        return params.length == 1 && params[0] == "*";
    }
    
    private String generateSql(String table, Map<String, Object> mapa) {
        Set<String> keySet= mapa.keySet();
        String sql = writeSql(table, keySet, mapa);
        return sql;
    }

    private String writeSql(String table, Set<String> keySet, Map<String, Object> mapa) {
        String sql = "insert into "+table+"(";
        sql = insertFieldsInSql(keySet, sql);
        sql = insertValuesInSql(keySet, mapa, sql);
        return sql;
    }

    private String insertValuesInSql(Set<String> keySet, Map<String, Object> mapa, String sql) {
        for (String string : keySet) {
            Object value = mapa.get(string);
            if (value == null) sql += " NULL,";
            else sql += " '"+value.toString()+"',";
        }
        sql = sql.substring(0, sql.length()-1)+")";
        return sql;
    }

    private String insertFieldsInSql(Set<String> keySet, String sql) {
        for (String string : keySet) sql += string+",";
        sql = sql.substring(0, sql.length()-1)+") values(";
        return sql;
    }
    
}
