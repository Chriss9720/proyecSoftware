package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedList;

public final class Eliminar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"src/clases.css\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <script type=\"text/javascript\" src=\"src/scripts.js\"></script>\n");
      out.write("        <title>Administraci&oacute;n de Academias</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            LinkedList<Object> carreras = new LinkedList();
            LinkedList<Object> academias = new LinkedList();
            LinkedList<Object[]> usuarios = new LinkedList();
            String del = (request.getParameter("del") != null)
                    ? request.getParameter("del") : "";  
            if (carreras.isEmpty()) {
                carreras.add("ISC");
                carreras.add("IGE");
                carreras.add("ARQ");
                carreras.add("TODAS LAS CARRERAS");
                usuarios.add(new Object[]{"18130145", "Hector Castro", "ISC", "Ingenieria en sistemas", "Hector.png"});
                usuarios.add(new Object[]{"18130159", "Yañez Christian", "ISC", "Ingenieria en sistemas", "imagen.png"});
                usuarios.add(new Object[]{"18130405", "Sergio Guerra", "ISC", "Ingenieria en sistemas", "perfilazul.png"});
                academias.add("Ingenieria en sistemas");
                academias.add("Mecanica");
            }
            boolean de = true;
            for (int i = 0; i < usuarios.size() && de; i++) {
                if (usuarios.get(i)[0].equals(del)) {
                    usuarios.remove(i);
                    de = !de;
                }
            }
            String mat = (request.getParameter("SeacrchMat") != null)
                    ? request.getParameter("SeacrchMat") : "";
            String name = (request.getParameter("SearchName") != null)
                    ? request.getParameter("SearchName") : "";
            String carrera = (request.getParameter("SearchCarr") != null)
                    ? request.getParameter("SearchCarr") : "";
            String academia = (request.getParameter("SearchAca") != null)
                    ? request.getParameter("SearchAca") : "";
        
      out.write("\n");
      out.write("        <div class=\"fijadoEliminar\">\n");
      out.write("            \n");
      out.write("            <form class=\"font\" action=\"BuscarEliminar\" method=\"get\">\n");
      out.write("                <table cellspacing=\"10\" cellpadding=\"3\" class=\"BusquedaEliminar\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label class=\"contenidoBusqueda\">Nombre(s):</label></td>\n");
      out.write("                        <td><label class=\"contenidoBusqueda\">Carrera:</label></td>\n");
      out.write("                        <td><label class=\"contenidoBusqueda\">Academia:</label></td>\n");
      out.write("                        <td><label class=\"contenidoBusqueda\">Matricula:</label></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input name=\"SearchName\" type=\"text\" class=\"contenidoBusqueda\"\n");
      out.write("                                   value=\"");
      out.print( name);
      out.write("\"/></td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"SearchCarr\" class=\"contenidoBusqueda\">\n");
      out.write("                                ");

                                    if (!carrera.isEmpty()) {
                                
      out.write("\n");
      out.write("                                <option>");
      out.print( carrera);
      out.write("</option>\n");
      out.write("                                ");

                                } else {
                                
      out.write("\n");
      out.write("                                <option value =\"\">Seleciona una</option>\n");
      out.write("                                ");

                                    }
                                    for (int i = 0; i < carreras.size(); i++) {
                                        if (carrera.isEmpty() || (!carrera.isEmpty()
                                                && !carrera.equals(carreras.get(i)))) {
                                
      out.write("\n");
      out.write("                                <option>");
      out.print( carreras.get(i));
      out.write("</option>\n");
      out.write("                                ");

                                        }
                                    }
                                
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </td> \n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"SearchAca\" class=\"contenidoBusqueda\">\n");
      out.write("                                ");

                                    if (!academia.isEmpty()) {
                                
      out.write("\n");
      out.write("                                <option>");
      out.print( academia);
      out.write("</option>\n");
      out.write("                                ");

                                } else {
                                
      out.write("\n");
      out.write("                                <option value =\"\">Seleciona una</option>\n");
      out.write("                                ");

                                    }
                                    for (int i = 0; i < academias.size(); i++) {
                                        if (academia.isEmpty() || (!academia.isEmpty()
                                                && !academia.equals(academias.get(i)))) {
                                
      out.write("\n");
      out.write("                                <option>");
      out.print( academias.get(i));
      out.write("</option>\n");
      out.write("                                ");

                                        }
                                    }
                                
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                        </td> \n");
      out.write("                        <td><input id=\"sMat\" name=\"SeacrchMat\" type=\"text\" \n");
      out.write("                                   class=\"contenidoBusqueda\" value=\"");
      out.print( mat);
      out.write("\"/>\n");
      out.write("                        </td> \n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                <input class=\"button buttonBuscar\" type=\"submit\" value=\"Buscar\"/>\n");
      out.write("                <input class=\"button buttonLimpiar\" type=\"button\" value=\"Limpiar\" onclick=\"cambiar('Eliminar')\"/>\n");
      out.write("                <input class=\"button button1Eliminar\" type=\"button\" value=\"Regresar\" onclick=\"cambiar('Menu.jsp')\"/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"rcornersEliminar\">\n");
      out.write("            <scroll-container>\n");
      out.write("                <scroll-page>\n");
      out.write("                    <form class=\"font\" action=\"Eliminar\" method=\"post\">\n");
      out.write("                        <table cellspacing=\"3\" cellpadding=\"3\" class=\"tablaElimiar\">\n");
      out.write("                            ");

                                int t = 0;
                                for (int i = 0; i < usuarios.size(); i++) {
                                    if ((!mat.isEmpty() && String.valueOf(usuarios.get(i)[0]).toLowerCase().contains(mat.toLowerCase()))
                                            || (!name.isEmpty() && String.valueOf(usuarios.get(i)[1]).toLowerCase().contains(name.toLowerCase()))
                                            || (!carrera.isEmpty() && String.valueOf(usuarios.get(i)[2]).toLowerCase().contains(carrera.toLowerCase()))
                                            || (!academia.isEmpty() && String.valueOf(usuarios.get(i)[3]).toLowerCase().contains(academia.toLowerCase()))
                                            || (mat.isEmpty() && name.isEmpty() && carrera.isEmpty() && academia.isEmpty())) {
                                        t++;
                            
      out.write("\n");
      out.write("                            <tr class=\"trContentElimiar\">\n");
      out.write("                                <td class=\"tdImgEliminar\">\n");
      out.write("                                    <img id=\"fotoPerfil\" class=\"imgEliminar\" \n");
      out.write("                                         src=\"");
      out.print( request.getContextPath() +"/src/"+ usuarios.get(i)[4] );
      out.write("\" alt=\"not found\">\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"tdContenidoEliminar\">\n");
      out.write("                                    <table class=\"tdValorEliminar\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>\n");
      out.write("                                                <table cellspacing=\"3\" cellpadding=\"3\" class=\"cuerpoEliminar\">\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td><label class=\"contenidoEliminar\">Matricula:</label></td>\n");
      out.write("                                                        <td class=\"tdValorEliminar\">\n");
      out.write("                                                            <label id=\"delMat\" name=\"matricula\" type=\"text\" class=\"contenidoEliminar\">\n");
      out.write("                                                                ");
      out.print( usuarios.get(i)[0]);
      out.write("\n");
      out.write("                                                            </label>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td><label class=\"contenidoEliminar\">Nombre(s):</label></td>\n");
      out.write("                                                        <td class=\"tdValorEliminar\">\n");
      out.write("                                                            <label name=\"nombres\" type=\"text\" class=\"contenidoEliminar\">\n");
      out.write("                                                                ");
      out.print( usuarios.get(i)[1]);
      out.write("\n");
      out.write("                                                            </label>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td><label class=\"contenidoEliminar\">Carrera:</label></td>\n");
      out.write("                                                        <td class=\"tdValorEliminar\">\n");
      out.write("                                                            <label name=\"carrera\" type=\"text\" class=\"contenidoEliminar\">\n");
      out.write("                                                                ");
      out.print( usuarios.get(i)[2]);
      out.write("\n");
      out.write("                                                            </label>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td><label class=\"contenidoEliminar\">Academia:</label></td>\n");
      out.write("                                                        <td class=\"tdValorEliminar\">\n");
      out.write("                                                            <label name=\"academia\" type=\"text\" class=\"contenidoEliminar\">\n");
      out.write("                                                                ");
      out.print( usuarios.get(i)[3]);
      out.write("\n");
      out.write("                                                            </label>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </table>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td class=\"tdbtnEliminar\">\n");
      out.write("                                                <!-- regresar a submit-->\n");
      out.write("                                                <input id=\"del\" class=\"button button2Eliminar\" \n");
      out.write("                                                       type=\"button\" \n");
      out.write("                                                       value=\"Eliminar - ");
      out.print( usuarios.get(i)[0] );
      out.write("\" \n");
      out.write("                                                       onclick=\"eliminar(this.value)\"/>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                    }
                                }
                                if (t == 0) {
                            
      out.write("\n");
      out.write("                            <script>\n");
      out.write("                                error();\n");
      out.write("                            </script>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                    </form>\n");
      out.write("                </scroll-page>\n");
      out.write("            </scroll-container>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"rcorners2\">\n");
      out.write("            <h1 class=\"title font\">Eliminar Personal</h1>\n");
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
