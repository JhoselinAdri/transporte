<%@ page import="com.grupo.modelo.Control_aportes" %>
<%
    Control_aportes usuario = new Control_aportes();
    if (session.getAttribute("loged") != "Aportes") {
        response.sendRedirect("login_aportes.jsp");
    } else {
        usuario = (Control_aportes) session.getAttribute("usuario");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>Pagos</title>
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
                            <a class="nav-link active text-danger" aria-current="page" href="#">Aportes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./Destroy_login">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <section class="w-70 mx-auto text-center "id='intro'>
                <div>
                    <a href="RegistrosController"><input type="button" value="Registros"></a>
                </div>
                <h1 class="text-info fw-bold">Aportes</h1>
                <p>${men.mensaje}</p>
                <div>
                    <form name="buscar" action="PagosController" method="POST">
                        <input type="hidden" name="formulario" value="buscar">
                        <input required type="number" name="ci" placeholder="CI" minlength="7" maxlength="9"min="8888888" max="99999999">
                        <input type="submit" name="submitBuscar" value="Buscar">
                    </form>
                </div>
                <form name="registrar" action="PagosController" method="post">
                    <input type="hidden" name="formulario" value="registrar">
                    <input type="hidden" name="ci" value="${datos.ci}">
                    <input type="hidden" name="ci_aporte" value="<%=usuario.getCi()%>">
                    <input type="hidden" name="concepto" value="Pago Mensual">
                    <input type="hidden" name="sector" value="Masivo">
                    <input type="hidden" name="grupo" value="3">
                    <input type="hidden" name="placa" value="${datos.placa}">
                    <label>Nombres:</label>
                    <input readonly type="text" name="nombre" value="${datos.nombre}">
                    <label>Apellidos:</label>
                    <input readonly type="text" name="apellido" value="${datos.app} ${datos.apm}">
                    <label>Monto(bs.):</label>
                    <input required type="number" name="monto" max="200" min="1">
                    <input type="submit" name="submitRegistrar" value="REGISTRAR">
                </form>
            </div>
        </section>


        <script src="javaScipt/reloj.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        
        
    </body>
</html>
