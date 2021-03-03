package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chriss Yañez
 */
public class ConectarBD {

    private static Connection conect = null;
    private static final String local = "jdbc:sqlserver://localhost:1433;";
    private static final String BD = "database=AdmonAcademias;";
    private static final String user = "Laithg";
    private static final String pass = "0279";

    public static Connection Conect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");                    
            String connectionUrl = local + BD;
            conect = DriverManager.getConnection(connectionUrl, user, pass);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectarBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conect;
    }

    public static void cerrar() {
        try {
            if (conect != null) {
                conect.close();
            }
        } catch (SQLException e) {
            System.out.println("No se cerro la conexcion " + e);
        }
    }

}
