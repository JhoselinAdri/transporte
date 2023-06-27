<%@page import="com.grupo.modelo.vistas.VistaDCV"%>
<%@page import="com.grupo.modelo.Chofer"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <title>Menu</title>
        <link rel="stylesheet" href="style/style.css">
        <link rel="stylesheet" href="Estilos/Estilo_Conductor.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />    
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Perfil</title>
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
                            <a class="nav-link active text-danger" aria-current="page" href="VistaChoferController">Perfil</a>
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
        <div class="main">
                <section class="w-70 mx-auto text-center "id='intro'>
            <h2 class="text-info fw-bold">Mi Perfil</h2>

            <form>
                <div class="mb-3">
                    <label>Nombre Completo:</label>
                    <input class="form-control-lg border-0" readonly type="text" value="<%=usuario.getNombre()%> <%=usuario.getApm()%> <%=usuario.getApm()%>">
                </div> 
                <div class="mb-3">
                    <label>Cedula de Identidad:</label>
                    <input class="form-control-lg border-0" readonly type="Number" value="<%=usuario.getCi()%>"> 
                </div>  
                <div class="mb-3">
                    <label>Numero Celular:</label>
                    <input class="form-control-lg border-0" readonly type="Number" value="<%=usuario.getN_celular()%>"> 
                </div> 
                <div class="mb-3">
                    <label>Nombre de Usuario:</label>
                    <input class="form-control-lg border-0" readonly type="text" value="<%=usuario.getUsername()%>"> 
                </div> 
            </form>
            <h2 class="text-info fw-bold">Datos Vehiculo</h2>
            <form action="vehi-data">
                <div class="mb-3">    
                    <label>Placa:</label>
                    <input class="form-control-lg border-0" readonly type="text" value="<%=usuario.getPlaca()%>"> 
                </div> 
                <div class="mb-3">    
                    <label>Modelo:</label>
                    <input class="form-control-lg border-0" readonly type="number" value="<%=usuario.getModelo()%>"> 
                </div> 
                <div class="mb-3">    
                    <label>Numero de asientos: </label>
                    <input class="form-control-lg border-0" readonly type="number" value="<%=usuario.getCapacidad()%>"> 
                </div> 
                <div class="mb-3">    
                    <label>Marca:</label>
                    <input class="form-control-lg border-0" readonly type="text" value="<%=usuario.getMarca()%>"> 
                </div> 
                <div class="mb-3">    
                    <label>Tipo:</label>
                    <input class="form-control-lg border-0" readonly type="text" value="<%=usuario.getTipo()%>"> 
                </div> 
                <div class="mb-3">    
                    <label>Estado:</label>
                    <input class="form-control-lg border-0" readonly type="text" value="<%=usuario.getEstado()%>"> 
                </div> 

            </form>
            <h2 class="text-info fw-bold">Datos de la licencia</h2>
            <form action="vehi-data">
                <div class="mb-3">    
                    <label>Numero de licencia:</label>
                    <input class="form-control-lg border-0" readonly type="number" value="<%=usuario.getLicencia_id()%>"> 
                </div> 
                <div class="mb-3">    
                    <label>Categoria:</label>
                    <input class="form-control-lg border-0" readonly type="text" value="<%=usuario.getCategoria()%>"> 
                </div> 
                <div class="mb-3">    
                    <label>Fecha Expiracion</label>
                    <input class="form-control-lg border-0" readonly type="date" value="<%=usuario.getFecha_exp()%>"> 
                </div> 

            </form>
            
            <a href="EditPasswordChofer?ci=<%=usuario.getCi()%>"><input  class="btn btn-secondary btn-sm rounded-0" id="inputGroupPrepend2" type="submit" value="Cambiar Contraseña"></a>
        </section>
<script src="javaScipt/reloj.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
