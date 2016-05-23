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
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOImagenPremio {
    
    public boolean insertar(Premio pre, ArrayList<ImagenPremioDTO> imagenes) throws Exception;

    public int modificar(Premio pre, ImagenPremioDTO imagen) throws Exception;

    public boolean eliminar(Premio pre, ImagenPremioDTO imagen) throws Exception;

    public List<ImagenPremioDTO> listar() throws Exception;

    public List<ImagenPremioDTO> listar(String where) throws Exception;

    public ImagenPremioDTO getImagenPremio(ImagenPremioDTO imagen) throws Exception;

    public boolean closeConn() throws SQLException;
}
