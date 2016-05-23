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
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOImagenProducto {
    
    public boolean subirImagenes(Producto pro, ArrayList<ImagenProductoDTO> imagenes) throws Exception;

    public int modificarImagen(Producto pro, ImagenProductoDTO imagen) throws Exception;

    public boolean eliminarImagen(Producto pro, ImagenProductoDTO imagen) throws Exception;

    public List<ImagenProductoDTO> listar() throws Exception;

    public List<ImagenProductoDTO> listar(String where) throws Exception;

    public ImagenProductoDTO getImagenProducto(Producto pro) throws Exception;

    public boolean closeConn() throws SQLException;
}
