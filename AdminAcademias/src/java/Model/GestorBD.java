package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.LinkedList;

/**
 *
 * @author Chriss Yañez
 */
public class GestorBD {

    private static Connection conect = null;
    private static CallableStatement cst;
    private static String sql;
    private static ResultSet rs;

    public static void connect() {
        try {
            conect = (conect == null || conect.isClosed()) ? ConectarBD.Conect() : conect;
        } catch (Exception e) {
            System.err.println("error al conectar");
        }
    }
    
    public static void cerrarConecion() {
        try {
            conect.close();
        } catch (Exception e) {
            
        }
    }

    public static int cerrarSesion(String mat, String cip) {
        try {
            connect();
            sql = "{call dbo.sp_cerrarSesion (?,?,?)}";
            cst = conect.prepareCall(sql);
            cst.setString(1, mat);
            cst.setString(2, cip);
            cst.registerOutParameter(3, Types.INTEGER);
            cst.execute();
            return cst.getInt(3);
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
    
    public static int getIDUser(String mat, String cip) {
        try {
            connect();
            sql = "{call dbo.sp_getIDUser (?,?,?)}";
            cst = conect.prepareCall(sql);
            cst.setString(1, mat);
            cst.setString(2, cip);
            cst.registerOutParameter(3, Types.INTEGER);
            cst.execute();
            return cst.getInt(3);
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public static Object[] inicarSesion(String mat, String cip) {
        Object error[] = {"", ""};
        try {
            connect();
            sql = "{call dbo.sp_iniciar (?,?,?,?)}";
            cst = conect.prepareCall(sql);
            cst.setString(1, mat);
            cst.setString(2, cip);
            cst.registerOutParameter(3, Types.INTEGER);
            cst.registerOutParameter(4, Types.CHAR);
            cst.execute();
            error[0] = cst.getInt(3);
            error[1] = cst.getString(4);
        } catch (Exception e) {
            error[0] = e.toString();
            error[1] = "";
            System.err.println(e);
        }
        return error;
    }

    public static LinkedList<String> getCarreras() {
        try {
            connect();
            LinkedList<String> academias = new LinkedList();
            sql = "{call dbo.sp_getCarreras}";
            cst = conect.prepareCall(sql);
            rs = cst.executeQuery();
            while (rs.next()) {
                academias.add(rs.getString(1));
            }
            return academias;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public String Registro() {
        return "Registro Exitoso";
    }

}
