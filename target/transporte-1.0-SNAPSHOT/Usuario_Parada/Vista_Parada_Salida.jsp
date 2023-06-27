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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="Estilos/Estilo_Conductor.css">
        <!-- Iconos CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Registro para Entradas</title>
        <link rel="stylesheet" href="style/style.css">
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
                            <a class="nav-link" href="PInicioController">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="PPerfilController">Perfil</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="PEntradaController">Entrada</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active text-danger" aria-current="page" href="PParadaController">Salida</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="TodosRegistrosController">Registro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Destroy_login">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <section class="w-100 mx-auto text-center "id='intro'>
            <h2 class="text-info fw-bold">Registro de salidas</h2>
            <p>${mensaje.mensaje}</p>
            <form action="RegistroSalidaController" method="POST">
                <input required type="number" name="ci" placeholder="CI:" minlength="7" maxlength="9"min="8888888" max="99999999">
                <select  id="floatingSelect" aria-label="Floating label select example" name="linea" required>
                    <option value=""></option>
                    <option value="91">91</option>
                    <option value="92">92</option>
                    <option value="96">96</option>
                    <option value="99">99</option>
                </select>
                <input type="submit" name="enviar" value="Enviar">
            </form>

            <form name="buscar"  action="PParadaController" method="POST">
                <input type="hidden" name="formulario" value="llenar">
                <input type="hidden" name="id_ruta" value="${dato.n_ruta}">
                <input type="hidden" name="n_vuelta" value="${vuelta.n_vueta}">
                <input type="hidden" name="nom" value="${dato.nombre}">
                <div class="mb-3">
                    <label>Nombre Completo:</label>
                    <input class="form-control-lg border-0 text-center" readonly type="text" name="nombre" value="${dato.nombre} ${dato.app} ${dato.apm}">
                </div>

                <div class="mb-3">
                    <label>CI:</label>
                    <input class="form-control-lg border-0 text-center"readonly type="Number" value="${dato.ci}" name="ci">    
                </div>  

                <div class="mb-3">
                    <label> Numero Celular:</label>
                    <input class="form-control-lg border-0 text-center"readonly type="Number" value="${dato.celular}" >    
                </div>  
                <div class="mb-3">
                    <label> Observaciones:</label>
                    <input class="form-control-lg border-0 text-center"required  type="text" name="observacion"value="${vuelta.observaciones}" >    
                </div>  
                <input  class="btn btn-secondary btn-sm rounded-0" id="inputGroupPrepend2" type="submit" value="Registrar Salida">
            </form>


        </section>
        <script src="javaScipt/reloj.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
