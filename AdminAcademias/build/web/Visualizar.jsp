<%-- 
    Document   : Verificar
    Created on : 27-feb-2021, 10:07:03
    Author     : Home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="src/Visualizar.css"/>
        <link rel="stylesheet" href="src/clases.css"/>
        <script type="text/javascript" src="src/scripts.js"></script>
        <title>Administraci&oacute;n de Academias</title>
    </head>
    <body>
        <div class="rcornersVerificar">
            <img onclick="logout('<%= request.getContextPath() %>')" id="CerrarSesion" class="imgLogout" title="Salir" src="src/BotonSalir.png" alt="not found"/>
            <form class="font" action="Verificar" method="get">
                <div class="rcornersVerificar1">
                    <table cellspacing="3" cellpadding="3" class="tablaVerificar1">
                        <tr>
                            <td>
                                <table cellspacing="3" cellpadding="3" class="tablaVerImg">
                                    <tr>
                                        <td class="tdimgVerificar">
                                            <img id="fotoPerfil" class="imgVerificar"
                                                 src="<%= request.getContextPath() + "/src/Hector.png" %>" alt="not found"/>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <table cellspacing="3" cellpadding="1">
                                    <tr>
                                        <td><label>Matricula:</label></td>
                                        <td><label name="matricula" type="text">18130145</label></td>
                                    </tr>
                                    <tr>
                                        <td><label>Nombre(s):</label></td>
                                        <td><label name="nombre" type="text">Hector Castro</label></td>
                                    </tr>
                                    <tr>
                                        <td><label>Academia:</label></td>
                                        <td class="tdAcademiasVerificar">
                                    <scroll-container>
                                        <scroll-page>
                                            <table cellspacing="3" cellpadding="1" class="tablaAcadVerificar">
                                                <tr class="tr">
                                                    <td class="td">Academia:</td>
                                                    <td class="td">Puesto:</td>
                                                </tr>
                                                <%
                                                    for (int i = 0; i < 10; i++) {

                                                %>
                                                <tr class="tr">
                                                    <td class="td">Academia <%=(i + 1)%></td>
                                                    <td class="td">Miembro</td>
                                                </tr>
                                                <%
                                                    }
                                                %>
                                            </table>
                                        </scroll-page>
                                    </scroll-container>
                            </td>
                        </tr>
                    </table>
                    </td>
                    </tr>
                    </table>
                </div>
            </form>
            <div class="rcornersVerificar2">
                <p1 class="subtitle font">Recientes</p1>
                <scroll-container class="scroll-containerViz">
                    <scroll-page>
                        <form class="font" action="Recientes" method="post">
                            <table cellspacing="3" cellpadding="3">
                                <tr>
                                    <%                                        for (int i = 0; i < 10; i++) {
                                    %>
                                    <td onclick="verPDF('<%=i%>')">
                                        <table cellspacing="3" cellpadding="3" class="tablaRecientes2">
                                            <tr>
                                                <td>
                                                    <img id="fotoDoc" class="imgDocumento" src="src/imgWord.png" alt="not found"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><label>Documento: <%= i%></label></td>
                                            </tr>
                                        </table>
                                    </td>
                                    <%
                                        }
                                    %>
                                </tr>
                            </table> 
                        </form>                      
                    </scroll-page>
                </scroll-container>
            </div>
            <div class="rcornersVerificar3">
                <p1 class="subtitle font">Pendientes</p1>
                <scroll-container class="scroll-containerViz">
                    <scroll-page>
                        <form class="font" action="Recientes" method="post">
                            <table cellspacing="3" cellpadding="3">
                                <tr>
                                    <%
                                        for (int i = 0; i < 10; i++) {
                                    %>
                                    <td>
                                        <table cellspacing="3" cellpadding="3" class="tablaRecientes2">
                                            <tr>
                                                <td><img id="fotoDoc" class="imgDocumento" src="src/imgWord.png" alt="not found"/>  </td>
                                            </tr>
                                            <tr>
                                                <td><label>Documento: <%= i%></label></td>
                                            </tr>
                                        </table>
                                    </td>
                                    <%
                                        }
                                    %>
                                </tr>
                            </table> 
                        </form>                      
                    </scroll-page>
                </scroll-container>
            </div>
        </div>
        <div class="rcornersTituloVer">
            <h1 class="title font">Administraci&oacute;n de Academias </h1>
        </div>
    </body>
</html>
