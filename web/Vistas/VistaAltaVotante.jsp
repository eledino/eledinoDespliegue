<%-- 
    Document   : VistaAltaVotante
    Created on : 19-nov-2018, 17:50:24
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

*{
    font-family: sans-serif;
    font-size: 12px;
    color: #798e94;
}
body{
    width: 400px;
    margin: auto;
    background-color: #E2ECEE;
}
.contacto{
    border: 1px solid #CED5D7;
    border-radius: 6px;
    padding: 45px 45px 20px;
    margin-top: 50px;
    background-color: white;
    box-shadow: 0px 5px 10px #B5C1C5, 0 0 0 10px #EEF5F7 inset;
}
.contacto label{
    display: block;
    font-weight: bold;
}
.contacto div{
    margin-bottom: 15px;
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
.contacto input[type='submit']{
    border: 1px solid #CED5D7;
    box-shadow:0 0 0 3px #EEF5F7;
    padding: 8px 16px;
    border-radius: 20px;
    font-weight: bold;
    text-shadow: 1px 1px 0px white;
 
    background: #e4f1f6;
    background: -moz-linear-gradient(top, #e4f1f6 0%, #cfe6ef 100%);
    background: -webkit-linear-gradient(top, #e4f1f6 0%,#cfe6ef 100%);
}
.contacto input[type='submit']:hover{
    background: #edfcff;
    background: -moz-linear-gradient(top, #edfcff 0%, #cfe6ef 100%);
    background: -webkit-linear-gradient(top, #edfcff 0%,#cfe6ef 100%);
}
.contacto input[type='submit']:active{
    background: #cfe6ef;
    background: -moz-linear-gradient(top, #cfe6ef 0%, #edfcff 100%);
    background: -webkit-linear-gradient(top, #cfe6ef 0%,#edfcff 100%);
}
.contacto input[type='reset']{
    border: 1px solid #CED5D7;
    box-shadow:0 0 0 3px #EEF5F7;
    padding: 8px 16px;
    border-radius: 20px;
    font-weight: bold;
    text-shadow: 1px 1px 0px white;
 
    background: #e4f1f6;
    background: -moz-linear-gradient(top, #e4f1f6 0%, #cfe6ef 100%);
    background: -webkit-linear-gradient(top, #e4f1f6 0%,#cfe6ef 100%);
}
.contacto input[type='reset']:hover{
    background: #edfcff;
    background: -moz-linear-gradient(top, #edfcff 0%, #cfe6ef 100%);
    background: -webkit-linear-gradient(top, #edfcff 0%,#cfe6ef 100%);
}
.contacto input[type='reset']:active{
    background: #cfe6ef;
    background: -moz-linear-gradient(top, #cfe6ef 0%, #edfcff 100%);
    background: -webkit-linear-gradient(top, #cfe6ef 0%,#edfcff 100%);
}
    
</style>
<body> 
    <form action="../ServletControladorAltaVotante" class='contacto'  method="post"> 
    <p>Introduzca sus datos:<br>
    
     
     <label for="nif">Nif:</label>
     <input type="text" name= "nif" size="9"  maxlength="255" /><br>
     
     <label for="nombre">Nombre:</label>
     <input type="text" name=  "nombre" size="20" maxlength="255" ><br>
     
     <label for="apellidos">Apellidos:</label>
     <input type="text" name= "apellidos" size="20" maxlength="255" /><br> 
     
     <label for="domicilio">Domicilio:</label>
     <input type="text" name= "domicilio" size="20" maxlength="255" /><br> 
     
     <label for="fechaNac">FechaNac:</label>
     <input type="date" name= "fechaNac" size="20" maxlength="255" /><br>
    
     <label for="password">Password:</label>
     <input type="text" name= "password" size="20" maxlength="255" /><br>
   
     <br>
    <input type=submit name="submit" value= "ALTA"> 
    <a href="VistaMenuVotante.jsp">Volver al menú...</a> 
    </p>
    </form> 
</body> 
</html>
