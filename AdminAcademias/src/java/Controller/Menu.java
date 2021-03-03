package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chriss Yañez
 */
public class Menu extends HttpServlet {

    private String id = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (id == null) {
            id = request.getParameter("id");
        }
        if (request.getParameter("reg") != null) {
            response.sendRedirect("Registro?id=" + id);
        } else if (request.getParameter("mod") != null) { 
            System.out.println("A mod");
            mantener(request, response);
        } else if (request.getParameter("eli") != null) { 
            response.sendRedirect("Eliminar?id=" + id);
        } else if (request.getParameter("vis") != null) { 
            response.sendRedirect("Visualizar");
            mantener(request, response);
        } else {
            mantener(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void mantener(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/Menu.jsp").forward(request, response);
        } catch (Exception e) {
            System.err.println("Error al manter el login: " + e);
        }
    }

}
