<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.grupo.modelo.Control_aportes"%>
<%
    Control_aportes usuario = new Control_aportes();
    if (session.getAttribute("loged") != "Aportes") {

        response.sendRedirect("login_aportes.jsp");
    } else {
        usuario = (Control_aportes) session.getAttribute("usuario");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>Registros</title>
        <link rel="stylesheet" href="style/style.css">
        <link rel="stylesheet" href="Estilos/Estilo_Conductor.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />    
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

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
                            <a class="nav-link" href="InicioController">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="PerfilController">Perfil</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="PagosController">Aportes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./Destroy_login">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <section class="w-100 mx-auto text-center "id='intro'>
            <h2 class="text-info fw-bold"> Historial Aportes</h2>


            <div>
                <form action="RegistrosController" method="post">
                    <input type="number" placeholder="CI" name="ci">
                    <input type="submit" value="Buscar">

                </form>
            </div>
            <table class="table table-striped border-0">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Monto</th>
                        <th>Fecha</th>
                        <th>Concepto</th>
                        <th>Sector</th>
                        <th> </th>
                    </tr>
                </thead>

                <c:forEach var="item" items="${ap}">
                    <tr>
                        <td data_titulo="#">
                            ${item.n_aporte}
                        </td >   
                        <td data_titulo="Nombre">
                            ${item.nombre} ${item.app} ${item.apm}
                        </td> 
                        <td data_titulo="Monto">
                            ${item.monto} Bs
                        </td>                                          
                        <td data_titulo="Fecha">
                            ${item.fecha}
                        </td>                                           
                        <td data_titulo="Concepto">
                            ${item.concepto}
                        </td>
                        <td data_titulo="Sector">
                            ${item.sector}
                        </td>

                        <td>
                            <a href="UsuarioController?id=${item.n_aporte}" class="drop-cart">
                                <i class="fa-regular fa-clipboard"></i>
                                Detalles
                            </a>
                        </td>
                    </c:forEach>


                </tr>
            </table>
        </section>
        <script src="javaScipt/reloj.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
