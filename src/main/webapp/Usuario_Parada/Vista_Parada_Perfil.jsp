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

        <title>Perfil</title>
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
                            <a class="nav-link active text-danger" aria-current="page" href="PPerfilController">Perfil</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="PEntradaController">Entrada</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="PEntradaController">Salida</a>
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
            <h2 class="text-info fw-bold">Mi Perfil</h2>
            <form >
                <div class="mb-3">
                    <label>Nombre(s):</label>
                    <input class="form-control-lg border-0 text-center" type="text" value="<%=usuario.getNombre()%>">
                </div>
                <div class="mb-3">
                    <label>Apellidos:</label>
                    <input class="form-control-lg border-0 text-center" type="text" value="<%=usuario.getApp()%> <%=usuario.getApm()%>">
                </div>
                <div class="mb-3">
                    <label>CI:</label>
                    <input class="form-control-lg border-0 text-center" type="number" value="<%=usuario.getCi()%>"> 
                </div> 

                <div class="mb-3">
                    <label>N° Celular:</label>
                    <input class="form-control-lg border-0 text-center" type="Number" value="<%=usuario.getTelefono()%>"> 
                </div> 

                <div class="mb-3">
                    <label>Usuario:</label>
                    <input class="form-control-lg border-0 text-center" type="text" value="<%=usuario.getUsername()%>">
                </div>

            </form>
            <a href="EditPasswordPa?ci=<%=usuario.getCi()%>"><input  class="btn btn-secondary btn-sm rounded-0" id="inputGroupPrepend2" type="submit" value="Editar Contraseña"></a>

        </section>
        <script src="javaScipt/reloj.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
