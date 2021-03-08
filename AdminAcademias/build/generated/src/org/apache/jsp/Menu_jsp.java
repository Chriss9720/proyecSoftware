package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"src/clases.css\"/>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <script type=\"text/javascript\" src=\"src/scripts.js\"></script>\n");
      out.write("        <title>Menu de Admin. de Acad.</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"rcorners1Menu\">\n");
      out.write("            <img onclick=\"logout('");
      out.print( request.getContextPath() );
      out.write("')\" id=\"CerrarSesion\" class=\"imgLogout\" title=\"Salir\" src=\"src/BotonSalir.png\" alt=\"not found\"/>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>                \n");
      out.write("                        <h4 class=\"subtitleMenu font\">Bienvenidos al sistema, por favor, seleccione entre las siguientes opciones:</h4>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"Menu\" method=\"post\">\n");
      out.write("                            <table cellspacing=\"50\" class=\"tableInterior font\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td class=\"borderRegMenu sizeMenu\">\n");
      out.write("                                        <input name=\"reg\" class=\"borderRegMenu sizeMenu fontButMenu\" type=\"submit\" value=\"registrarse\">\n");
      out.write("                                    </td>\n");
      out.write("                                    <td class=\"borderModMenu sizeMenu\">\n");
      out.write("                                        <input name=\"mod\" class=\"borderModMenu sizeMenu fontButMenu\" type=\"submit\" value=\"modificar\">\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td class=\"borderEliMenu sizeMenu\">\n");
      out.write("                                        <input name=\"eli\" class=\"borderEliMenu sizeMenu fontButMenu\" type=\"submit\" value=\"eliminar\">\n");
      out.write("                                    </td>\n");
      out.write("                                    <td class=\"borderVis sizeMenu\">\n");
      out.write("                                        <input name=\"vis\" class=\"borderVisMenu sizeMenu fontButMenu\" type=\"submit\" value=\"Ver miembros\">\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"rcorners2Menu\">\n");
      out.write("            <h1 class=\"titleMenu font\">Administraci&oacute;n de Academias</h1>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
