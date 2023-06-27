
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
                            </li>>
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
                                <div class="head-container">
                                    <h1 class="head-title">HISTORIAL DE ACCIDENTES</h1>

                                </div>
                            </div> 
                            <div class="cart-body table-responsive">
                                <table>
                                    <tr>
                                        <th>#</th>
                                        <th>Placa</th>
                                        <th>CI Chofer</th>
                                        <th>Concepto</th>
                                        <th>Detalles</th>
                                        <th>Ubicación</th>
                                        <th>Fecha</th>
                                    </tr>
                                    <tr>
                                        <td>
                                            001255
                                        </td>                                        
                                        <td>
                                            1018-rad
                                        </td>                                          
                                        <td>
                                            Lucas
                                        </td>                                           
                                        <td>
                                            coalicion
                                        </td>
                                        <td>
                                            nos chocamos y la policia esta aqui
                                        </td>
                                        <td>
                                            ciudad El Alto z/satelite c/10
                                        </td>
                                        <td>
                                            8/03/2019
                                        </td>

                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </section>
            </div>      
        </div>
        <script src="javaScipt/reloj.js"></script>
    </body>
</html>
