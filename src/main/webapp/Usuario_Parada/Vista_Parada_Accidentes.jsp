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
        <title>JSP Page</title>
        <link rel="stylesheet" href="style/style.css">
    </head>
    <body>
        <div class="main">
            <div class="container">
                <nav class="nav">
                    <div class="title">
                        <p>Coop. Mixto de Trasporte</p>
                    </div>
                </nav>
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
                <aside class="aside">
                    <h3 class="list-title">NAVEGACION</h3>
                    <div class="menu-nav">
                        <ul>
                            <li>
                                <a href="PInicioController"><span class="icon-list"><i></i></span>Inicio</a>
                            </li>
                            <li>
                                <a href="PPerfilController" ><span class="icon-list"><i></i></span>Perfil</a>
                            </li>
                            <li>
                                <a href="PEntradaController" ><span class="icon-list"><i></i></span>Entrada</a>
                            </li>
                            <li>
                                <a href="PParadaController" ><span class="icon-list"><i></i></span>Salida</a>
                            </li>
                            <li>
                                <a href="./Destroy_login" ><span class="icon-list"><i></i></span>Salir</a>
                            </li>
                        </ul>
                    </div>            
                </aside>
                <section class="section">
                    <div class="body-container">
                        <div class="body1">
                            <div class="head">
                                <div class="head-label">

                                    <h2 class="head-title">ACCIDENTES</h2>
                                    <form action="user-data">
                                        <div class="mb-3">

                                            <label>Placa:</label>
                                            <input type="text" value="placa"> 
                                        </div>
                                        <div class="mb-3">

                                            Concepto:
                                            <input name="ccoalicion" type="checkbox">Coalicion
                                            <input name="arrollar" type="checkbox">Arrollar 
                                            <input name="multiple" type="checkbox">Multiple 
                                            <input name="simple" type="checkbox">Simple
                                            <input name="otro" type="checkbox">Otros
                                        </div>
                                        <div class="mb-3">

                                            <label>Detalles:</label>
                                            <textarea id="det" name="detalle"></textarea> 
                                        </div>
                                        <div class="mb-3">
                                            <label>Ubicación:</label>
                                            <input type="text" value="ubicacion"> 
                                        </div> 
                                        <a href=""><input type="submit" name="enviar" value="Enviar"></a>
                                        <a href="PDetalleController">Detalles</a>
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                </section>
            </div>      
        </div>
        <script src="javaScipt/reloj.js"></script>
    </body>
</html>
