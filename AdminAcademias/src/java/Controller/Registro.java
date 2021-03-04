package Controller;

import Model.User;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Chriss Yañez
 */
@MultipartConfig
public class Registro extends HttpServlet {

    private User user;

    public Registro() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (user == null) {
            user = new User();
        }
        if (ServletFileUpload.isMultipartContent(request) &&
                toString(request.getParameter("pasoFoto")).equals("0")) {
            try {
                Part ParteDelArchivo = request.getPart("upfile");
                ServletContext sc = this.getServletContext();
                String path = sc.getRealPath("/src/Hector.png");
                path = path.replace("\\", "/").replace("/build", "");
                File file = new File(path);
                FileOutputStream fo = new FileOutputStream(file);
                InputStream fileContent = ParteDelArchivo.getInputStream();
                OutputStream os = new BufferedOutputStream(fo);
                byte[] chunk = new byte[1024 * 4];
                int bytesLeidos;
                while ((bytesLeidos = fileContent.read(chunk)) > 0) {
                    os.write(chunk, 0, bytesLeidos);
                }
                espera(5000);
                user.setFile(path);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        if (user != null) {
            request.setAttribute("User", user);
        }
        switch (toString(request.getParameter("paso"))) {
            case "0":
                user.setMat(toString(request.getParameter("matricula")));
                user.setNombre(toString(request.getParameter("nombres")));
                user.setApellidoP(toString(request.getParameter("apellidoP")));
                user.setApelleidoM(toString(request.getParameter("apellidoM")));
                user.setCorreo( toString(request.getParameter("correo")));
                user.setCip(toString(request.getParameter("cip")));
                user.setCarrera(toString(request.getParameter("carrera")));
                user.setAcademia(toString(request.getParameter("aca")));
                user.setPuesto(toString(request.getParameter("puesto")));
                mantener(request,response);
                break;
            case "1":
                user = new User();
                request.setAttribute("User", user);
                mantener(request,response);
                break;
            default:
                mantener(request,response);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void espera(long min) {
        try {
            Thread.sleep(min);
        } catch (InterruptedException e) {
        }
    }

    private void mantener(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/Registro.jsp").forward(request, response);
        } catch (Exception e) {
            System.err.println("Error al manter el registro: " + e);
        }
    }
    
    private String toString(Object obj) {
        return String.valueOf(obj);
    }
    
}
