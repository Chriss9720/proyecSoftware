package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Visualizar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"src/Visualizar.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"src/clases.css\"/>\n");
      out.write("        <script type=\"text/javascript\" src=\"src/scripts.js\"></script>\n");
      out.write("        <title>Administraci&oacute;n de Academias</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"rcornersVerificar\">\n");
      out.write("            \n");
      out.write("            <form class=\"font\" action=\"Verificar\" method=\"get\">\n");
      out.write("                <div class=\"rcornersVerificar1\">\n");
      out.write("                    <input class=\"button buttonRegresar1\" type=\"button\" value=\"Regresar\" onclick=\"cambiar('Menu.jsp')\"/>\n");
      out.write("                    <table cellspacing=\"3\" cellpadding=\"3\" class=\"tablaVerificar1\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <table cellspacing=\"3\" cellpadding=\"3\" class=\"tablaVerImg\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td class=\"tdimgVerificar\">\n");
      out.write("                                            <img id=\"fotoPerfil\" class=\"imgVerificar\"\n");
      out.write("                                                 src=\"");
      out.print( request.getContextPath() + "/src/Hector.png" );
      out.write("\" alt=\"not found\"/>\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </table>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <table cellspacing=\"3\" cellpadding=\"1\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><label>Matricula:</label></td>\n");
      out.write("                                        <td><label name=\"matricula\" type=\"text\">18130145</label></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><label>Nombre(s):</label></td>\n");
      out.write("                                        <td><label name=\"nombre\" type=\"text\">Hector Castro</label></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><label>Academia:</label></td>\n");
      out.write("                                        <td class=\"tdAcademiasVerificar\">\n");
      out.write("                                    <scroll-container>\n");
      out.write("                                        <scroll-page>\n");
      out.write("                                            <table cellspacing=\"3\" cellpadding=\"1\" class=\"tablaAcadVerificar\">\n");
      out.write("                                                <tr class=\"tr\">\n");
      out.write("                                                    <td class=\"td\">Academia:</td>\n");
      out.write("                                                    <td class=\"td\">Puesto:</td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                ");

                                                    for (int i = 0; i < 10; i++) {

                                                
      out.write("\n");
      out.write("                                                <tr class=\"tr\">\n");
      out.write("                                                    <td class=\"td\">Academia ");
      out.print((i + 1));
      out.write("</td>\n");
      out.write("                                                    <td class=\"td\">Miembro</td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                            </table>\n");
      out.write("                                        </scroll-page>\n");
      out.write("                                    </scroll-container>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                    </td>\n");
      out.write("                    </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            <div class=\"rcornersVerificar2\">\n");
      out.write("                <p1 class=\"subtitle font\">Recientes</p1>\n");
      out.write("                <scroll-container class=\"scroll-containerViz\">\n");
      out.write("                    <scroll-page>\n");
      out.write("                        <form class=\"font\" action=\"Recientes\" method=\"post\">\n");
      out.write("                            <table cellspacing=\"3\" cellpadding=\"3\">\n");
      out.write("                                <tr>\n");
      out.write("                                    ");
                                        
                                        for (int i = 0; i < 10; i++) {
                                    
      out.write("\n");
      out.write("                                    <td onclick=\"verPDF('");
      out.print(i);
      out.write("')\">\n");
      out.write("                                        <table cellspacing=\"3\" cellpadding=\"3\" class=\"tablaRecientes2\">\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>\n");
      out.write("                                                    <img id=\"fotoDoc\" class=\"imgDocumento\" src=\"src/imgWord.png\" alt=\"not found\"/>\n");
      out.write("                                                </td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><label>Documento: ");
      out.print( i);
      out.write("</label></td>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </table>\n");
      out.write("                                    </td>\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\n");
      out.write("                                </tr>\n");
      out.write("                            </table> \n");
      out.write("                        </form>                      \n");
      out.write("                    </scroll-page>\n");
      out.write("                </scroll-container>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"rcornersVerificar3\">\n");
      out.write("                <p1 class=\"subtitle font\">Pendientes</p1>\n");
      out.write("                <scroll-container class=\"scroll-containerViz\">\n");
      out.write("                    <scroll-page>\n");
      out.write("                        <form class=\"font\" action=\"Recientes\" method=\"post\">\n");
      out.write("                            <table cellspacing=\"3\" cellpadding=\"3\">\n");
      out.write("                                <tr>\n");
      out.write("                                    ");

                                        for (int i = 0; i < 10; i++) {
                                    
      out.write("\n");
      out.write("                                    <td>\n");
      out.write("                                        <table cellspacing=\"3\" cellpadding=\"3\" class=\"tablaRecientes2\">\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><img id=\"fotoDoc\" class=\"imgDocumento\" src=\"src/imgWord.png\" alt=\"not found\"/>  </td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><label>Documento: ");
      out.print( i);
      out.write("</label></td>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </table>\n");
      out.write("                                    </td>\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\n");
      out.write("                                </tr>\n");
      out.write("                            </table> \n");
      out.write("                        </form>                      \n");
      out.write("                    </scroll-page>\n");
      out.write("                </scroll-container>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"rcornersTituloVer\">\n");
      out.write("            <h1 class=\"title font\">Administraci&oacute;n de Academias </h1>\n");
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
