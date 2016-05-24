/*
 * @author Pedro Ruiz, Manuel Osorio, Yermison Chavez, Hender Guarin
 * @version Sisvencat 1.0 * 
 */
package co.edu.ufps.Sisvencat.models.util;


import co.edu.ufps.Sisvencat.models.ClasesDAO.ProductoDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Color;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Administrator
 */
public class prueba {
    
    public static void main(String[] args) {
        
        ArrayList<Producto> productos = new ArrayList();
        
        Producto p = null;
        Categoria cat = null;
        Tipo tipo = null;
        
        for (int i = 0; i < 10; i++) {
            cat = new Categoria();
            cat.setId(1);
            tipo = new Tipo();
            tipo.setId(1);
            p = new Producto("NombrePrueba"+i,"Descripcion"+i,i,i,cat,tipo,null);
            productos.add(p);
        }
        Campaña cam = new Campaña();
        cam.setCodigo_cam(1);
        try {
            ProductoDAO pDAO = new ProductoDAO();
            pDAO.insertarVarios(productos, cam);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
