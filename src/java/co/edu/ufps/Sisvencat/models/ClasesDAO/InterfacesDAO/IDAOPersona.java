/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public interface IDAOPersona {
    
    public Persona login(Persona p)throws SQLException;
    
    public boolean modificarDatos(Persona p, int cedula) throws Exception;
    
    public boolean cambiarContrasena(Persona p) throws Exception;
    
    public void closeConn();
}