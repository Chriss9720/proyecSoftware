package Controller;

import Model.GestorBD;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chriss Yañez
 */
public class CerrarSesion extends HttpServlet {

    private String id = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        id = request.getParameter("id");
        processRequest(request, response);
        mantener(request, response, null);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String psw = request.getParameter("pasw");
        int cerrar = GestorBD.cerrarSesion(id, psw);
        GestorBD.cerrarConecion();
        switch (cerrar) {
            case -1:
                mantener(request, response, "Contraseña Incorrecta");
                break;
            case 1:
                response.sendRedirect("AdministracionAcademias");
                break;
            default:
                mantener(request, response, "Error desconocido...");
        }
    }

    private void mantener(HttpServletRequest request, HttpServletResponse response,
            String msj) {
        try {
            request.setAttribute("id", id);
            request.setAttribute("msj", msj);
            request.getRequestDispatcher("/CerrarSesion.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro al mantener CerrarSesion: " + e);
        }
    }

}
