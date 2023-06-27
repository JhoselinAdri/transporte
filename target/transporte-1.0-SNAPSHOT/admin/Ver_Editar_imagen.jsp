<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Iconos CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <link rel="stylesheet" href="Estilos/Style.css">
        <title>Imagen</title>
    </head>
    <body>
        

        <script>
            function goBack() {
                history.back();
            }
        </script>
        <div class="container">
            
            <button  class="button" onclick="goBack()">Atrás</button>
            <img src="comunicados/${com.nombre}" alt="alt"/>
            <a href="AdminVerImage?n=${com.n}"><input type="submit" value="Editar" class="button"></a>
            <a href="AdminDeleteImage?n=${com.n}"><input type="submit" value="Eliminar" class="button"></a>
        </div>

    </body>
</html>
