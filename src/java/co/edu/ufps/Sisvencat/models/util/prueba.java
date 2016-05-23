/*
 * @author Pedro Ruiz, Manuel Osorio, Yermison Chavez, Hender Guarin
 * @version Sisvencat 1.0 * 
 */
package co.edu.ufps.Sisvencat.models.util;

import co.edu.ufps.Sisvencat.models.ClasesDAO.ImagenPremioDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.ImagenProductoDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOProducto;
import co.edu.ufps.Sisvencat.models.ClasesDAO.ProductoDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.ImagenPremioDTO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.ImagenProductoDTO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Administrator
 */
public class prueba {
    
    public static void main(String[] args) {
        
        Campaña campaña = new Campaña();
        campaña.setCodigo_cam(1);
        try {
            IDAOProducto pDAO = new ProductoDAO();
            Producto p = new Producto();
            p.setCodigo_p(18);
            p= pDAO.getProducto(p);
            
            System.out.println(p.toString());
            for(ImagenProductoDTO imagen:p.getImagenes()){
                System.out.println(imagen.getUrlImagen());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
