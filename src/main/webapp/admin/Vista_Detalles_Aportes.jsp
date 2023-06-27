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
        <link rel="stylesheet" href="style/style.css">
        <!-- Iconos CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Detalle de aportes</title>
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
        <button onclick="goBack()">Atrás</button>

  <script>
    function goBack() {
      history.back();
    }
  </script>

        <section class="w-100 mx-auto text-center "id='intro'>
            <h2 class="text-info fw-bold">Detalles Aporte</h2>
            <form >
                <div class="mb-3">
                    <label>N°</label>
                    <input readonly class="form-control-lg border-0 text-center" type="Number" placeholder="n" value="${aportes.n_aporte}">    
                </div>  
                <div class="mb-3">
                    <label>Nombre(s):</label>
                    <input readonly class="form-control-lg border-0 text-center" type="text" placeholder="usuario" value="${aportes.nombre} ">
                </div>
                <div class="mb-3">
                    <label>Apellidos:</label>
                    <input readonly class="form-control-lg border-0 text-center" type="text" placeholder="usuario" value="${aportes.app} ${aportes.apm}">
                </div>
                <div class="mb-3">
                    <label>Nombre(s) Registro:</label>
                    <input readonly class="form-control-lg border-0 text-center" type="text" placeholder="usuario" value="${aportes.nombre_aporte} ">
                </div>
                <div class="mb-3">
                    <label>Apellidos Registro:</label>
                    <input readonly class="form-control-lg border-0 text-center" type="text" placeholder="usuario" value="${aportes.app_aportes} ${aportes.apm_aportes}">
                </div>
                <div class="mb-3">
                    <label>Fecha:</label>
                    <input  readonly class="form-control-lg border-0 text-center" type="Date" placeholder="fecha"  value="${aportes.fecha}"> 
                </div> 
                <div class="mb-3">
                    <label>CI Chofer:</label>
                    <input  readonly class="form-control-lg border-0 text-center" type="Number" placeholder="fecha"  value="${aportes.ci}"> 
                </div> 
                <div class="mb-3">
                    <label>CI Registro:</label>
                    <input  readonly class="form-control-lg border-0 text-center" type="Number" placeholder="fecha"  value="${aportes.ci_a}"> 
                </div> 
                <div class="mb-3">    
                    <label>Concepto:</label>
                    <input readonly class="form-control-lg border-0 text-center" type="text" placeholder="concepto" value="${aportes.concepto}"> 
                </div>
                <div class="mb-3">    
                    <label>Sector:</label>
                    <input readonly class="form-control-lg border-0 text-center" type="text" placeholder="concepto" value="${aportes.sector}"> 
                </div>
                <div class="mb-3">    
                    <label>Grupo:</label>
                    <input readonly class="form-control-lg border-0 text-center" type="number" placeholder="concepto" value="${aportes.grupo}"> 
                </div>
                <div class="mb-3">
                    <label>Placa Vehiculo:</label>
                    <input readonly class="form-control-lg border-0 text-center" type="texte" placeholder="concepto" value="${aportes.placa}"> 
                </div>
                <div class="mb-3">    
                    <label>Monto:</label>
                    <input readonly class="form-control-lg border-0 text-center" type="number" placeholder="concepto" value="${aportes.monto}"> 
                </div> 
            </form>


        </section>
        <script src="javaScipt/reloj.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
