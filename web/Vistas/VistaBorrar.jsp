<%-- 
    Document   : VistaMensajes
    Created on : 28-nov-2018, 12:01:15
    Author     : eledi
--%>

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
    background-color: #CAFBA0;
}
.contacto{
    border: 1px solid #CED5D7;
    border-radius: 6px;
    padding: 45px 45px 20px;
    margin-top: 50px;
    background-color: white;
    box-shadow: 0px 5px 10px #000000, 0 0 0 10px #94FE3A inset;
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
    box-shadow:0 0 0 3px #EEF5F7;
    padding: 8px 16px;
    border-radius: 20px;
    font-weight: bold;
    text-shadow: 1px 1px 0px white;
 
    background: #e4f1f6;
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
        <table width="500px" heigh="300px" class="contacto" align="center">
                    <tr>
                        <td colspan="3" align="center"><h1><strong>Mensaje</strong></h1>
                    </tr>
                    <tr>
                        <td align ="center"><h2><%  String mensaje = request.getParameter("mensaje"); out.println(mensaje);%></h2> </td>
                        
                    </tr>

                    <tr>
                        <td><a href="../index.jsp">Volver al inicio</a></td>
                       
                    </tr>
            </table>
       
      
    </body>
</html>
