
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parada</title>
        <link rel="stylesheet" href="../Estilos/Estilo_Conductor.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />    

    </head>
    <body>
        <div class="main">
            <div class="container">
                <nav class="nav">
                    <div class="title">
                        <p>Coop. Mixto de Trasporte</p>
                    </div>
                </nav>
                <aside class="aside">
                    <h3 class="list-title">NAVEGACION</h3>
                    <div class="menu-nav">
                        <ul>
                            <li>
                                <a href="Menu.jsp"><span class="icon-list"><i></i></span>Inicio</a>
                            </li>
                            <li>
                                <a href="VistaChofer.jsp" ><span class="icon-list"><i></i></span>Perfil</a>
                            </li>
                            <li>
                                <a href="Vista_Aportes.jsp" ><span class="icon-list"><i></i></span>Aportes</a>
                            </li>
                            <li>
                                <a href="Vista_Parada.jsp" ><span class="icon-list"><i></i></span>Paradas</a>
                            </li>
                            <li>
                                <a href="Vista_Accidentes.jsp" ><span class="icon-list"><i></i></span>Accidentes</a>
                            </li>
                            <li>
                                <a href="../login.jsp" ><span class="icon-list"><i></i></span>Salir</a>
                            </li>
                        </ul>
                    </div>            
                </aside>
                <section class="section">
                    <div class="body-container">
                        <div class="body1">
                            <div class="head">
                                <div class="head-container">
                                    <h1 class="head-title">RUTAS</h1>

                                </div>
                            </div> 
                            <script>
                                function validarFecha() {
                                    var fechaInput = document.getElementById("fecha").value;
                                    var fechaSeleccionada = new Date(fechaInput);
                                    var fechaActual = new Date();

                                    if (fechaSeleccionada > fechaActual) {
                                        alert("La fecha seleccionada no puede ser posterior a la fecha actual.");
                                        return false;
                                    }
                                    return true;
                                }
                            </script>

                            <form onsubmit="return validarFecha();">
                                <label for="fecha">Fecha:</label>
                                <input type="date" id="fecha" name="fecha">
                                <input type="submit" value="Enviar">
                            </form>
                            <div class="cart-body table-responsive">
                                <table>
                                    <tr>
                                        <th>#</th>
                                        <th>Fecha</th>
                                        <th>N°Vueltas</th>
                                        <th>Observaciones</th>
                                        <th>Linea</th>
                                        <th></th>
                                    </tr>
                                    <tr>
                                        <td>
                                            001255
                                        </td>                                         
                                        <td>
                                            8/03/2019
                                        </td>                                      
                                        <td>
                                            2
                                        </td>
                                        <td>
                                            masivo
                                        </td>
                                        <td>
                                            91
                                        </td>
                                        <td>
                                            <a href="Vista_Det_Ruta.jsp" class="drop-cart">
                                                <i class="fa-regular fa-clipboard"></i>
                                                Detalles
                                            </a>
                                        </td>

                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </section>
            </div>    
        </div>
    </body>
</html>
