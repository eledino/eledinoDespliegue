<%-- 
    Document   : VistaMenuVotante
    Created on : 19-nov-2018, 17:47:39
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
 <li>Votante
  <ul>
      
      <li><a href="VistaModificarVotante.jsp">Modificar Datos</a></li>
      <li><a href="../ServletControladorBajaVotante">Baja Votante</a></li>
  </ul>
 </li>
 <li>Censo
        <ul>
            <li><a href="../ServletControladorListadoVotantes">Listado Votantes</a></li>
      
      </ul>
 </li>
 <li>Votar
     <ul>
         <li><a href="VistaVotar.jsp">Votar</a></li>
          
      </ul>
 </li>

</ul>

    
    </body>
</html>
