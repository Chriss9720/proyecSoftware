<%-- 
    Document   : Registro
    Created on : 18/02/2021, 06:49:09 PM
    Author     : Chriss Yañez
--%>
<%@page import="Controller.Login"%>
<%@ page session="false" %>
<%@page import="java.util.LinkedList"%>
<%@page import="Model.GestorBD"%>
<%@page import="Model.User"%>
<%@page import="Controller.Login" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%
        String id = String.valueOf(request.getAttribute(""));
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" href="src/clases.css" />
        <script type="text/javascript" src="src/scripts.js"></script>
        <title>Administraci&oacute;n de Academias</title>
    </head>
    <%
        String path;
        User user = null;
        try {
            user = (User) (request.getAttribute("User"));
            if (user != null && user.getFile() != null && !user.getFile().isEmpty()) {
                path = user.getFile().replace("/", "\\");
            } else {
                path = "src\\perfilazul.png";
            }
        } catch (Exception e) {
            path = "src\\perfilazul.png";
        }
        int p = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '\\') {
                p = i;
            }
        }
        path = "src/" + path.substring(p, path.length());
        String mat = (request.getAttribute("matricula") != null)
                ? (String) request.getAttribute("matricula") : "";
        String nombre = (request.getAttribute("nombres") != null)
                ? (String) request.getAttribute("nombres") : "";
        String app = (request.getAttribute("apellidoP") != null)
                ? (String) request.getAttribute("apellidoP") : "";
        String apm = (request.getAttribute("apellidoM") != null)
                ? (String) request.getAttribute("apellidoM") : "";
        String correo = (request.getAttribute("correo") != null)
                ? (String) request.getAttribute("correo") : "";
        String cip = (request.getAttribute("cip") != null)
                ? (String) request.getAttribute("cip") : "";
    %>
    <body onload="realizarValidaciones('<%=mat%>', '<%=nombre%>',
                    '<%=app%>', '<%=apm%>', '<%=correo%>', '<%=cip%>')">
        <div class="rcorners1" id="contenedor">
            <p1 class="subtitle font">Ingrese la informaci&oacute;n:</p1>
            <img onclick="logout('<%= request.getContextPath() %>')" id="CerrarSesion" class="imgLogout" title="Salir" src="src/BotonSalir.png" alt="not found"/>
            <form class="font" action="Registro" method="post">
                <input name="paso" id="flag" hidden="true"/>
                <img id="fotoPerfil" class="imgRedonda" src="<%= path%>" alt="not found" />
                <table id="tablaCont" cellspacing="3" cellpadding="3" class="cuerpo">
                    <tr>
                        <td>
                            <label class="contenido">Matricula:</label>
                        </td>
                        <td>
                            <input id="inputMatricula" name="matricula" type="text" 
                                   minlength="8" maxlength="8" class="contenido" 
                                   required value="<%= mat%>"
                                   onkeyup="validarMatricula(this.value, 'errorMatricula', 'labelErrorerrorMatricula', 0)" />
                        </td>
                    </tr>
                    <tr id="errorMatricula" class="therror" hidden="true">
                        <td/>
                        <td> 
                            <label id="labelErrorerrorMatricula" class="error"></label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="contenido">Nombre(s):</label>
                        </td>
                        <td>
                            <input id="inputNombre" name="nombres" type="text" 
                                   class="contenido" required value="<%= nombre%>"
                                   onkeyup="contieneNumeros(this.value, 'errorNombre', 'labelErrorNombre', 1)" />
                        </td>
                    </tr>
                    <tr id="errorNombre" class="therror" hidden="true">
                        <td/>
                        <td> 
                            <label id="labelErrorNombre" class="error"></label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="contenido">Apellido Paterno:</label>
                        </td>
                        <td>
                            <input required id="inputApeP" name="apellidoP" type="text" 
                                   class="contenido" value="<%= app%>"
                                   onkeyup="contieneNumeros(this.value, 'errorApellidoP', 'labelErrorApellidoP', 2)" />
                        </td>
                    </tr>
                    <tr id="errorApellidoP" class="therror" hidden="true">
                        <td/>
                        <td> 
                            <label id="labelErrorApellidoP" class="error"></label>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="contenido">Apellido Materno:</label></td>
                        <td><input id="inputApM" required name="apellidoM" type="text" 
                                   class="contenido" value="<%= apm%>"
                                   onkeyup="contieneNumeros(this.value, 'errorApellidoM', 'labelErrorApellidoM', 3)" />
                        </td>
                    </tr>
                    <tr id="errorApellidoM" class="therror" hidden="true">
                        <td/>
                        <td> 
                            <label id="labelErrorApellidoM" class="error"></label>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="contenido">Correo Institucional:</label></td>
                        <td>
                            <input id="inputCorreo" required name="correo" type="text" 
                                   class="contenido" value="<%= correo%>"
                                   onkeyup="validarCorreo(this.value, 'errorCorreo', 'labelErrorCorreo')"/>
                        </td>
                    </tr>
                    <tr id="errorCorreo" class="therror" hidden="true">
                        <td/>
                        <td> 
                            <label id="labelErrorCorreo" class="error"></label>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="contenido">CIP:</label></td>
                        <td><input required name="cip" type="text" class="contenido" 
                                   minlength="5" maxlength="5" id="inputCip" value="<%=cip%>"
                                   onkeyup="validarCIP(this.value, 'errorCIP', 'labelErrorIP')"/></td>
                    </tr>
                    <tr id="errorCIP" class="therror" hidden="true">
                        <td/>
                        <td> 
                            <label id="labelErrorIP" class="error"></label>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="contenido">Carrera:</label></td>
                        <td>
                            <select name="carrera" class="contenido" id="SelectCarrera"
                                    onclick="validarSelect(this.value, 'errorSelectCarrera', 'labelErrorSelectCarrera', 6)">
                                <option value="0">Selecione una</option>
                                <%
                                    LinkedList<String> carr = GestorBD.getCarreras();
                                    carr = (carr != null) ? carr : new LinkedList();
                                    for (int i = 0; i < carr.size(); i++) {
                                %>
                                <option value="<%= carr.get(i)%>"><%= carr.get(i)%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr id="errorSelectCarrera" class="therror" hidden="true">
                        <td/>
                        <td> 
                            <label id="labelErrorSelectCarrera" class="error"></label>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="contenido">Academia:</label></td>
                        <td>
                            <select id="academia" class="contenido"
                                    onclick="validarSelect(this.value, 'errorSelectAcademia', 'labelErrorAcademia', 7)">
                                <option value="0">Selecione una</option>
                            </select>
                        </td>
                    </tr>
                    <tr id="errorSelectAcademia" class="therror" hidden="true">
                        <td/>
                        <td> 
                            <label id="labelErrorAcademia" class="error"></label>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="contenido">Puesto en la academia:</label></td>
                        <td>
                            <select id="puessto" class="contenido"
                                    onclick="validarSelect(this.value, 'errorSelectPuesto', 'labelErrorPuesto', 8)">
                                <option value="0">Selecione una</option>
                            </select>
                        </td>
                    </tr>
                    <tr id="errorSelectPuesto" class="therror" hidden="true">
                        <td/>
                        <td> 
                            <label id="labelErrorPuesto" class="error"></label>
                        </td>
                    </tr>
                </table>
                <input class="button button1" type="button" value="Cancelar" onclick="cancelarRegistro()" />
                <input class="button button2" type="submit" value="Registrar" onclick="validarRegistro()" />
            </form>
            <form method="post" enctype="multipart/form-data" action="Registro">
                <input class="file" type="file" name="upfile" size="50" />
                <input class="button subirImg" type="submit" value="Sublir" />
            </form>
        </div>
        <div class="rcorners2">
            <h1 class="title font">Registro de Personal</h1>
        </div>
    </body>

</html>
