package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Controller.Login;
import java.util.LinkedList;
import Model.GestorBD;
import Model.User;
import Controller.Login;

public final class Registro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \n");
      out.write("    \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("    ");

        String id = String.valueOf(request.getAttribute(""));
    
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"src/clases.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"src/load.css\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("            <script type=\"text/javascript\" src=\"src/scripts.js\"></script>\n");
      out.write("            <title>Administraci&oacute;n de Academias</title>\n");
      out.write("    </head>\n");
      out.write("    ");

        String path;
        User user = null;
        try {
            user = (User) (request.getAttribute("User"));
            if (user != null && user.getFile() != null && !user.getFile().isEmpty()) {
                path = user.getFile().replace("/", "\\");
            } else {
                path = "src/perfilazul.png";
            }
        } catch (Exception e) {
            path = "src/perfilazul.png";
        }
        int p = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '\\' || path.charAt(i) == '/') {
                p = i;
            }
        }
        path = "src/" + path.substring((p + 1), path.length());
        String mat = (user.getMat() != null) ? user.getMat() : "";
        String nombre = (user.getNombre() != null) ? user.getNombre() : "";
        String app = (user.getApellidoP() != null) ? user.getApellidoP() : "";
        String apm = (user.getApelleidoM() != null) ? user.getApelleidoM() : "";
        String correo = (user.getCorreo() != null) ? user.getCorreo() : "";
        String cip = (user.getCip() != null) ? user.getCip() : "";
        String carrera = (user.getCarrera() != null) ? user.getCarrera() : "";
        String academia = (user.getAcademia() != null) ? user.getAcademia() : "";
        String puesto = (user.getPuesto() != null) ? user.getPuesto() : "";
    
      out.write("\n");
      out.write("    <body onload=\"realizarValidaciones('");
      out.print(mat);
      out.write("', '");
      out.print(nombre);
      out.write("',\n");
      out.write("                    '");
      out.print(app);
      out.write("', '");
      out.print(apm);
      out.write("', '");
      out.print(correo);
      out.write("', '");
      out.print(cip);
      out.write("')\">\n");
      out.write("        <div class=\"rcorners1\" id=\"contenedor\">\n");
      out.write("            <p1 class=\"subtitle font\">Ingrese la informaci&oacute;n:</p1>\n");
      out.write("            <input class=\"button button1Eliminar\" type=\"button\" value=\"Regresar\" onclick=\"cambiar('Menu.jsp')\"/>\n");
      out.write("            <form class=\"font\" action=\"Registro\" method=\"post\" enctype=\"multipart/form-data\" >\n");
      out.write("                <input name=\"paso\" id=\"flag\" hidden=\"true\"/>\n");
      out.write("                <img id=\"fotoPerfil\" class=\"imgRedonda\" src=\"");
      out.print( path);
      out.write("\" alt=\"not found\" />\n");
      out.write("                <table id=\"tablaCont\" cellspacing=\"3\" cellpadding=\"3\" class=\"cuerpo\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <label class=\"contenido\">Matricula:</label>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <input id=\"inputMatricula\" name=\"matricula\" type=\"text\" \n");
      out.write("                                   minlength=\"8\" maxlength=\"8\" class=\"contenido\" \n");
      out.write("                                   required value=\"");
      out.print( mat);
      out.write("\"\n");
      out.write("                                   onkeyup=\"validarMatricula(this.value, 'errorMatricula', 'labelErrorerrorMatricula', 0)\" />\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr id=\"errorMatricula\" class=\"therror\" hidden=\"true\">\n");
      out.write("                        <td/>\n");
      out.write("                        <td> \n");
      out.write("                            <label id=\"labelErrorerrorMatricula\" class=\"error\"></label>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <label class=\"contenido\">Nombre(s):</label>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <input id=\"inputNombre\" name=\"nombres\" type=\"text\" \n");
      out.write("                                   class=\"contenido\" required value=\"");
      out.print( nombre);
      out.write("\"\n");
      out.write("                                   onkeyup=\"contieneNumeros(this.value, 'errorNombre', 'labelErrorNombre', 1)\" />\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr id=\"errorNombre\" class=\"therror\" hidden=\"true\">\n");
      out.write("                        <td/>\n");
      out.write("                        <td> \n");
      out.write("                            <label id=\"labelErrorNombre\" class=\"error\"></label>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <label class=\"contenido\">Apellido Paterno:</label>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <input required id=\"inputApeP\" name=\"apellidoP\" type=\"text\" \n");
      out.write("                                   class=\"contenido\" value=\"");
      out.print( app);
      out.write("\"\n");
      out.write("                                   onkeyup=\"contieneNumeros(this.value, 'errorApellidoP', 'labelErrorApellidoP', 2)\" />\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr id=\"errorApellidoP\" class=\"therror\" hidden=\"true\">\n");
      out.write("                        <td/>\n");
      out.write("                        <td> \n");
      out.write("                            <label id=\"labelErrorApellidoP\" class=\"error\"></label>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label class=\"contenido\">Apellido Materno:</label></td>\n");
      out.write("                        <td><input id=\"inputApM\" required name=\"apellidoM\" type=\"text\" \n");
      out.write("                                   class=\"contenido\" value=\"");
      out.print( apm);
      out.write("\"\n");
      out.write("                                   onkeyup=\"contieneNumeros(this.value, 'errorApellidoM', 'labelErrorApellidoM', 3)\" />\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr id=\"errorApellidoM\" class=\"therror\" hidden=\"true\">\n");
      out.write("                        <td/>\n");
      out.write("                        <td> \n");
      out.write("                            <label id=\"labelErrorApellidoM\" class=\"error\"></label>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label class=\"contenido\">Correo Institucional:</label></td>\n");
      out.write("                        <td>\n");
      out.write("                            <input id=\"inputCorreo\" required name=\"correo\" type=\"text\" \n");
      out.write("                                   class=\"contenido\" value=\"");
      out.print( correo);
      out.write("\"\n");
      out.write("                                   onkeyup=\"validarCorreo(this.value, 'errorCorreo', 'labelErrorCorreo')\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr id=\"errorCorreo\" class=\"therror\" hidden=\"true\">\n");
      out.write("                        <td/>\n");
      out.write("                        <td> \n");
      out.write("                            <label id=\"labelErrorCorreo\" class=\"error\"></label>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label class=\"contenido\">CIP:</label></td>\n");
      out.write("                        <td><input required name=\"cip\" type=\"text\" class=\"contenido\" \n");
      out.write("                                   minlength=\"5\" maxlength=\"5\" id=\"inputCip\" value=\"");
      out.print(cip);
      out.write("\"\n");
      out.write("                                   onkeyup=\"validarCIP(this.value, 'errorCIP', 'labelErrorIP')\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr id=\"errorCIP\" class=\"therror\" hidden=\"true\">\n");
      out.write("                        <td/>\n");
      out.write("                        <td> \n");
      out.write("                            <label id=\"labelErrorIP\" class=\"error\"></label>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label class=\"contenido\">Carrera:</label></td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"carrera\" class=\"contenido\" id=\"SelectCarrera\"\n");
      out.write("                                    onclick=\"validarSelect(this.value, 'errorSelectCarrera', 'labelErrorSelectCarrera', 6)\">\n");
      out.write("                                ");

                                    if (carrera.equals("0") || carrera.length() == 0) {
                                
      out.write("\n");
      out.write("                                <option value=\"0\">Selecione una</option>\n");
      out.write("                                ");

                                } else {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( carrera);
      out.write('"');
      out.write('>');
      out.print( carrera);
      out.write("</option>\n");
      out.write("                                ");

                                    }
                                    LinkedList<String> carr = GestorBD.getCarreras();
                                    carr = (carr != null) ? carr : new LinkedList();
                                    for (int i = 0; i < carr.size(); i++) {
                                        if (carrera.isEmpty()
                                                || (!carrera.isEmpty()
                                                && !carrera.equals(carr.get(i)))) {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( carr.get(i));
      out.write('"');
      out.write('>');
      out.print( carr.get(i));
      out.write("</option>\n");
      out.write("                                ");

                                        }
                                    }
                                
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr id=\"errorSelectCarrera\" class=\"therror\" hidden=\"true\">\n");
      out.write("                        <td/>\n");
      out.write("                        <td> \n");
      out.write("                            <label id=\"labelErrorSelectCarrera\" class=\"error\"></label>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label class=\"contenido\">Academia:</label></td>\n");
      out.write("                        <td>\n");
      out.write("                            <select id=\"academia\" class=\"contenido\" name=\"aca\"\n");
      out.write("                                    onclick=\"validarSelect(this.value, 'errorSelectAcademia', 'labelErrorAcademia', 7)\">\n");
      out.write("                                ");

                                    if (academia.equals("0") || academia.length() == 0) {
                                
      out.write("\n");
      out.write("                                <option value=\"0\">Selecione una</option>\n");
      out.write("                                ");

                                } else {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( academia);
      out.write('"');
      out.write('>');
      out.print( academia);
      out.write("</option>\n");
      out.write("                                ");

                                    }
                                    LinkedList<String> acad = GestorBD.getCarreras();
                                    acad = (acad != null) ? acad : new LinkedList();
                                    for (int i = 0; i < acad.size(); i++) {
                                        if (academia.isEmpty()
                                                || (!academia.isEmpty()
                                                && !academia.equals(acad.get(i)))) {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( acad.get(i));
      out.write('"');
      out.write('>');
      out.print( acad.get(i));
      out.write("</option>\n");
      out.write("                                ");

                                        }
                                    }
                                
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr id=\"errorSelectAcademia\" class=\"therror\" hidden=\"true\">\n");
      out.write("                        <td/>\n");
      out.write("                        <td> \n");
      out.write("                            <label id=\"labelErrorAcademia\" class=\"error\"></label>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label class=\"contenido\">Puesto en la academia:</label></td>\n");
      out.write("                        <td>\n");
      out.write("                            <select id=\"puessto\" class=\"contenido\" name=\"puesto\"\n");
      out.write("                                    onclick=\"validarSelect(this.value, 'errorSelectPuesto', 'labelErrorPuesto', 8)\">\n");
      out.write("                                ");

                                    if (puesto.equals("0") || puesto.length() == 0) {
                                
      out.write("\n");
      out.write("                                <option value=\"0\">Selecione una</option>\n");
      out.write("                                ");

                                } else {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( puesto);
      out.write('"');
      out.write('>');
      out.print( puesto);
      out.write("</option>\n");
      out.write("                                ");

                                    }
                                    LinkedList<String> puestos = GestorBD.getCarreras();
                                    puestos = (puestos != null) ? puestos : new LinkedList();
                                    for (int i = 0; i < puestos.size(); i++) {
                                        if (puesto.isEmpty()
                                                || (!puesto.isEmpty()
                                                && !puesto.equals(puestos.get(i)))) {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( puestos.get(i));
      out.write('"');
      out.write('>');
      out.print( puestos.get(i));
      out.write("</option>\n");
      out.write("                                ");

                                        }
                                    }
                                
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr id=\"errorSelectPuesto\" class=\"therror\" hidden=\"true\">\n");
      out.write("                        <td/>\n");
      out.write("                        <td> \n");
      out.write("                            <label id=\"labelErrorPuesto\" class=\"error\"></label>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                <input class=\"button button1\" type=\"button\" value=\"Cancelar\" onclick=\"cancelarRegistro()\" />\n");
      out.write("                <input class=\"button button2\" type=\"submit\" value=\"Registrar\" onclick=\"validarRegistro()\" />\n");
      out.write("            </form>\n");
      out.write("            <form method=\"post\" enctype=\"multipart/form-data\" >\n");
      out.write("                <input name=\"pasoFoto\" id=\"flagFoto\" hidden=\"true\"/>\n");
      out.write("                <input id=\"upfile\" class=\"file\" type=\"file\" name=\"upfile\" size=\"50\" accept=\"image/*\"/>\n");
      out.write("                <input class=\"button subirImg\" type=\"submit\" value=\"Sublir\" onclick=\"subirImg('upfile')\"/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"rcorners2\">\n");
      out.write("            <h1 class=\"title font\">Registro de Personal</h1>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
