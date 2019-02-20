/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.InsertarVotanteException;
import Modelo.Parametros;
import Modelo.Partido;
import Modelo.Votante;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eledi
 */
public class OperacionesDAO {
    
    private PreparedStatement prepSt;
    
    public void insertarVotante(Votante votante, Connection Conexion) throws SQLException {
        
        
            String nif = votante.getNif();
            String nombre = votante.getNombre();
            String apellidos = votante.getApellidos();
            String domicilio = votante.getDomicilio();
            Date fechaNac = Date.valueOf(votante.getFechaNac());
            String rol = votante.getRol();
            String password = votante.getPassword();
            String votado = votante.getVotado();
          try{  
              String insertVotante = "INSERT INTO VOTANTE VALUES (NULL,?,?,?,?,?,?,(AES_ENCRYPT(?,'eledino')),?)";
              prepSt = Conexion.prepareStatement(insertVotante);
              
              prepSt.setString(1,nif);
              prepSt.setString(2,nombre);
              prepSt.setString(3,apellidos);
              prepSt.setString(4,domicilio);
              prepSt.setDate(5,fechaNac);
              prepSt.setString(6,rol);
              prepSt.setString(7,password);
              prepSt.setString(8,votado);
              prepSt.executeUpdate();
 
        
        
        
        } catch (SQLException ex) {
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
          throw new SQLException(ex);
            
        }
        //return "vuelve";
    }//fin insertarVotante
    
    public ArrayList<Votante> listarVotantes(Connection Conexion) throws SQLException{
        
        ArrayList<Votante> arrayListVotantes = new ArrayList<Votante>();

        try{
            
        Statement s = Conexion.createStatement();
        
        ResultSet resultSet = s.executeQuery("SELECT * FROM VOTANTE");
        while (resultSet.next()) {
            Votante votante = new Votante();
            votante.setNif(resultSet.getString("nif"));
            votante.setNombre(resultSet.getString("nombre"));
            votante.setApellidos(resultSet.getString("apellidos"));
            votante.setDomicilio(resultSet.getString("domicilio"));
            votante.setFechaNac(resultSet.getDate("fechaNac").toLocalDate());
            votante.setRol(resultSet.getString("rol"));
            votante.setPassword(resultSet.getString("password"));
            votante.setVotado(resultSet.getString("votado"));
            
            arrayListVotantes.add(votante);
        }//fin while
    
        
        }catch (SQLException ex) {
          throw new SQLException(ex);
            
        }
        return arrayListVotantes;
    }//fin listarVotantes
    
    public Votante identificarVotante(String nif, String password, Connection Conexion) throws SQLException {

        Votante votante = new Votante();

        try {
            Statement s = Conexion.createStatement();
            /* String selectVotante = "SELECT nif,nombre,apellidos,domicilio,fechaNac,rol, AES_DECRYPT(password,'eledino') as password,votado FROM VOTANTE WHERE nif = '"+nif+"' AND PASSWORD =AES_ENCRYPT('"+password+"','eledino')";
          
              ResultSet resultSet = s.executeQuery(selectVotante);*/
            String selectVotante = "SELECT nif,nombre,apellidos,domicilio,fechaNac,rol, AES_DECRYPT(password,'eledino') as password,votado FROM VOTANTE WHERE nif = ? AND PASSWORD =AES_ENCRYPT(?,'eledino')";
            prepSt = Conexion.prepareStatement(selectVotante);

            prepSt.setString(1, nif);
            prepSt.setString(2, password);

            ResultSet resultSet = prepSt.executeQuery();
            if (resultSet.next()) {

                votante.setNif(resultSet.getString("nif"));
                votante.setNombre(resultSet.getString("nombre"));
                votante.setApellidos(resultSet.getString("apellidos"));
                votante.setDomicilio(resultSet.getString("domicilio"));
                votante.setFechaNac(resultSet.getDate("fechaNac").toLocalDate());
                votante.setRol(resultSet.getString("rol"));
                votante.setPassword(resultSet.getString("password"));
                votante.setVotado(resultSet.getString("votado"));
            }

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return votante;
    }//Fin identificarVotante
    
    public void modificarVotante(Votante votante,Connection conexion) throws SQLException{
        
        
            String nif = votante.getNif();
            String nombre = votante.getNombre();
            String apellidos = votante.getApellidos();
            String domicilio = votante.getDomicilio();
            Date fechaNac = Date.valueOf(votante.getFechaNac());
            String password = votante.getPassword();
            
            try{  
                
              String updateVotante = "UPDATE VOTANTE SET NOMBRE=?,APELLIDOS=?,DOMICILIO=?,FECHANAC=?,PASSWORD=AES_ENCRYPT(?,'eledino') WHERE NIF=? and votado='N'";
              prepSt = conexion.prepareStatement(updateVotante);
              
            
              prepSt.setString(1,nombre);
              prepSt.setString(2,apellidos);
              prepSt.setString(3,domicilio);
              prepSt.setDate(4,fechaNac);
             
              prepSt.setString(5,password);
              prepSt.setString(6,nif);
              prepSt.executeUpdate();
              
            } catch (SQLException ex) {
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
          throw new SQLException(ex);
            
        }
    }//fin modificarVotante
    
    public void borrarVotante(Votante votante, Connection conexion) throws SQLException{
        
        String nif = votante.getNif();
            
            
            try {
               Statement s = conexion.createStatement();
               String deleteVotante = "DELETE FROM VOTANTE WHERE NIF='"+nif+"'";
               
               s.executeUpdate(deleteVotante);
               
             } catch (SQLException ex) {
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
          throw new SQLException(ex);
            
        }
    }//fin borrarVotante
    
    
    public void votar(Votante votante, Connection conexion) throws SQLException{
        
        try{
            Statement s = conexion.createStatement();
            int resultado = s.executeUpdate("UPDATE VOTANTE SET VOTADO='Y' WHERE NIF='" + votante.getNif() + "';");
        } catch (SQLException SQLE) {
            throw new SQLException(SQLE);
        }
    }//fin Votar
    
    public void votarPartido(String partido, Connection conexion) throws SQLException{
        
        String siglas = partido;
        
        try{
            Statement s = conexion.createStatement();
            
            String actualizarVotos = "UPDATE PARTIDO SET VOTOS = VOTOS+1 WHERE SIGLAS ='"+siglas+"'";
            
            s.executeUpdate(actualizarVotos);
        } catch (SQLException ex){
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
          throw new SQLException(ex);
        }
    }// fin votarPartido
    
    public void abrirEscrutinio(Connection conexion) throws SQLException{
        
       try{
            Statement s = conexion.createStatement();
            
            String actualizarEs = "UPDATE PARAMETROS SET ESCRUTINIOABIERTO='Y',FINCONSULTA='N' WHERE ESCRUTINIOABIERTO='N'";
            
            s.executeUpdate(actualizarEs);
        } catch (SQLException ex){
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
          throw new SQLException(ex);
        }
    }//fin abrirEscrutinio
    
    public void cerrarEscrutinio(Connection conexion) throws SQLException{
        
       try{
            Statement s = conexion.createStatement();
            
            String actualizarEs = "UPDATE PARAMETROS SET ESCRUTINIOABIERTO='N', FINCONSULTA='Y' WHERE ESCRUTINIOABIERTO='Y'";
            
            s.executeUpdate(actualizarEs);
        } catch (SQLException ex){
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
          throw new SQLException(ex);
        }
    }//fin cerrarEscrutinio
    
    
    public void hacerEscrutinio(int esc, Connection conexion)throws SQLException{
        
        
             

        try{
            
        Statement s = conexion.createStatement();
        Statement u = conexion.createStatement();
        Statement f = conexion.createStatement();
            
             ArrayList<Partido> arrayListPartidos = new ArrayList<Partido>();
              ArrayList arrayListAux = new ArrayList();
           
            ResultSet resultSet = s.executeQuery("SELECT * FROM PARTIDO");
            while (resultSet.next()) {
                Partido partido = new Partido();
                partido.setDenominacion(resultSet.getString("denominacion"));
                partido.setSiglas(resultSet.getString("siglas"));
                partido.setVotos(resultSet.getInt("votos"));
                partido.setEscaños(resultSet.getInt("escaños"));

                arrayListPartidos.add(partido);
                arrayListAux.add(resultSet.getInt("votos"));
            }//fin while


        
         for (int i = 0; i < esc; i++) {
            
                int mayor = 0;
                int pos = 0;
                for (int j = 0; j < arrayListAux.size(); j++) {

                    if (mayor < Integer.parseInt(arrayListAux.get(j).toString())) {
                        mayor = Integer.parseInt(arrayListAux.get(j).toString());
       
                        pos = j;
                    }
                    
                }//fin for obtenerMayor
                String actualizarEscaños = "UPDATE PARTIDO SET VOTOS = VOTOS/2, ESCAÑOS = ESCAÑOS+1 WHERE VOTOS="+mayor+"";
              
                u.executeUpdate(actualizarEscaños);
                arrayListAux.remove(pos);
                arrayListAux.add(mayor/2);
                //arrayListPartidos.clear();
            }//fin for asignar escaño
         
         for(int i = 0; i < arrayListPartidos.size(); i++) {
            String actualizaVotos = "UPDATE PARTIDO SET VOTOS = "+arrayListPartidos.get(i).getVotos()+" WHERE SIGLAS = '"+arrayListPartidos.get(i).getSiglas()+"'";
             f.executeUpdate(actualizaVotos);
                }//actualiza los votos para dejarlos como al inicio
         
        } catch (SQLException ex){
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
          throw new SQLException(ex);
        }
    }
    public Parametros obtenerParametros(Parametros parametros, Connection conexion) throws SQLException{
        
        try{
            
            Statement s = conexion.createStatement();
            String selectParametros = "SELECT * FROM PARAMETROS";
            ResultSet rs = s.executeQuery(selectParametros);
            
            while(rs.next()){
                parametros.setCircunscripcion(rs.getString("circunscripcion"));
                parametros.setCandidatosAElegir(rs.getInt("candidatosAElegir"));
                parametros.setTipoConsulta(rs.getString("tipoConsulta"));
                parametros.setFechaConsulta(rs.getDate("fechaConsulta").toLocalDate());
                parametros.setEscrutinioAbierto(rs.getString("escrutinioAbierto"));
                parametros.setFinConsulta(rs.getString("finConsulta"));
            }
        } catch (SQLException ex) {
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
          throw new SQLException(ex);
            
        }
        return parametros;
    }//fin obtenerParametros
    
    public ArrayList<Partido> obtenerPartidos(Connection conexion) throws SQLException{
        
        ArrayList<Partido> arrayListPartido = new ArrayList<Partido>();
        try{
            
            Statement s = conexion.createStatement();
            String selectPartidos = "SELECT * FROM PARTIDO";
            ResultSet rs = s.executeQuery(selectPartidos);
            
            while(rs.next()){
                Partido partido = new Partido();
                partido.setDenominacion(rs.getString("denominacion"));
                partido.setEscaños(rs.getInt("Escaños"));
                partido.setVotos(rs.getInt("votos"));
                partido.setSiglas(rs.getString("siglas"));
                arrayListPartido.add(partido);
            }
        } catch (SQLException ex) {
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
          throw new SQLException(ex);
            
        }
        return arrayListPartido;
        
    }//fin obtenerPartidos
    
    
}//Fin OperacionesDAO
