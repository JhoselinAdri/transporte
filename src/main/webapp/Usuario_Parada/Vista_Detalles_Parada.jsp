<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.grupo.modelo.Control_ruta"%>
<%
    Control_ruta usuario = new Control_ruta();
    if (session.getAttribute("loged") != "Parada") {

        response.sendRedirect("login_parada.jsp");
    } else {
        usuario = (Control_ruta) session.getAttribute("usuario");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="Estilos/Estilo_Conductor.css">
        <!-- Iconos CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Detalles Ruta</title>
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
                            <a class="nav-link active " href="#">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="PPerfilController">Perfil</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="PEntradaController">Entrada</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="PParadaController">Salida</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="TodosRegistrosController">Registro</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="./Destroy_login">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <button onclick="goBack()">Atrás</button>

  <script>
    function goBack() {
      history.back();
    }
  </script>

        <section class="w-100 mx-auto text-center "id='intro'>
            <h2 class="text-info fw-bold">Detalles de Ruta</h2>
            <form >

                <div class="mb-3">
                    <label>N°</label>
                    <input readonly type="Number" value="${n_ruta}">    
                </div>  
                <div class="mb-3">
                    <label>Nombre Completo:</label>
                    <input readonly type="text" value="${datos.nombre} ${datos.app} ${datos.apm}">
                </div>

                <div class="mb-3">
                    <label>CI Chofer:</label>
                    <input readonly type="Number" value="${datos.ci}"> 
                </div> 
                <div class="mb-3">
                    <label>Linea:</label>
                    <input readonly type="number" value="${linea}"> 
                </div> 
                <div class="mb-3">
                    <label>Placa Vehiculo:</label>
                    <input readonly type="texte" value="${datos.placa}"> 
                </div> 
            </form>
            <h2 class="text-info fw-bold">Lista Vueltas</h2>
            <table class="table table-striped border-0">
                <thead>
                    <tr>
                        <th>N° de Vuelta</th>
                        <th>Hora Entrada</th>
                        <th>Hora Salida</th>
                    </tr>
                </thead>
                <c:forEach var="item" items="${lista}">
                    <tr>
                        <td data_titulo="Numero">
                        ${item.numero}
                    </td>
                    <td data_titulo="Entrada">
                        ${item.hora_llegada}
                    </td>  
                    <td data_titulo="Salida">
                        ${item.hora_salida}
                    </td>
                    
                </tr>
                </c:forEach>
                
            </table>
        </section>
        <script src="javaScipt/reloj.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>

</html>
