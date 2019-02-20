<%-- 
    Document   : VistaMenuAdmin
    Created on : 23-nov-2018, 11:38:42
    Author     : eledi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style>
   ul#menu {
 background: #333;
 width: 940px;
 float:left;
 padding: 5px;
}
  
ul#menu li {
 color: #fff;
 float: left;
 list-style: none;
 margin: 0% 5%;
}
  
ul#menu li:hover{
 color: #aaa073;
 cursor:pointer;
}
  
ul#menu ul {
 display: none;
 position: absolute;
 top: 49px;
 background: #333;
 color: #fff;
 padding: 5px 0px 5px 5px;
 margin: 0;
 }
  
ul#menu ul li{
 float: left;
 color: #fff;
 width:100%;
 margin:2% 0%;
}
 
 
ul#menu ul li a{
 color: #fff;
}
  
ul#menu ul li a:hover{
 color: #aaa073;
 cursor:pointer;
}
  
ul#menu li:hover ul ul,ul#menu li:hover ul ul ul,ul#menu li.iehover ul ul,ul#menu li.iehover ul ul ul {
 display: none;
 cursor:pointer;
}
  
ul#menu li:hover ul,ul#menu ul li:hover ul,ul#menu ul ul li:hover ul,ul#menu li.iehover ul,ul#menu ul li.iehover ul,ul#menu ul ul li.iehover ul {
 display: block;
 cursor:pointer;
}
    
        </style>
    </head>
    <body>
      
       <ul id="menu">
 
 <li>Censo
        <ul>
            <li><a href="../ServletControladorListadoVotantes">Listado Votantes</a></li>
      <li></li>
      </ul>
 </li>
 <li>Gestión Escrutinio
     <ul>
         <li><a href="../ServletControladorHacerEscrutinio">Hacer Escrutinio</a></li>
         <li><a href="VistaAbrirEscrutinio.jsp">Abrir Escrutinio</a></li>
            <li><a href="VistaCerrarEscrutinio.jsp">Cerrar Escrutinio</a></li>
            <li><a href="../ServletControladorVerEscrutinio">Resultados Escrutinio</a></li>
            
      </ul>
 </li>
 <li>Votar
     <ul>
         <li><a href="VistaVotar.jsp" >Votar</a></li>
 </li>
</ul>

    
    </body>
</html>
