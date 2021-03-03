<%-- 
    Document   : erroLogin
    Created on : 21/02/2021, 08:46:26 PM
    Author     : Chriss Yañez
--%>

<%@page import="Controller.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar Sesión</title>
        <script type="text/javascript" src="src/scripts.js"></script>
        <link rel="stylesheet" href="src/clases.css"/>
    </head>
    <%
        String error = (request.getAttribute("msj") != null)
                ? String.valueOf(request.getAttribute("msj")) : "";
        String id = String.valueOf(request.getAttribute("IDUser"));
    %>  
    <body onload="cerrarSesion('<%=error%>')">
        <div class="rcorners1Inicada">
            <h1 class="font">Parece que su sesión ya se encuentra iniciada...</h1>
            <h2 class="font">Desea cerrarla?</h2> 
            <form method="post">
                <label for="pasw" class="font"><b>Ingrese su contraseña:</b></label>
                <input id="psw" name="pasw" type="password" autocomplete="new-password">
                <input type="checkbox" onclick="visible()" class="font">Ver clave?
                <br/>
                <input type="submit" value="Sí" class="button buttonGreen"/>
            </form>
            <form action="index.jsp">
                <input type="submit" value="No" class="button buttonRed"/>
            </form>
        </div>
        <div class="rcornersIniciada">
            <h1 class="titleInicada font">Sesi&oacute;n Ya Iniciada!</h1>
        </div>
    </body>
</html>
