<%-- 
    Document   : menu
    Created on : Feb 26, 2021, 1:46:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="src/clases.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="src/scripts.js"></script>
        <title>Menu de Admin. de Acad.</title>
    </head>
    <body>
        <div class="rcorners1Menu">
            <img onclick="logout('<%= request.getContextPath() %>')" id="CerrarSesion" class="imgLogout" title="Salir" src="src/BotonSalir.png" alt="not found"/>
            <table>
                <tr>
                    <td>                
                        <h4 class="subtitleMenu font">Bienvenidos al sistema, por favor, seleccione entre las siguientes opciones:</h4>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form action="Menu" method="post">
                            <table cellspacing="50" class="tableInterior font">
                                <tr>
                                    <td class="borderRegMenu sizeMenu">
                                        <input name="reg" class="borderRegMenu sizeMenu fontButMenu" type="submit" value="registrarse">
                                    </td>
                                    <td class="borderModMenu sizeMenu">
                                        <input name="mod" class="borderModMenu sizeMenu fontButMenu" type="submit" value="modificar">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="borderEliMenu sizeMenu">
                                        <input name="eli" class="borderEliMenu sizeMenu fontButMenu" type="submit" value="eliminar">
                                    </td>
                                    <td class="borderVis sizeMenu">
                                        <input name="vis" class="borderVisMenu sizeMenu fontButMenu" type="submit" value="Ver miembros">
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </td>
                </tr>
            </table>
        </div>
        <div class="rcorners2Menu">
            <h1 class="titleMenu font">Administraci&oacute;n de Academias</h1>
        </div>
    </body>
</html>