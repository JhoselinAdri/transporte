<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.grupo.modelo.vistas.VistaDCV"%>

<%
    VistaDCV usuario = new VistaDCV();
    if (session.getAttribute("loged") != "Chofer") {

        response.sendRedirect("login_chofer.jsp");
    } else {
        usuario = (VistaDCV) session.getAttribute("usuario");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>JSP Page</title>
        <link rel="stylesheet" href="style/style.css">
        <link rel="stylesheet" href="Estilos/Estilo_Conductor.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />    
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
                            <a class="nav-link" href="menuController">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="VistaChoferController">Perfil</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AportesController">Aportes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ParadaController">Paradas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AccidenteController">Accidentes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Destroy_login">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <section class="w-100 mx-auto text-center "id='intro'>
            <h2 class="text-info fw-bold">Historial Accidentes</h2>
            <script>
  function filtrarTabla() {
    var input, filter, table, tr, td, i;
    input = document.getElementById("filtro");
    filter = input.value.toUpperCase();
    table = document.getElementById("tabla");
    tr = table.getElementsByTagName("tr");

    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[6]; // Cambiar el índice para filtrar por una columna diferente

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

<input type="text" id="filtro" onkeyup="filtrarTabla()" placeholder="Buscar por fecha">

<table class="table table-striped border-0 " id="tabla">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Placa</th>
                        <th>CI Chofer</th>
                        <th>Concepto</th>
                        <th>Detalles</th>
                        <th>Ubicación</th>
                        <th>Fecha</th>
                    </tr>
                </thead>
                    <c:forEach var="item" items="${ac}">
                        <tr>
                            <td data_titulo="#">
                                ${item.numero}
                            </td>                                        
                            <td data_titulo="Placa:">
                                ${item.placa}
                            </td>                                          
                            <td data_titulo="CI:">
                                ${item.ci}
                            </td >                                           
                            <td data_titulo="Concepto:">
                                ${item.concepto}
                            </td>
                            <td data_titulo="Detalle:">
                                ${item.detalle}
                            </td>
                            <td data_titulo="Ubicación:">
                                ${item.ubicacion}
                            </td>
                            <td data_titulo="Fecha:">
                                ${item.fecha}
                            </td>
                        </tr>
                    </c:forEach>
            </table>
        </section>
        <script src="javaScipt/reloj.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    
    </body>
</html>
