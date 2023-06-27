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
                            <a class="nav-link" href="AdminInicioController"">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AdminPerfilController">Perfil</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active text-danger" href="AdminAportesController">Aportes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AdminParadaController">Paradas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="AdminAnteController">Accidentes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Destroy_login">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <section class="w-100 mx-auto text-center "id='intro'>
            <h2 class="text-info fw-bold">Actualizar Aportes</h2><!-- comment -->
            <p>${men.mensaje}</p>
            <form action="AdminEditarAporteController" method="post">

                <div class="mb-3">
                    <label>N°</label>
                    <input type="hidden" name="id" value="${aportes.n_aporte}">
                    <input class="form-control-lg border-0 w-50" readonly type="Number" value="${aportes.n_aporte}">    
                </div>  
                <div class="mb-3">
                    <label>Nombre Completo:</label>
                    <input class="form-control-lg border-0 w-50" readonly type="text" value="${aportes.nombre} ${aportes.app} ${aportes.apm}">
                </div>
                <div class="mb-3">
                    <label>Fecha:</label>
                    <input class="form-control-lg border-0 w-50" readonly type="Date" value="${aportes.fecha}"> 
                </div> 
                <div class="mb-3">
                    <label>CI Chofer:</label>
                    <input class="form-control-lg border-0 w-50" readonly type="Number" value="${aportes.ci}"> 
                </div> 
                <div class="mb-3">    
                    <label>Concepto:</label>
                    <input class="form-control-lg border-0 w-50" readonly type="text" value="${aportes.concepto}"> 
                </div>
                <div class="mb-3">
                    <label>Sector:</label>
                    <input class="form-control-lg border-0 w-50" readonly type="text" value="${aportes.sector}"> 
                </div> 
                <div class="mb-3">
                    <label>Grupo</label>
                    <input class="form-control-lg border-0 w-50" readonly type="text" value="${aportes.grupo}"> 
                </div> 
                <div class="mb-3">
                    <label>Placa Vehiculo:</label>
                    <input class="form-control-lg border-0 w-50"  readonly type="texte" value="${aportes.placa}"> 
                </div> 
                <div class="mb-3">
                    <label>Monto:</label>
                    <input class="form-control-lg border-0 w-50" type="number" value="${aportes.monto}" name="monto" min="0" max="200"> 
                </div> 
                <div class="mb-3">
     
                    <input class="form-control-lg border-0 w-50" type="submit"  name="enviar" value="Actualizar"> 
                </div> 
            </form>
              <div class="d-grid gap-2" class="p-3 bg-info bg-opacity-10 border border-info border-start-0 rounded-end">
                    <button class="btn btn-danger" onclick="goBack()">Atrás</button>
                </div>


                <script>
                    function goBack() {
                        history.back();
                    }
                </script>
        </section>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="javaScipt/reloj.js"></script>
    </body>
</html>
