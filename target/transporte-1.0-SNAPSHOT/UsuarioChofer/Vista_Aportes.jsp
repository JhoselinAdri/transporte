<%@ page import="com.grupo.dao.vista.VACDAOimpl" %>
<%@ page import="com.grupo.dao.vista.VCADAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.grupo.modelo.vistas.VistaAC" %>
<%@ page import="com.grupo.modelo.vistas.VistaDCV" %>
<%@ page import="com.grupo.modelo.Chofer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="style/style.css">
        <link rel="stylesheet" href="Estilos/Estilo_Conductor.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Ver Aportes</title>
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
                            <a class="nav-link active text-danger" aria-current="page" href="AportesController">Aportes</a>
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
            <h2 class="text-info fw-bold">Lista Aportes</h2>
            <input type="text" id="filtro" onkeyup="filtrarTabla()" placeholder="Buscar por fecha....">
            <table class="table table-striped border-0" id="tabla">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Monto</th>
                        <th>Fecha</th>
                        <th>Concepto</th>
                        <th>Sector</th>
                        <th> </th>
                    </tr>
                </thead>
                <c:forEach var="aporte" items="${aportes}"> 
                    <tr>
                        <td data_titulo="#">
                            ${aporte.n_aporte} 
                        </td>                                        
                        <td data_titulo="Monto:">
                            ${aporte.monto} Bs
                        </td>                                          
                        <td data_titulo="Fecha:">
                            ${aporte.fecha} 
                        </td>                                           
                        <td data_titulo="Concepto:">
                            ${aporte.concepto} 
                        </td>
                        <td data_titulo="Sector">
                            ${aporte.sector} 
                        </td>

                        <td>
                            <a href="./DetallesController?id_aporte=${aporte.n_aporte}" class="drop-cart">
                                <i class="fa-regular fa-clipboard"></i>
                                Detalles
                            </a>
                        </td>
                    </tr>
                </c:forEach>


            </table>

        </section>
        <script>
  function filtrarTabla() {
    var input, filter, table, tr, td, i;
    input = document.getElementById("filtro");
    filter = input.value.toUpperCase();
    table = document.getElementById("tabla");
    tr = table.getElementsByTagName("tr");

    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[2]; // Cambiar el índice para filtrar por una columna diferente

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
        <script src="javaScipt/reloj.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        
    </body>
</html>

