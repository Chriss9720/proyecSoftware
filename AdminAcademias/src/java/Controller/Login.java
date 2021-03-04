package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.GestorBD;

/**
 *
 * @author Chriss Yañez
 */
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        mantener(request, response, null, null);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String mat = toString(request.getParameter("matricula"));
        String cip = toString(request.getParameter("clave"));
        System.out.println(mat);
        Object[] results = GestorBD.inicarSesion(mat, cip);
        if (results[0] instanceof Integer) {
            switch (toInt(results[0])) {
                case -1:
                    mantener(request, response, null, "Usuario invalido");
                    break;
                case -2:
                    mantener(request, response, toString(results[1]), "Clave invalida");
                    break;
                case -3:
                    mantener(request, response, 
                            null, "Usuario y clave incorrectos");
                    break;
                case -4:
                    mantener(request, response,toString(results[1]), "El usuario no coincide con la clave");
                    break;
                case -5:
                    String id = toString(GestorBD.getIDUser(mat, cip));
                    response.sendRedirect("CerrarSesion?id=" + id);
                    break;
                default:
                    if (toInt(results[0]) > 0) {
                        response.sendRedirect("Menu?id=" + toString(results[0]));
                    }
            }
        } else {
            mantener(request, response, null, "Error en la base de datos");
        }
    }

    private void mantener(HttpServletRequest request, HttpServletResponse response, 
            String res, String error) {
        try {
            request.setAttribute("error", error);
            request.setAttribute("path", res);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            System.err.println("Error al manter el login: " + e);
        }
    }

    private String toString(Object obj) {
        return String.valueOf(obj);
    }

    private int toInt(Object obj) {
        return Integer.parseInt(toString(obj));
    }

}
