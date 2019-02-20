

<%@page import="Modelo.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
       <style>
    body{
   
    width: 800px;
    margin: auto;
    background-color: #8CEBFF;
}
.contacto{
    border: 1px solid #03D3FF;
    border-radius: 6px;
    padding: 45px 45px 20px;
    margin-top: 50px;
    background-color: white;
    box-shadow: 0px 5px 10px #000000, 0 0 0 10px #03D3FF inset;
}
.contacto label{
    display: block;
    font-weight: bold;
}
.contacto div{
    margin-bottom: 15px;
}
.contacto input[type='submit']{
    border: 1px solid #CED5D7;
    box-shadow:0 0 0 3px #03D3FF;
    padding: 8px 16px;
    border-radius: 20px;
    font-weight: bold;
    text-shadow: 1px 1px 0px white;
 
    background: #03D3FF;
    background: -moz-linear-gradient(top, #e4f1f6 0%, #cfe6ef 80%);
    background: -webkit-linear-gradient(top, #e4f1f6 0%,#cfe6ef 80%);
}
.contacto input[type='submit']:hover{
    background: #edfcff;
    background: -moz-linear-gradient(top, #edfcff 0%, #cfe6ef 80%);
    background: -webkit-linear-gradient(top, #edfcff 0%,#cfe6ef 80%);
}
.contacto input[type='submit']:active{
    background: #cfe6ef;
    background: -moz-linear-gradient(top, #cfe6ef 0%, #edfcff 80%);
    background: -webkit-linear-gradient(top, #cfe6ef 0%,#edfcff 80%);
}
.contacto input[type='text'], .contacto textarea{
    padding: 7px 6px;
    width: 294px;
    border: 1px solid #CED5D7;
    resize: none;
    box-shadow:0 0 0 3px #EEF5F7;
    margin: 5px 0;
}
.contacto input[type='text']:focus, .contacto textarea:focus{
    outline: none;
    box-shadow:0 0 0 3px #dde9ec;
}

.contacto input[type='number'], .contacto textarea{
    padding: 7px 6px;
    width: 150px;
    border: 1px solid #CED5D7;
    resize: none;
    box-shadow:0 0 0 3px #EEF5F7;
    margin: 5px 0;
}
    </style>
    <body>
          <%
            HttpSession objSesion = request.getSession(false); 
            
             Votante vot = (Votante) session.getAttribute("votante");
            //out.println("VOTANTES: " + aVotantes);
%>
         <form action="../ServletControladorCerrarEscrutinio"  method="post"> 
        <table width="500px" heigh="300px" class="contacto" align="center">
                    <tr>
                        <td colspan="3" align="center"><h1><strong>Cerrar Escrutinio</strong></h1>
                    </tr>
                    <tr>
                        <td align ="center"><h2>¿Desea cerrar el escrutinio?</h2> </td>
                        
                    </tr>
                    
                    <tr>
                        <td>
                            <input type=submit name="submit" value= "Si">
                        </td>
                    </tr>

                    <tr>
                        <td>
                             <%
                    if(vot.getRol().equals("Votante")){
                   %>
                   <a href="VistaMenuVotante.jsp"> Volver a Inicio</a>
                   <%
                    }
                    else if (vot.getRol().equals("Admin")){
                   %>
                   <a href="VistaMenuAdmin.jsp"> Volver a Inicio</a>
                   <%
                     }
                    %>
                        </td>
                       
                    </tr>
            </table>
         </form>
      
    </body>
</html>
