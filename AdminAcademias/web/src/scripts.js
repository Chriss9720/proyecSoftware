var extraH = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
function realizarValidaciones(mat, nombre, app, apm, correo, cip) {
    if (mat.length > 0)
        validarMatricula(mat, 'errorMatricula', 'labelErrorerrorMatricula', 0);
    if (nombre.length > 0)
        contieneNumeros(nombre, 'errorNombre', 'labelErrorNombre', 0);
    if (app.length > 0)
        contieneNumeros(app, 'errorApellidoP', 'labelErrorApellidoP', 2);
    if (apm.length > 0) 
        contieneNumeros(apm, 'errorApellidoM', 'labelErrorApellidoM', 3);
    if (correo.length > 0)
        validarCorreo(correo, 'errorCorreo', 'labelErrorCorreo');
    if (cip.length > 0) 
        validarCIP(cip, 'errorCIP', 'labelErrorIP');
    ajustarTamaño('contenedor');
}
function contieneNumeros(palabra, id, label, pos) {
    var bol = false;
    var carac = false;
    for (var i = 0; i < palabra.length && !bol; i++) {
        bol = ((palabra.charAt(i) >= '0' && palabra.charAt(i) <= '9'));
    }
    for (var i = 0; i < palabra.length && !carac; i++) {
        if (palabra.charAt(i) !== ' ' && palabra.charAt(i) !== 'ñ'
                && palabra.charAt(i) !== 'Ñ') {
            carac = ((palabra.charAt(i) < 'A' || palabra.charAt(i) > 'Z'))
                    && ((palabra.charAt(i) < 'a' || palabra.charAt(i) > 'z'));
        }
    }
    document.getElementById(id).hidden = !bol && !carac;
    document.getElementById(label).innerHTML = "Por favor, <br/>introduzca solo letras";
    if (extraH[pos] === 0 && !(document.getElementById(id).hidden)) {
        extraH[pos] = document.getElementById(label).getBoundingClientRect().height;
    } else if (document.getElementById(id).hidden) {
        extraH[pos] = 0;
    }
    ajustarTamaño('contenedor');
}
function visible() {
    var x = document.getElementById("psw");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}
function validarCorreo(correo, id, label) {
    var ext = "@e-itesca.edu.mx";
    var start = correo.length - ext.length;
    var ext0 = (correo.substring(start, (correo.length)));
    document.getElementById(id).hidden = (ext === ext0);
    document.getElementById(label).innerHTML = "Por favor ingrese un correo<br/> con extension: " + ext;
    if (extraH[4] === 0 && !(document.getElementById(id).hidden)) {
        extraH[4] = document.getElementById(label).getBoundingClientRect().height;
    } else if (document.getElementById(id).hidden) {
        extraH[4] = 0;
    }
    ajustarTamaño('contenedor');
}
function validarCIP(cip, id, label) {
    document.getElementById(id).hidden = !(cip.length !== 5);
    document.getElementById(label).innerHTML = "Minímo 5";
    if (extraH[5] === 0 && !(document.getElementById(id).hidden)) {
        extraH[5] = document.getElementById(label).getBoundingClientRect().height;
    } else if (document.getElementById(id).hidden) {
        extraH[5] = 0;
    }
    ajustarTamaño('contenedor');
}
function validarSelect(select, id, label, pos) {
    console.log(select);
    document.getElementById(id).hidden = !(select === "0");
    document.getElementById(label).innerHTML = "Elija 1";
    if (extraH[pos] === 0 && !(document.getElementById(id).hidden)) {
        extraH[pos] = document.getElementById(label).getBoundingClientRect().height;
    } else if (document.getElementById(id).hidden) {
        extraH[pos] = 0;
    }
    ajustarTamaño('contenedor');
}
function ajustarTamaño(id) {
    var aumento = 0;
    for (var i = 0; i < extraH.length; i++) {
        aumento += extraH[i];
    }
    document.getElementById(id).style.height = 580 + aumento + "px";
}
function validarMatricula(palabra, id, label) {
    var bol = true;
    for (var i = 0; i < palabra.length && bol; i++) {
        bol = ((palabra.charAt(i) >= '0' && palabra.charAt(i) <= '9'));
    }
    var msj = "";
    if (bol) {
        if (palabra.length !== 8) {
            bol = false;
            msj = "Por favor, <br/>introduzca 8 números";
        }
    } else {
        msj = "Por favor, <br/>introduzca solo números";
    }
    document.getElementById(id).hidden = bol;
    document.getElementById(label).innerHTML = msj;
    if (extraH[9] === 0 && !(document.getElementById(id).hidden)) {
        extraH[9] = document.getElementById(label).getBoundingClientRect().height;
    } else if (document.getElementById(id).hidden) {
        extraH[9] = 0;
    }
}
function mensajeErrorLogin(mensaje) {
    if (mensaje !== "null") {
        document.getElementById("errores").hidden = false;
        document.getElementById("labelerrores").innerHTML = mensaje;
    } else {
        document.getElementById("errores").hidden = true;
        document.getElementById("labelerrores").innerHTML = "";
    }
}
function cambiar(page) {
    location.href = page;
}
function cancelarRegistro() {
    if (confirm("Seguro que desae cancelar el registro?")) {
        location.href = "Registro";
    }
}
function error() {
    alert("No se encontro ningun resultado");
    location.href = "Eliminar";
}
function validarRegistro() {
    if (!document.getElementById("errorMatricula").hidden ||
            !document.getElementById("errorNombre").hidden ||
            !document.getElementById("errorApellidoP").hidden ||
            !document.getElementById("errorApellidoM").hidden ||
            !document.getElementById("errorCorreo").hidden ||
            !document.getElementById("errorCIP").hidden ||
            !document.getElementById("errorSelectCarrera").hidden ||
            !document.getElementById("errorSelectAcademia").hidden ||
            !document.getElementById("errorSelectPuesto").hidden) {
        document.getElementById("flag").value = "0";
        alert("revise los campos");
    } else {
        var msj = "";
        if (document.getElementById("SelectCarrera").value === "0") {
            msj = "\nElija una carrera";
        }
        if (document.getElementById("academia").value === "0") {
            msj += "\nElija una academia";
        }
        if (document.getElementById("puessto").value === "0") {
            msj += "\nElija un puesto";
        }
        if (msj.length === 0) {
            document.getElementById("flag").value = "1";
           alert("Registro exitoso!!");
        } else {
            document.getElementById("flag").value = "0";
            alert(msj);
        }
    }
}
function eliminar(valor) {
    valor = valor.replace("Eliminar - ", "");
    if (confirm("Seguro que desea elimiar al usaurio con la matricula: " + valor)) {
        let pass = prompt("Ingrese su contraseña para continuar");
        if (pass !== null && pass.length > 0 && pass === "admin") {
            alert("Eliminado exitosamente!!!");
            location.href = "Eliminar?del=" + valor;
        } else {
            alert("Contraseña incorrecta");
        }
    } else {
        alert("Cancelacion exitosa!!!");
    }
}
function verPDF(nombre) {
    window.open("PDF.jsp?nombre="+nombre);
}
function cerrarSesion(error) {
    if (error.length > 0) 
        alert(error);
}
function logout(path) {
    if (confirm("Seguro de que desea cerrar su sesión?")) {
        location.href = path;
    }
}