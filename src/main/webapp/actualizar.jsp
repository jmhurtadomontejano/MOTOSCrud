<%-- 
    Document   : actualizar
    Created on : 22-nov-2021, 17:42:59
    Author     : DAW2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <h1>Datos Moto</h1> 
        <a href="Servlet?op=listar">Volver</a>
        <%
           String mensaje = ( String ) request.getAttribute("mensaje");
           String operacion = ( String ) request.getAttribute("operacion");
           if ( mensaje!=null) out.println(mensaje);
         %>
        
        <form action="Servlet">
            <input type="hidden" value="<%=operacion%>" name="op">
            <p>Id<input type="text"  class="form-control" value="${producto.id}" name="id" readonly></p>
            <p>Marca:<input  type="text" class="form-control" value="${producto.marca}" name="marca"></p>
            <p>Modelo<input  type="text" class="form-control" value="${producto.modelo}" name="modelo"></p>
            <p>Cilindrada:<input type="text" class="form-control" value="${producto.cilindrada}" name="cilindrada"></p>
            <p>Foto:<input  type="text" class="form-control" value="${producto.foto}" name="foto"></p>
            
            <input type="submit" value="Actualizar Producto">
        </form>
    </body>
</html>