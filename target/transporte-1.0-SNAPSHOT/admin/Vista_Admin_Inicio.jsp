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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="Estilos/Estilo_Conductor.css">
        <!-- Iconos CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <link rel="stylesheet" href="style/style.css">
        <title>Inicio</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
                            <a class="nav-link active text-danger" aria-current="page" href="AdminInicioController">Inicio</a>
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
        ${men.mensaje}
        <section class="w-70 mx-auto text-center "id='intro'>

            <h2 class="text-info fw-bold">MENU</h2>
            <div class="w-50 mx-auto d-flex flex-column-reverse">
                <a href="AdminNuevoUsuario"class="p-3 card border-danger text-decoration-none">
                    <input class="btn btn-transparent text-danger fw-bold" type="submit" value="REGISTRAR CONDUCTOR">
                </a>
                <a href="AdminNuevoParada"class="p-3 card border-danger text-decoration-none">
                    <input class="btn btn-transparent text-danger fw-bold" type="submit" value="REGISTRAR CONTROL PARADA">
                </a>
                <a href="AdminNuevoAportes"class="p-3 card border-danger text-decoration-none">
                    <input class="btn btn-transparent text-danger fw-bold" type="submit" value="REGISTRAR CONTROL APORTES">
                </a>
                <a href="AdminNuevoAccidentes"class="p-3 card border-danger text-decoration-none">
                    <input class="btn btn-transparent text-danger fw-bold" type="submit" value="REGISTRAR CONTROL ACCIDENTES">
                </a>
                <a href="AdminNuevoComunicado"class="p-3 card border-danger text-decoration-none">
                    <input class="btn btn-transparent text-danger fw-bold" type="submit" value="REGISTRAR COMUNICADO">
                </a>
                <a href="AdminComunicado"class="p-3 card border-danger text-decoration-none">
                    <input class="btn btn-transparent text-danger fw-bold" type="submit" value="COMUNICADOS">
                </a>
                <a href="AdminRegistroController"class="p-3 card border-danger text-decoration-none">
                    <input class="btn btn-transparent text-danger fw-bold" type="submit" value="USUARIOS">
                </a>
            </div>






            <script src="javaScipt/reloj.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        </section>
    </body>

</html>
