
package co.edu.ufps.Sisvencat.controllers;

import co.edu.ufps.Sisvencat.facade.SisvencatFacade;
import co.edu.ufps.Sisvencat.models.ClasesDAO.PersonaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
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
 * @author Administrador
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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

            String cedula = request.getParameter("cedula");
            String contrasena = request.getParameter("password");

            Persona p = new Persona();
            p.setCedula(cedula);
            p.setContraseña(contrasena);

            PersonaDAO pDAO = new PersonaDAO();

            try {
                p = pDAO.login(p);

                if (p.isValido()) {

                    SisvencatFacade fachada = new SisvencatFacade();
                    int n = p.getTipoUsr();
                    String ruta = "";
                    
                    switch (n) {
                        case 1:
                            fachada.iniciarNegocioAdmin(p);
                            ruta = "Admin/Profile.jsp";
                            break;
                        case 2:
                            fachada.iniciarNegocioGerente(p);
                            ruta = "Gerente/Profile.jsp";
                            break;
                        case 3:
                            fachada.iniciarNegocioVendedor(p);
                            ruta = "Vendedor/Profile.jsp";
                            break;
                        default:
                            break;
                    }
                    
                    request.getSession().setAttribute("Fachada", fachada);
                    out.print(ruta);
                } else {
                    out.print("Datos Erróneos");
                }
            } catch (SQLException ex) {
                out.print("Error En la Consulta" + p.getCedula()+"-"+p.getContraseña());
                ex.printStackTrace();
            }

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
