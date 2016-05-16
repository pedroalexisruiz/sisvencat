/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.controllers;

import co.edu.ufps.Sisvencat.facade.SisvencatFacade;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Administrador;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author salaas402
 */
@WebServlet(name = "Admin_Controller", urlPatterns = {"/Admin"})
public class Admin_Controller extends HttpServlet {

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
                            this.modificarDatos(nombre, apellido, correo, direccion, telefono);
                            respuesta = "Datos Actualizados";
                        } catch (SQLException ex) {
                            respuesta = "Error SQL: " + ex.getMessage();
                            ex.printStackTrace();
                        }
                    }
                    break;

                case "cambiarContraseña":

                    String contrasena = request.getParameter("Contrasena");
                    String contrasenanueva = request.getParameter("ContrasenaNueva");

                     {
                        try {
                            this.cambiarContraseña(contrasena, contrasenanueva);
                            respuesta = "Contraseña Actualizada";
                        } catch (SQLException ex) {
                            respuesta = "Error SQL: " + ex.getMessage();
                            ex.printStackTrace();
                        }
                    }
                    break;

                case "registrarGerente":

                    nombre = request.getParameter("Nombre");
                    apellido = request.getParameter("Apellido");
                    String cedula = request.getParameter("Cedula");
                    direccion = request.getParameter("Direccion");
                    telefono = request.getParameter("Telefono");
                    correo = request.getParameter("Correo");
                    int Zona_Codigo_z = Integer.parseInt(request.getParameter("Zona_Codigo_z"));
                    contrasena = request.getParameter("Contrasena");

                     {
                        try {
                            this.registrarGerente(Zona_Codigo_z, cedula, nombre, apellido, correo, direccion, telefono, contrasena);
                            respuesta = "Gerente Registrado";
                        } catch (SQLException ex) {
                            respuesta = "" + ex.getErrorCode();
                            ex.printStackTrace();
                        }
                    }
                    break;
                case "getZona": {
                    try {
                        respuesta = getZona(Integer.parseInt(request.getParameter("Zona_Codigo_z")));
                    } catch (SQLException ex) {
                        respuesta = "" + ex.getErrorCode();
                        ex.printStackTrace();
                    }
                    break;
                }
                case "modificarZona": {
                    try {
                        this.modificarZona(Integer.parseInt(request.getParameter("Zona_Codigo_z")), request.getParameter("nombreNuevo"));
                        respuesta = "Zona Modificada Correctamente";
                    } catch (SQLException ex) {
                        respuesta = ex.getMessage();
                        ex.printStackTrace();
                    }
                    break;
                }
                case "desactivarZona": {
                    try {
                        this.desactivarZona(Integer.parseInt(request.getParameter("Zona_Codigo_z")));
                        respuesta = "Zona Desactivada Correctamente";
                    } catch (SQLException ex) {
                        respuesta = "No se pudo Desactivar la Zona. Error SQL " + ex.getMessage();
                        ex.printStackTrace();
                    }
                    break;
                }
                case "getVendedor": {
                    try {
                        respuesta = getVendedor(request.getParameter("Cedula"));
                    } catch (SQLException ex) {
                        respuesta = "" + ex.getErrorCode();
                        ex.printStackTrace();
                    }
                    break;
                }
                case "modificarVendedor": {
                    cedula = request.getParameter("cedula");
                    nombre = request.getParameter("nombre");
                    apellido = request.getParameter("apellido");
                    direccion = request.getParameter("direccion");
                    telefono = request.getParameter("telefono");
                    correo = request.getParameter("correo");

                    try {
                        this.modificarVendedor(cedula, nombre, apellido, direccion, telefono, correo);
                        respuesta = "Vendedor Modificado Correctamente";
                    } catch (SQLException ex) {
                        respuesta = "No se pudo Actualizar el Vendedor. Error SQL : " + ex.getMessage();
                        ex.printStackTrace();
                    }
                    break;
                }
                case "desactivarVendedor": {
                    try {
                        this.desactivarVendedor(request.getParameter("cedula"));
                        respuesta = "Vendedor Desactivado Correctamente";
                    } catch (SQLException ex) {
                        respuesta = "No se pudo Desactivar al Vendedor. Error SQL " + ex.getMessage();
                        ex.printStackTrace();
                    }
                    break;
                }
                case "reactivarVendedor": {
                    try {
                        this.reactivarVendedor(request.getParameter("cedula"));
                        respuesta = "Vendedor Reactivado Correctamente";
                    } catch (SQLException ex) {
                        respuesta = "No se pudo Reactivar al Vendedor. Error SQL " + ex.getMessage();
                        ex.printStackTrace();
                    }
                    break;
                }
                case "getGerente": {
                    try {
                        respuesta = getGerente(request.getParameter("Cedula"));
                    } catch (SQLException ex) {
                        respuesta = "" + ex.getErrorCode();
                        ex.printStackTrace();
                    }
                    break;
                }
                case "modificarGerente": {
                    cedula = request.getParameter("cedula");
                    nombre = request.getParameter("nombre");
                    apellido = request.getParameter("apellido");
                    direccion = request.getParameter("direccion");
                    telefono = request.getParameter("telefono");
                    correo = request.getParameter("correo");

                    try {
                        this.modificarGerente(cedula, nombre, apellido, direccion, telefono, correo);
                        respuesta = "Gerente Modificado Correctamente";
                    } catch (SQLException ex) {
                        respuesta = "No se pudo Actualizar el Gerente. Error SQL : " + ex.getMessage();
                        ex.printStackTrace();
                    }
                    break;
                }
                case "desactivarGerente": {
                    try {
                        this.desactivarGerente(request.getParameter("cedula"));
                        respuesta = "Gerente Desactivado Correctamente";
                    } catch (SQLException ex) {
                        respuesta = "No se pudo Desactivar el Gerente. Error SQL " + ex.getMessage();
                        ex.printStackTrace();
                    }
                    break;
                }
                case "reactivarGerente": {
                    try {
                        this.reactivarGerente(request.getParameter("cedula"));
                        respuesta = "Gerente Reactivado Correctamente";
                    } catch (SQLException ex) {
                        respuesta = "No se pudo Reactivar el Gerente. Error SQL " + ex.getMessage();
                        ex.printStackTrace();
                    }
                    break;
                }
            }
            out.print(respuesta);
        }
    }

    private boolean reactivarGerente(String cedula) throws SQLException {

        return Fachada.getAdminN().cambiarEstadoGerente(cedula,1);
        
    }
    
    private boolean desactivarGerente(String cedula) throws SQLException {

        return Fachada.getAdminN().cambiarEstadoGerente(cedula,2);
        
    }
    
    private boolean modificarGerente(String cedula, String nombre, String apellido, String direccion, String telefono, String correo) throws SQLException {

        Vendedor vendedor = new Vendedor(0, cedula, nombre, apellido, correo, direccion, telefono, null, 3);

        return Fachada.getAdminN().actualizarVendedor(vendedor);
    }
    
    private boolean desactivarVendedor(String cedula) throws SQLException {

        return Fachada.getAdminN().cambiarEstadoVendedor(cedula,2);
        
    }
    
    private boolean reactivarVendedor(String cedula) throws SQLException {

        return Fachada.getAdminN().cambiarEstadoVendedor(cedula,1);
        
    }
    
    private boolean modificarVendedor(String cedula, String nombre, String apellido, String direccion, String telefono, String correo) throws SQLException {

        Vendedor vendedor = new Vendedor(0, cedula, nombre, apellido, correo, direccion, telefono, null, 3);

        return Fachada.getAdminN().actualizarVendedor(vendedor);
    }

    private String getGerente(String cedula) throws SQLException {

        Gerente gerente = Fachada.getAdminN().getGerente(cedula);

        String respuesta = "<h1 class='text-primary text-center'>Modificar Datos de Gerente</h1><br>"
                + "<form id=\"formActualizarDatosGerente\">\n"
                + "                                    <h3>Datos Personales</h3>\n"
                + "\n"
                + "                                    <div class=\"row\">\n"
                + "                                        <div class=\"col-sm-6\">\n"
                + "                                            <div class=\"form-group\">\n"
                + "                                                <label for=\"firstname\">Nombres</label>\n"
                + "                                                <input type=\"text\" class=\"form-control\" name=\"nombre\" id=\"nombre\" value='" + gerente.getNombre() + "' required />\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                        <div class=\"col-sm-6\">\n"
                + "                                            <div class=\"form-group\">\n"
                + "                                                <label for=\"lastname\">Apellidos</label>\n"
                + "                                                <input type=\"text\" class=\"form-control\" name=\"apellido\" id=\"apellido\" value='" + gerente.getApellido() + "' required />\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                    <!-- /.row -->\n"
                + "\n"
                + "                                    <div class=\"row\">\n"
                + "                                        <div class=\"col-sm-6\">\n"
                + "                                            <div class=\"form-group\">\n"
                + "                                                <label for=\"street\">Dirección</label>\n"
                + "                                                <input type=\"text\" class=\"form-control\" name=\"direccion\" id=\"direccion\" value='" + gerente.getDireccion() + "' required />\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                        <div class=\"col-sm-6\">\n"
                + "                                            <div class=\"form-group\">\n"
                + "                                                <label for=\"phone\">Teléfono</label>\n"
                + "                                                <input type=\"number\" class=\"form-control\" name=\"telefono\" id=\"telefono\" value='" + gerente.getTelefono() + "' required />\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                    <!-- /.row -->\n"
                + "\n"
                + "                                    <div class=\"row\">\n"
                + "\n"
                + "                                        <div class=\"col-sm-6\">\n"
                + "                                            <div class=\"form-group\">\n"
                + "                                                <label for=\"email\">Correo</label>\n"
                + "                                                <input type=\"email\" name=\"correo\" id=\"correo\" value='" + gerente.getCorreo() + "' class=\"form-control\" required title=\"Correo No Válido\" />\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "<div class='row'>"
                + "<div class='col-sm-6 col-sm-offset-3 text-center'>"
                + "<div class='col-sm-6 text-center'>"
                + "<button name='btnModificarDatosVendedor' id='" + gerente.getCedula() + "' onclick='guardarDatosGerente()' type='button' class='btn btn-primary'><i class='fa fa-save'></i> Guardar Cambios</button>"
                + "</div>"
                + "<div class='col-sm-6 text-center'>"
                + "<button class='btnCancelar btn btn-default' type='button' onclick='ocultarDiv(1)'>Cancelar</button>"
                + "</div>"
                + "</div>"
                + "</div>"
                + "                                </form>";

        return respuesta;
    }

    private String getVendedor(String cedula) throws SQLException {

        Vendedor vendedor = Fachada.getAdminN().getVendedor(cedula);

        String respuesta = "<h1 class='text-primary text-center'>Modificar Datos de Gerente</h1><br>"
                + "<form id=\"formActualizarDatosGerente\">\n"
                + "                                    <h3>Datos Personales</h3>\n"
                + "\n"
                + "                                    <div class=\"row\">\n"
                + "                                        <div class=\"col-sm-6\">\n"
                + "                                            <div class=\"form-group\">\n"
                + "                                                <label for=\"firstname\">Nombres</label>\n"
                + "                                                <input type=\"text\" class=\"form-control\" name=\"nombre\" id=\"nombre\" value='" + vendedor.getNombre() + "' required />\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                        <div class=\"col-sm-6\">\n"
                + "                                            <div class=\"form-group\">\n"
                + "                                                <label for=\"lastname\">Apellidos</label>\n"
                + "                                                <input type=\"text\" class=\"form-control\" name=\"apellido\" id=\"apellido\" value='" + vendedor.getApellido() + "' required />\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                    <!-- /.row -->\n"
                + "\n"
                + "                                    <div class=\"row\">\n"
                + "                                        <div class=\"col-sm-6\">\n"
                + "                                            <div class=\"form-group\">\n"
                + "                                                <label for=\"street\">Dirección</label>\n"
                + "                                                <input type=\"text\" class=\"form-control\" name=\"direccion\" id=\"direccion\" value='" + vendedor.getDireccion() + "' required />\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                        <div class=\"col-sm-6\">\n"
                + "                                            <div class=\"form-group\">\n"
                + "                                                <label for=\"phone\">Teléfono</label>\n"
                + "                                                <input type=\"number\" class=\"form-control\" name=\"telefono\" id=\"telefono\" value='" + vendedor.getTelefono() + "' required />\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "                                    <!-- /.row -->\n"
                + "\n"
                + "                                    <div class=\"row\">\n"
                + "\n"
                + "                                        <div class=\"col-sm-6\">\n"
                + "                                            <div class=\"form-group\">\n"
                + "                                                <label for=\"email\">Correo</label>\n"
                + "                                                <input type=\"email\" name=\"correo\" id=\"correo\" value='" + vendedor.getCorreo() + "' class=\"form-control\" required title=\"Correo No Válido\" />\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "<div class='row'>"
                + "<div class='col-sm-6 col-sm-offset-3 text-center'>"
                + "<div class='col-sm-6 text-center'>"
                + "<button name='btnModificarDatosVendedor' id='" + vendedor.getCedula() + "' onclick='guardarDatosVendedor()' type='button' class='btn btn-primary'><i class='fa fa-save'></i> Guardar Cambios</button>"
                + "</div>"
                + "<div class='col-sm-6 text-center'>"
                + "<button class='btnCancelar btn btn-default' type='button' onclick='ocultarDiv(1)'>Cancelar</button>"
                + "</div>"
                + "</div>"
                + "</div>"
                + "                                </form>";

        return respuesta;
    }

    private boolean desactivarZona(int Zona_Codigo_z) throws SQLException {

        Zona zona = new Zona(Zona_Codigo_z, null, 2);

        return Fachada.getAdminN().desactivarZona(zona);
    }

    private boolean modificarZona(int Zona_Codigo_z, String nombre) throws SQLException {

        Zona zona = new Zona(Zona_Codigo_z, nombre, 1);

        return Fachada.getAdminN().modificarZona(zona);
    }

    private String getZona(int Codigo_Z) throws SQLException {

        Zona zona = Fachada.getAdminN().getZona(Codigo_Z);

        String respuesta = "<h1 class='text-primary text-center'>Modificar Zona</h1><br>"
                + "<div class='row'>"
                + "<div class='col-sm-6 col-sm-offset-3 text-center'>"
                + "<div class='form-group'>"
                + "<label><h4>Nuevo Nombre</h4></label>"
                + "<input class='form-control' type='text' name='NombreNuevoZona' valor='" + zona.getCodigo_z() + "' value='" + zona.getNombre() + "' required/>"
                + "</div>"
                + "</div>"
                + "</div>"
                + "<div class='row'>"
                + "<div class='col-sm-6 col-sm-offset-3 text-center'>"
                + "<div class='col-sm-6 text-center'>"
                + "<button name='btnModificarDatosZona' onclick='guardarDatosZona()' type='submit' class='btn btn-primary'><i class='fa fa-save'></i> Guardar Cambios</button>"
                + "</div>"
                + "<div class='col-sm-6 text-center'>"
                + "<button class='btnCancelar btn btn-default' onclick='ocultarDiv(1)'>Cancelar</button>"
                + "</div>"
                + "</div>"
                + "</div>";

        return respuesta;
    }

    private boolean registrarGerente(int Zona_Codigo_z, String cedula, String nombre, String apellido, String correo, String direccion, String telefono, String contrasena) throws SQLException {

        Gerente ge = new Gerente(null, new Zona(Zona_Codigo_z, null, 0), cedula, nombre, apellido, correo, direccion, telefono, contrasena, 2);

        return Fachada.getAdminN().registrarGerente(ge);
    }

    private boolean modificarDatos(String nombre, String apellido, String correo, String direccion, String telefono) throws SQLException {

        Administrador a = new Administrador(null, nombre, apellido, correo, direccion, telefono, null, 1);

        a.setCedula(Fachada.getAdminN().getAdmin().getCedula());
        a.setContraseña(Fachada.getAdminN().getAdmin().getContraseña());

        return Fachada.getAdminN().actualizarDatos(a);
    }

    private boolean cambiarContraseña(String contrasena, String contrasenanueva) throws SQLException {

        return Fachada.getAdminN().cambiarPassword(contrasena, contrasenanueva);
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
