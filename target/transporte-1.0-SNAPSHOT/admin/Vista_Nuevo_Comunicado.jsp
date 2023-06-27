<%@page import="com.grupo.modelo.Admin"%>
<%
    Admin usuario = (Admin) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("LoginAdmin.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/style.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="Estilos/Estilo_Conductor.css">
        <!-- Iconos CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Nuevo Comunicado</title>
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
        <section class="w-50 mx-auto text-center "id='intro'>
            <h2 class="text-info fw-bold">Registro Comunicado</h2>
            <form class="row g-3" action="SubirImagen" method="post" enctype="multipart/form-data" accept-charset="UTF-8"> 

                <div class="form-floating">
                    Tipo:
                    <select class="form-select" id="floatingSelect" aria-label="Floating label select example" name="tipo" required>
                        <option value=""></option>
                        <option value="1">Comunicado</option>
                        <option value="2">Aviso</option>
                        <option value="3">Invitacion</option>
                        <option value="4">Otros</option>
                    </select>
                    <label for="floatingSelect">Seleccionar</label>
                </div>
                <div>
                    Para quienes va dirigido el comunicado:
                    <div class="form-check">
                        <input name="rol" class="form-check-input" type="radio" value="chofer" id="flexCheckChecked" required>
                        <label class="form-check-label" for="flexCheckDefault">
                            Choferes
                        </label>
                    </div>
                    <div class="form-check">
                        <input name="rol" class="form-check-input" type="radio" value="aportes" id="flexCheckChecked" required>
                        <label class="form-check-label" for="flexCheckDefault">
                            Control de aportes
                        </label>
                    </div>
                    <div class="form-check">
                        <input name="rol" class="form-check-input" type="radio" value="parada" id="flexCheckChecked" required>
                        <label class="form-check-label" for="flexCheckDefault">
                            Control de Rutas
                        </label>
                    </div>
                    <div class="form-check">
                        <input name="rol" class="form-check-input" type="radio" value="accidentes" id="flexCheckChecked" required>
                        <label class="form-check-label" for="flexCheckDefault">
                            Control de Accidentes
                        </label>
                    </div>
                    <div class="form-check">
                        <input name="rol" class="form-check-input" type="radio" value="todos" id="flexCheckChecked" required>
                        <label class="form-check-label" for="flexCheckDefault">
                            Todos
                        </label>
                    </div>
                </div>

                <div class="form-floating">
                    <textarea name="detalle" id="det" class="form-control" placeholder="Descripcion" id="floatingTextarea2" style="height: 100px" required></textarea>
                    <label for="floatingTextarea2">Contenido</label>
                </div>

                <div class="mb-3">
                    <input type="file" name="comunicado" accept="image/*" class="form-control" aria-label="file example" required>
                    <div class="invalid-feedback">Archivo de formulario no válido</div>

                </div>
                <div class="form-group text-center">
                    <button class="btn btn-success"name="action" value="add"> Enviar Comunicado</button>
                </div> 

            </form>
        </section>   
        <script src="javaScipt/reloj.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    
    </body>
</html>
