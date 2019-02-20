/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.ConexionBBDD;
import DAO.OperacionesDAO;
import Modelo.Parametros;
import Modelo.Votante;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eledi
 */
public class ServletControladorVotar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     private Connection Conexion;
    @Override
    public void init() throws ServletException {
        /* Establecemos la conexión, si no existe */
        try {
            ConexionBBDD ConexBD = ConexionBBDD.GetConexion();
            Conexion = ConexBD.GetCon();
        } catch (ClassNotFoundException cnfe) {
        } catch (SQLException sqle) {
        }
    }//fin init
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String part = request.getParameter("partido");
            HttpSession session = request.getSession(true);
            Votante votante = (Votante) session.getAttribute("votante");
             Parametros par = (Parametros) session.getAttribute("parametros");
             String nif = request.getParameter("nif");
             String password = request.getParameter("password");
            OperacionesDAO op = new OperacionesDAO();
            try {
               // Conexion.setAutoCommit(false);
                op.identificarVotante(nif, password, Conexion);
                session.getAttribute("votante");
                if(votante.getVotado().equals("N") && par.getEscrutinioAbierto().equals("Y") && par.getFinConsulta().equals("N")){
                op.votar(votante, Conexion);
                op.votarPartido(part, Conexion);
                session.setAttribute("votante",votante);
                
               // Conexion.commit();
                response.sendRedirect("Vistas/VistaMensajes.jsp?mensaje=Votación realizada correctamente, Gracias por su participación");
                }else{
                     //Conexion.commit();
                response.sendRedirect("Vistas/VistaErrores.jsp?mensaje=Voto fallido, no se cumplen las condiciones necesarias para votar");
                }

            } catch (SQLException ex) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletControladorVotar</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>nif:  " + ex + "</h1>");
                out.println("</body>");
                out.println("</html>");
                out.println(ex);
                if (Conexion != null) {
                    try {
                        Conexion.rollback();
                    } catch (SQLException SQLE2) {
                    }
                }
             }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletControladorVotar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletControladorVotar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
