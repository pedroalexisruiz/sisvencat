/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.controllers;

import co.edu.ufps.Sisvencat.facade.SisvencatFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Vendedor_Controller", urlPatterns = {"/Vendedor"})
public class Vendedor_Controller extends HttpServlet {
    
    SisvencatFacade Fachada;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String metodo = request.getParameter("metodo");
            String respuesta = "";
            
            Fachada = (SisvencatFacade) request.getSession().getAttribute("Fachada");
            
            switch (metodo) {
                case "modificarDatos":
                    
                    String nombre = request.getParameter("Nombre");
                    String apellido = request.getParameter("Apellido");
                    String direccion = request.getParameter("Direccion");
                    String telefono = request.getParameter("Telefono");
                    String correo = request.getParameter("Correo");
                    
                     {
                        try {
                            Fachada.modificarDatosVendedor(nombre, apellido, correo, direccion, telefono);
                            respuesta = "Datos Actualizados";
                        } catch (SQLException ex) {
                            respuesta = "No se actualizaron los datos. Error SQL: " + ex.getMessage();
                            ex.printStackTrace();
                        }
                    }
                    break;
                
                case "cambiarContraseña":
                    
                    String contrasena = request.getParameter("Contrasena");
                    String contrasenanueva = request.getParameter("ContrasenaNueva");
                    
                     {
                        try {
                            respuesta = (Fachada.cambiarContraseñaVendedor(contrasena, contrasenanueva)) ? "Contraseña Actualizada" : "La Contraseña Actual Es Incorrecta";
                        } catch (SQLException ex) {
                            respuesta = "No se pudo cambiar la contraseña. Error SQL: " + ex.getMessage();
                            ex.printStackTrace();
                        }
                    }
                    break;
            }
            out.print(respuesta);
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
