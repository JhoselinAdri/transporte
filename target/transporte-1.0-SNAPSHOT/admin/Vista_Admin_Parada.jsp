<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <link rel="stylesheet" href="style/style.css">
        <link rel="stylesheet" href="Estilos/Estilo_Conductor.css">
        <title>Parada</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

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
                            <a class="nav-link" href="AdminInicioController"">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AdminPerfilController">Perfil</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AdminAportesController">Aportes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active text-danger" aria-current="page" href="AdminParadaController">Paradas</a>
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 col-sm-6 col-md-4 col-lg-3">
                    <canvas id="myChart"></canvas>
                </div>
            </div>
        </div>
        <section class="w-100 mx-auto text-center "id='intro'>
            <h2 class="text-info fw-bold">Historial Paradas</h2>
            <form action="AdminParadaController" method="post">
                <label>Buscar</label>
                <input type="numberr" placeholder="CI" name="ci">
                <input type="submit" name="enviar" value="Buscar">
            </form>
            <table class="table table-striped border-0">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>CI del Chofer</th>
                        <th>Nombre Completo</th>
                        <th>Fecha</th>
                        <th>N°Vueltas</th>
                        <th>Linea</th>
                        <th>Nombre completo del control</th>
                        <th>CI control</th>

                    </tr>
                </thead>

                <tr>
                    <c:forEach var="item" items="${registro}">
                    <tr>
                        <td>
                            ${item.n}
                        </td> 
                        <td>
                            ${item.ci_chofer}
                        </td> 
                        <td>
                            ${item.nombre} ${item.app} ${item.apm}
                        </td>
                        <td>
                            ${item.fecha}
                        </td>                                    
                        <td>
                            ${item.vueltas}
                        </td>
                        <td>
                            ${item.linea}
                        </td>
                        <td>
                            ${item.nombre_control} ${item.app_control} ${item.apm_control}
                        </td>
                        <td>
                            ${item.ci_control}
                        </td>



                    </tr>
                </c:forEach>
            </table>

        </section>

        <script src="javaScipt/reloj.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
    <script>
        var ctx = document.getElementById("myChart").getContext("2d");
        var myChart = new Chart(ctx, {
            type: "bar",
            data: {
                labels: ['1', '2', '3', '4', '5'],
                datasets: [{
                        label: 'Numero de vueltas realizados en un dia por Chofer',
                        data: [<%= request.getAttribute("cadenaSeparadaPorComas")%>]
                    }]
            }
        });
    </script>
</html>
