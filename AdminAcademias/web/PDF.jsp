<%-- 
    Document   : PDF
    Created on : 28/02/2021, 08:36:33 PM
    Author     : Chriss Yañez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PDF Page</title>
        <script type="text/javascript">
            function verPDF() {
                var pdf = document.getElementById("pdf");
                pdf.style.width = "100%";
                pdf.style.height = (window.screen.height - 125) + "px";
            }
        </script>
    </head>
    <body onload="verPDF()">
        <embed id="pdf" src="src/document.pdf" type="application/pdf"/>
    </body>
</html>
