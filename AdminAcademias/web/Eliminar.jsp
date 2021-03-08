<%-- 
    Document   : Eliminar
    Created on : 25-feb-2021, 14:40:44
    Author     : Home
--%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="src/clases.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="src/scripts.js"></script>
        <title>Administraci&oacute;n de Academias</title>
    </head>
    <body>
        <%
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
        %>
        <div class="fijadoEliminar">
            
            <form class="font" action="BuscarEliminar" method="get">
                <table cellspacing="10" cellpadding="3" class="BusquedaEliminar">
                    <tr>
                        <td><label class="contenidoBusqueda">Nombre(s):</label></td>
                        <td><label class="contenidoBusqueda">Carrera:</label></td>
                        <td><label class="contenidoBusqueda">Academia:</label></td>
                        <td><label class="contenidoBusqueda">Matricula:</label></td>
                    </tr>
                    <tr>
                        <td><input name="SearchName" type="text" class="contenidoBusqueda"
                                   value="<%= name%>"/></td>
                        <td>
                            <select name="SearchCarr" class="contenidoBusqueda">
                                <%
                                    if (!carrera.isEmpty()) {
                                %>
                                <option><%= carrera%></option>
                                <%
                                } else {
                                %>
                                <option value ="">Seleciona una</option>
                                <%
                                    }
                                    for (int i = 0; i < carreras.size(); i++) {
                                        if (carrera.isEmpty() || (!carrera.isEmpty()
                                                && !carrera.equals(carreras.get(i)))) {
                                %>
                                <option><%= carreras.get(i)%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td> 
                        <td>
                            <select name="SearchAca" class="contenidoBusqueda">
                                <%
                                    if (!academia.isEmpty()) {
                                %>
                                <option><%= academia%></option>
                                <%
                                } else {
                                %>
                                <option value ="">Seleciona una</option>
                                <%
                                    }
                                    for (int i = 0; i < academias.size(); i++) {
                                        if (academia.isEmpty() || (!academia.isEmpty()
                                                && !academia.equals(academias.get(i)))) {
                                %>
                                <option><%= academias.get(i)%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td> 
                        <td><input id="sMat" name="SeacrchMat" type="text" 
                                   class="contenidoBusqueda" value="<%= mat%>"/>
                        </td> 
                    </tr>
                </table>
                <input class="button buttonBuscar" type="submit" value="Buscar"/>
                <input class="button buttonLimpiar" type="button" value="Limpiar" onclick="cambiar('Eliminar')"/>
                <input class="button button1Eliminar" type="button" value="Regresar" onclick="cambiar('Menu.jsp')"/>
            </form>
        </div>
        <div class="rcornersEliminar">
            <scroll-container>
                <scroll-page>
                    <form class="font" action="Eliminar" method="post">
                        <table cellspacing="3" cellpadding="3" class="tablaElimiar">
                            <%
                                int t = 0;
                                for (int i = 0; i < usuarios.size(); i++) {
                                    if ((!mat.isEmpty() && String.valueOf(usuarios.get(i)[0]).toLowerCase().contains(mat.toLowerCase()))
                                            || (!name.isEmpty() && String.valueOf(usuarios.get(i)[1]).toLowerCase().contains(name.toLowerCase()))
                                            || (!carrera.isEmpty() && String.valueOf(usuarios.get(i)[2]).toLowerCase().contains(carrera.toLowerCase()))
                                            || (!academia.isEmpty() && String.valueOf(usuarios.get(i)[3]).toLowerCase().contains(academia.toLowerCase()))
                                            || (mat.isEmpty() && name.isEmpty() && carrera.isEmpty() && academia.isEmpty())) {
                                        t++;
                            %>
                            <tr class="trContentElimiar">
                                <td class="tdImgEliminar">
                                    <img id="fotoPerfil" class="imgEliminar" 
                                         src="<%= request.getContextPath() +"/src/"+ usuarios.get(i)[4] %>" alt="not found">
                                </td>
                                <td class="tdContenidoEliminar">
                                    <table class="tdValorEliminar">
                                        <tr>
                                            <td>
                                                <table cellspacing="3" cellpadding="3" class="cuerpoEliminar">
                                                    <tr>
                                                        <td><label class="contenidoEliminar">Matricula:</label></td>
                                                        <td class="tdValorEliminar">
                                                            <label id="delMat" name="matricula" type="text" class="contenidoEliminar">
                                                                <%= usuarios.get(i)[0]%>
                                                            </label>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><label class="contenidoEliminar">Nombre(s):</label></td>
                                                        <td class="tdValorEliminar">
                                                            <label name="nombres" type="text" class="contenidoEliminar">
                                                                <%= usuarios.get(i)[1]%>
                                                            </label>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><label class="contenidoEliminar">Carrera:</label></td>
                                                        <td class="tdValorEliminar">
                                                            <label name="carrera" type="text" class="contenidoEliminar">
                                                                <%= usuarios.get(i)[2]%>
                                                            </label>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><label class="contenidoEliminar">Academia:</label></td>
                                                        <td class="tdValorEliminar">
                                                            <label name="academia" type="text" class="contenidoEliminar">
                                                                <%= usuarios.get(i)[3]%>
                                                            </label>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tdbtnEliminar">
                                                <!-- regresar a submit-->
                                                <input id="del" class="button button2Eliminar" 
                                                       type="button" 
                                                       value="Eliminar - <%= usuarios.get(i)[0] %>" 
                                                       onclick="eliminar(this.value)"/>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <%
                                    }
                                }
                                if (t == 0) {
                            %>
                            <script>
                                error();
                            </script>
                            <%
                                }
                            %>
                        </table>
                    </form>
                </scroll-page>
            </scroll-container>
        </div>

        <div class="rcorners2">
            <h1 class="title font">Eliminar Personal</h1>
        </div>
    </body>
</html>
