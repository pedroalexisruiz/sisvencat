/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.ImagenPremioDTO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public interface IDAOImagenPremio {
    
    public boolean insertar(Premio pre, ArrayList<ImagenPremioDTO> imagenes) throws SQLException;

    public boolean eliminarImagenesDePremio(Premio pre) throws SQLException;
    
    public boolean eliminarImagen(ImagenPremioDTO imagen) throws SQLException;

    public ArrayList<ImagenPremioDTO> getImagenesPremio(Premio pre) throws SQLException;

    public void closeConn() throws SQLException;
}
