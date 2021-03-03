<%-- 
    Document   : index
    Created on : 18/02/2021, 06:47:45 PM
    Author     : Chriss Yañez
--%>
<%@page session="false" %>
<%@page import="Controller.Login" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="src/clases.css"/>
        <script type="text/javascript" src="src/scripts.js"></script>
        <title>Login Page</title>
    </head>
    <%
        String path = (request.getAttribute("path") != null)
                ? String.valueOf(request.getAttribute("path"))
                : "/src/perfilazul.png";
        path = request.getContextPath() + path;
        String error = (request.getAttribute("error") != null)
                ? String.valueOf(request.getAttribute("error")) : null;
    %>  
    <body onload="mensajeErrorLogin('<%= error%>')">
        <div class="rcornersLogin">
            <p1 class="subtitleLogin font">Login</p1>
            <form class="font" action="AdministracionAcademias" method="post">
                <img id="fotoPerfilLogin" class="imgLogin" alt="not found" 
                     src = "<%= path%>"/>
                <table cellspacing="3" cellpadding="3" class="cuerpoLogin">
                    <tr>
                        <td><label class="contenidoLogin">Ingrese su matricula:</label></td>
                    </tr>
                    <tr>
                        <td><input required name="matricula" type="text" 
                                   class="contenidoLogin" value="" autocomplete="new-names"/></td>
                    </tr>
                    <tr>
                        <td><label class="contenidoLogin">Ingrese su clave:</label></td>
                    </tr>
                    <tr>
                        <td><input id="psw" required name="clave" type="password" 
                                   class="contenidoLogin" autocomplete="new-password"/></td>
                    </tr>
                    <tr>
                        <td> <input type="checkbox" onclick="visible()">ver clave</td>
                    </tr>
                    <tr id="errores" class="therror" hidden="true">
                        <td> 
                            <label id="labelerrores" class="error"></label>
                        </td>
                    </tr>
                </table>
                <input class="button buttonLogin" type="submit" value="Ingresar"/>
            </form>
        </div>
    </body>
</html>