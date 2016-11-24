package softpro.Persistence.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteConnection {

    public static Statement connect(String database) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection cn = DriverManager.getConnection("jdbc:sqlite:" + database);
            return cn.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("Controlador no válido");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
