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
        <link rel="stylesheet" href="Estilos/Estilo_Conductor.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../Estilos/Estilo_Conductor.css">
        <!-- Iconos CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <link rel="stylesheet" href="style/style.css">
        <title>Registros de usuarios</title>
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
        <section class="w-100 mx-auto text-center "id='intro'>
            <script>
                function filtrarTabla() {
                    var input, filter, table, tr, td, i;
                    input = document.getElementById("filtro");
                    filter = input.value.toUpperCase();
                    table = document.getElementById("tabla");
                    tr = table.getElementsByTagName("tr");

                    for (i = 0; i < tr.length; i++) {
                        td = tr[i].getElementsByTagName("td")[0]; // Cambiar el índice para filtrar por una columna diferente

                        if (td) {
                            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                                tr[i].style.display = "";
                            } else {
                                tr[i].style.display = "none";
                            }
                        }
                    }
                }
            </script>
            <h2 class="text-info fw-bold">Lista de Choferes</h2>
            <label>Buscar</label>
            <input type="number" id="filtro" onkeyup="filtrarTabla()" placeholder="Buscar por CI">
            <table class="table table-striped border-0" id="tabla">
                <thead>
                    <tr>
                        <th>CI</th>
                        <th>Nombre Completo</th>
                        <th>N° Celular</th>
                        <th>Licencia</th>
                        <th>Nombre de Usuario</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <c:forEach var="chofer" items="${ch}">
                    <tr>
                        <td data_titulo="CI">
                            ${chofer.ci}
                        </td> 
                        <td data_titulo="Nombre Completo">
                            ${chofer.nombre} ${chofer.app} ${chofer.apm}
                        </td>
                        <td data_titulo="N° Celular">
                            ${chofer.n_celular}
                        </td>                                                                                  
                        <td data_titulo="Licencia">
                            ${chofer.licencia}
                        </td>
                        <td data_titulo="Nombre de Usuario">
                            ${chofer.username}
                        </td>

                        <td>
                            <a href="AdminDetalleUsuario?action=edit&ci=${chofer.ci}" class="drop-cart">
                                <i class="fa-regular fa-clipboard"></i>
                                Editar 
                            </a>
                        </td>
                        <td>

                            <c:choose>
                                <c:when test="${chofer.estado=='activo'}">
                                    <a href="AdminDetalleUsuario?action=delete&ci=${chofer.ci}" class="drop-cart">
                                        <i class="fa-regular fa-clipboard"></i>
                                        Bloquear 
                                    </a>
                                </c:when>
                                <c:when test="${chofer.estado!='activo'}">
                                    <a href="AdminDetalleUsuario?action=habil&ci=${chofer.ci}" class="drop-cart">
                                        <i class="fa-regular fa-clipboard"></i>
                                        Desbloquear
                                    </a>

                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>



                        </td>

                    </tr>
                </c:forEach>

            </table>

            <script>
                function filtrarTabla1() {
                    var input, filter, table, tr, td, i;
                    input = document.getElementById("filtro1");
                    filter = input.value.toUpperCase();
                    table = document.getElementById("tabla1");
                    tr = table.getElementsByTagName("tr");

                    for (i = 0; i < tr.length; i++) {
                        td = tr[i].getElementsByTagName("td")[0]; // Cambiar el índice para filtrar por una columna diferente

                        if (td) {
                            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                                tr[i].style.display = "";
                            } else {
                                tr[i].style.display = "none";
                            }
                        }
                    }
                }
            </script>
            <h2 class="text-info fw-bold">Lista de agentes de parada</h2>
            <label>Buscar</label>
            <input type="number" id="filtro1" onkeyup="filtrarTabla1()" placeholder="Buscar por CI">
            <table class="table table-striped border-0" id="tabla1">
                <thead>
                    <tr>
                        <th>CI</th>
                        <th>Nombre Completo</th>
                        <th>N° Celular</th>
                        <th>Nombre de Usuario</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <c:forEach var="ruta" items="${ru}">
                    <tr>
                        <td data_titulo="CI">
                            ${ruta.ci}
                        </td> 
                        <td data_titulo="Nombre Completo">
                            ${ruta.nombre} ${ruta.app} ${ruta.apm}
                        </td>
                        <td data_titulo="N° Celular">
                            ${ruta.telefono}
                        </td>                                       
                        <td data_titulo="Nombre de Usuario">
                            ${ruta.username}
                        </td>                                            
                        <td>
                            <a href="AdminDetalleParada?action=edit&ci=${ruta.ci}" class="drop-cart">
                                <i class="fa-regular fa-clipboard"></i>
                                Editar
                            </a>
                        </td>
                        <td>

                            <c:choose>
                                <c:when test="${ruta.estado=='activo'}">
                                    <a href="AdminDetalleParada?action=delete&ci=${ruta.ci}" class="drop-cart">
                                        <i class="fa-regular fa-clipboard"></i>
                                        Bloquear 
                                    </a>
                                </c:when>
                                <c:when test="${ruta.estado!='activo'}">
                                    <a href="AdminDetalleParada?action=habil&ci=${ruta.ci}" class="drop-cart">
                                        <i class="fa-regular fa-clipboard"></i>
                                        Desbloquear
                                    </a>

                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>



                        </td>

                    </tr>
                </c:forEach>

            </table>
            <script>
                function filtrarTabla2() {
                    var input, filter, table, tr, td, i;
                    input = document.getElementById("filtro2");
                    filter = input.value.toUpperCase();
                    table = document.getElementById("tabla2");
                    tr = table.getElementsByTagName("tr");

                    for (i = 0; i < tr.length; i++) {
                        td = tr[i].getElementsByTagName("td")[0]; // Cambiar el índice para filtrar por una columna diferente

                        if (td) {
                            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                                tr[i].style.display = "";
                            } else {
                                tr[i].style.display = "none";
                            }
                        }
                    }
                }
            </script>
            <h2 class="text-info fw-bold">Lista de controles para los aportes</h2>
            <label>Buscar</label>
            <input type="number" id="filtro2" onkeyup="filtrarTabla2()" placeholder="Buscar por CI">
            <table class="table table-striped border-0" id="tabla2">
                <thead>
                    <tr>
                        <th>CI</th>
                        <th>Nombre Completo</th>
                        <th>N° Celular</th>
                        <th>Direccion</th>
                        <th>Nombre de Usuario</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <c:forEach var="aporte" items="${ap}">
                    <tr>
                        <td data_titulo="CI">
                            ${aporte.ci}
                        </td> 
                        <td data_titulo="Nombre Completo">
                            ${aporte.nombre} ${aporte.app} ${aporte.apm}
                        </td>
                        <td data_titulo="N° Celular">
                            ${aporte.telefono}
                        </td>   
                        <td data_titulo="Direccion">
                            ${aporte.direccion}
                        </td>  
                        <td data_titulo="Nombre de Usuario">
                            ${aporte.username}
                        </td>                                            
                        <td>
                            <a href="AdminDetalleAporte?action=edit&ci=${aporte.ci}" class="drop-cart">
                                <i class="fa-regular fa-clipboard"></i>
                                Editar 
                            </a>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${aporte.estado=='activo'}">
                                    <a href="AdminDetalleAporte?action=delete&ci=${aporte.ci}" class="drop-cart">
                                        <i class="fa-regular fa-clipboard"></i>
                                        Bloquear 
                                    </a>
                                </c:when>
                                <c:when test="${accidente.estado!='activo'}">
                                    <a href="AdminDetalleAporte?action=habil&ci=${aporte.ci}" class="drop-cart">
                                        <i class="fa-regular fa-clipboard"></i>
                                        Desbloquear
                                    </a>

                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>
                        </td>

                    </tr>
                </c:forEach>
            </table>
            <script>
                function filtrarTabla3() {
                    var input, filter, table, tr, td, i;
                    input = document.getElementById("filtro3");
                    filter = input.value.toUpperCase();
                    table = document.getElementById("tabla3");
                    tr = table.getElementsByTagName("tr");

                    for (i = 0; i < tr.length; i++) {
                        td = tr[i].getElementsByTagName("td")[0]; // Cambiar el índice para filtrar por una columna diferente

                        if (td) {
                            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                                tr[i].style.display = "";
                            } else {
                                tr[i].style.display = "none";
                            }
                        }
                    }
                }
            </script>
            <h2 class="text-info fw-bold">Lista de controles para los accidentes</h2>
            <label>Buscar</label>
            <input type="number" id="filtro3" onkeyup="filtrarTabla3()" placeholder="Buscar por CI">
            <table class="table table-striped border-0" id="tabla3">
                <thead>
                    <tr>
                        <th>CI</th>
                        <th>Nombre Completo</th>
                        <th>N° Celular</th>
                        <th>Direccion</th>
                        <th>Nombre de Usuario</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <c:forEach var="accidente" items="${acc}">
                    <tr>
                        <td data_titulo="CI">
                            ${accidente.ci}
                        </td> 
                        <td data_titulo="Nombre Completo">
                            ${accidente.nombre} ${accidente.app} ${accidente.apm}
                        </td>
                        <td data_titulo="N° Celular">
                            ${accidente.telefono}
                        </td>   
                        <td data_titulo="Direccion">
                            ${accidente.direccion}
                        </td>  
                        <td data_titulo="Nombre de Usuario">
                            ${accidente.username}
                        </td>                                            
                        <td>
                            <a href="AdminDetalleAccidente?action=edit&ci=${accidente.ci}" class="drop-cart">
                                <i class="fa-regular fa-clipboard"></i>
                                Editar
                            </a>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${accidente.estado=='activo'}">
                                    <a href="AdminDetalleAccidente?action=delete&ci=${accidente.ci}" class="drop-cart">
                                        <i class="fa-regular fa-clipboard"></i>
                                        Bloquear 
                                    </a>
                                </c:when>
                                <c:when test="${accidente.estado!='activo'}">
                                    <a href="AdminDetalleAccidente?action=habil&ci=${accidente.ci}" class="drop-cart">
                                        <i class="fa-regular fa-clipboard"></i>
                                        Desbloquear
                                    </a>

                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>
                        </td>

                    </tr>
                </c:forEach>
            </table>


        </section>
        <script src="javaScipt/reloj.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
