<%@page import="com.grupo.modelo.Admin"%>
<%
    Admin usuario = new Admin();
    if (session.getAttribute("loged") != "Admin") {

        response.sendRedirect("./LoginAdmin.jsp");
    } else {
        usuario = (Admin) session.getAttribute("usuario");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="Estilos/Estilo_Conductor.css">
        <!-- Iconos CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Nuevo Usuario</title>
    </head>
    <body>
        <header class="container-fluid bg-danger d-flex justify-content-between" >
            <span class="text-light mb-0 p-2 fs-6">
                <i class="fa-sharp fa-solid fa-bus"></i>
            </span>
            <p class="text-light mb-0 p-2 fs-6">Coop. Mixto de Trasporte</p>
            <div class="widget">
                <div class="fecha">
                    <p id="diaSemana" class="diaSemana"></p>
                    <p id="dia" class="dia"></p>
                    <p>de </p>
                    <p id="mes" class="mes"></p>
                    <p>del </p>
                    <p id="anio" class="anio"></p>
                </div>
                <div class="relog">
                    <p id="horas" class="horas"></p>
                    <p>:</p>
                    <p id="minutos" class="minutos"></p>
                    <p>:</p>
                    <p id="segundos" class="segundos"></p>
                    <p id="ampm" class="ampm"></p>
                </div>
            </div>
        </header>  
        <nav class="navbar navbar-expand-lg navbar-light bg-light p-3"  id="menu">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <span class="text-primary fs-5 fw-bold">Navegación</span>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="AdminInicioController">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AdminPerfilController">Perfil</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AdminAportesController">Aportes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AdminParadaController">Paradas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AdminAnteController">Accidentes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Destroy_login">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <a href="Rest_passPa?ci=${datos.ci}" class="btn btn-danger"  >Restablecer Contraseña</a>
        <section class="w-70 mx-auto text-center "id='intro'>
            <h2 class="text-info fw-bold" >Registro personal Paradas</h2>

            <form action="AdminEditParada" method="post" onsubmit="return validarFecha();" class="row g-3">
                
                <h3 class="text-info fw-bold">Datos Personales</h3>
                <div class="col-md-4">
                    <label for="validationServer01" class="form-label">Nombres:</label>
                    <input value="${datos.nombre}"required type="text" placeholder="Nombres" name="nombre" class="form-control is-valid" id="validationServer01"  required maxlength="50" minlength="5">
                </div> 
                <div class="col-md-4">
                    <label for="validationServer01" class="form-label">Apellido Paterno:</label>
                    <input value="${datos.app}"required type="text" placeholder="Apellido Paterno" name="app" class="form-control is-valid" id="validationServer01"  required maxlength="50" minlength="5">
                </div>
                <div class="col-md-4">
                    <label for="validationServer01" class="form-label">Apellido Materno:</label>
                    <input value="${datos.apm}" type="text" placeholder="Apellido Materno" name="apm" class="form-control is-valid" id="validationServer01"  required maxlength="50" minlength="5">
                </div>
                <div class="col-md-4">
                    <label for="validationServer01" class="form-label">CI:</label>
                    <input value="${datos.ci}"required readonly type="number" placeholder="CI" name="ci" class="form-control is-valid" id="validationServer01"  required maxlength="7" minlength="8"max="99999999" min="1000000">    
                </div>  
                <div class="col-md-4">
                    <label for="validationServer01" class="form-label">Numero Celular:</label>
                    <input value="${datos.telefono}"required type="Number" placeholder="Celular" name="celular" class="form-control is-valid" id="validationServer01"  required maxlength="8" minlength="8"max="79999999" min="60000000"> 
                </div> 
                <div class="col-md-4">    
                    <label for="validationServer01" class="form-label">Username :</label>
                    <input value="${datos.username}"required readonly type="text" placeholder="Username" name="user" class="form-control is-valid" id="validationServer01"  required maxlength="50" minlength="5"> 
                </div> 
                
                <input class="btn btn-primary" type="submit" value="Editar Usuario"name="enviar"> 

            </form>
                    

        </section>

        <script src="javaScipt/reloj.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
    <script>
                function validarFecha() {
                    var fechaInput = document.getElementById("fecha").value;
                    var fechaSeleccionada = new Date(fechaInput);
                    var fechaActual = new Date();
                    var fechaDespues = new Date();
                    fechaDespues.setFullYear(fechaDespues.getFullYear() + 5);
                    if (fechaSeleccionada < fechaActual) {
                        alert("La fecha seleccionada no puede ser anterior a la fecha actual.");
                        return false;
                    }else if(fechaSeleccionada > fechaDespues){
                        alert("La fecha seleccionada no puede mas de 5 años despues.");
                        return false;
                    }
                    return true;
                }
    </script>
</html>
