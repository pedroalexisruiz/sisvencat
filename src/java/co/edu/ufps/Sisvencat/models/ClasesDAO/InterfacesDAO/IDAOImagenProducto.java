/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.ImagenProductoDTO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public interface IDAOImagenProducto {
    
    public boolean subirImagenes(Producto pro, ArrayList<ImagenProductoDTO> imagenes) throws SQLException;

    public boolean eliminarImagenesDeProducto(Producto pro) throws SQLException;
    
    public boolean eliminarImagen(ImagenProductoDTO imagen) throws SQLException;

    public ArrayList<ImagenProductoDTO> getImagenesProducto(Producto pro) throws SQLException;

    public void closeConn() throws SQLException;
}
