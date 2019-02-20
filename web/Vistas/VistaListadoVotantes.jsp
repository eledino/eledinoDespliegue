<%-- 
    Document   : VistaListadoVotantes
    Created on : 22-nov-2018, 18:32:58
    Author     : eledi
--%>

<%@page import="Modelo.Votante"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
         <%
            HttpSession objSesion = request.getSession(false); 
            ArrayList<Votante> aVotantes = (ArrayList)objSesion.getAttribute("arrayVotantes");
            
             Votante vot = (Votante) session.getAttribute("votante");
            //out.println("VOTANTES: " + aVotantes);
%>
    <table style="width:100px; height: 150px; text-align: left; margin-left: auto; margin-right: auto;"
      border="1">
      <tbody>
        <tr align="center">
          <td style="background-color: #C6FE89;" colspan="8" rowspan="1">Listado de Votantes</td>
        </tr>
        <tr>
          <td style="width: 72.133px;background-color: #E0FDC0;">Nif </td>           
          <td style="width: 72.5px;background-color: #E0FDC0;">Nombre </td>
          <td style="width: 72.983px;background-color: #E0FDC0;">Apellidos </td>
          <td style="width: 72.983px;background-color: #E0FDC0;">Domicilio</td>
          <td style="width: 57.7167px;background-color: #E0FDC0;">Fecha Nacimiento</td>
          <td style="width: 70px;background-color: #E0FDC0;">Rol </td>
          <td style="width: 100.6833px;background-color: #E0FDC0;">Votado </td>
         
        </tr>
        <%
            for (Votante v : aVotantes){
        %>
        <tr>
          <td style="background-color: #E0FDC0;">
              <% out.println(v.getNif());%>
          </td>            
          <td style="background-color:#E0FDC0;text-align:center;">
               <% out.println(v.getNombre());%>
          </td>
          <td style="background-color:#E0FDC0;text-align:center;">
              <%out.println(v.getApellidos());%>
          </td>
           <td style="background-color:#E0FDC0;text-align:center;">
               <% out.println(v.getDomicilio()); %>
          </td>
          
          <td style="background-color:#E0FDC0;text-align:center;">
               <% out.println(v.getFechaNac());%>
          </td>
          <td style="background-color:#E0FDC0;text-align:center;">
               <% out.println(v.getRol());%>
          </td>
          <td style="background-color:#E0FDC0;text-align:center;">
               <%out.println(v.getVotado());%>
          </td>
        </tr>
        <%
            }
        %>
        <tr>
            <td style="text-align: center;"colspan="8"><br>
                <%
                    if(vot.getRol().equals("Votante")){
                   %>
                   <a href="VistaMenuVotante.jsp"> Volver Menú</a>
                   <%
                    }
                    else if (vot.getRol().equals("Admin")){
                   %>
                   <a href="VistaMenuAdmin.jsp"> Volver Menú</a>
                   <%
                     }
                    %>
                  
                
            </td>
        </tr>
      </tbody>
    </table>
    <p><br>
    </p>
    </body>
</html>
