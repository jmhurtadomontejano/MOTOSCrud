<%-- 
    Document   : listar.jsp
    Created on : 15-nov-2021, 17:36:18
    Author     : DAW2
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Motos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            
        <h1>Listado de Motos</h1>
        <a class="btn btn-primary" href="Servlet?op=insertar">Nuevo Producto</a>
        <%
            List<Motos> listaMotos = ( List<Motos> )request.getAttribute("listado");
            String mensaje = ( String ) request.getAttribute("mensaje");
            String num_paginasStr = ( String )  request.getAttribute("num_paginas");
            int num_paginas = Integer.parseInt(num_paginasStr);
         %>
         
         <h2 class="alert alert-success"><%=mensaje%></h2>
         <table class="table">
         <% for ( Motos m: listaMotos ) { %>
         <tr>
             <td><%=m.getId() %></td>
             <td><%=m.getMarca() %></td>
             <td><%=m.getModelo() %> </td>
             <td><%=m.getCilindrada() %></td>
             <td><%=m.getFoto() %> </td>
             <td><a href="Servlet?op=borrar&id=<%=m.getId() %>" onclick="return Confirmation() ">Borrar</a></td>
             <td><a href="Servlet?op=actualizar&id=<%=m.getId() %>">Actualizar</a></td>
         </tr>
         <%}%>
         </table>
         <p>Mostrando página ${pagina} de ${num_paginas}</p>
         <%
             for ( int p=1;p<=num_paginas;p++ ) {
          %>
                 <a href="Servlet?op=listar&pagina=<%=p%>" ><%=p%></a> 
           <%      
             }
             %>
    </div>
         <script>
             function Confirmation(){
                 if (confirm("¿Está seguro/a de que quiere eliminar el producto?")  ) {
                    alert("El registro de eliminará");
                    return true;
                } else {
                    return false;
                }
                 
         }
             
             
             
         </script>
    </body>
</html>