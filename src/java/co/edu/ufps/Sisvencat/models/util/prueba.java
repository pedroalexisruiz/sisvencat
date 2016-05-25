/*
 * @author Pedro Ruiz, Manuel Osorio, Yermison Chavez, Hender Guarin
 * @version Sisvencat 1.0 * 
 */
package co.edu.ufps.Sisvencat.models.util;

import co.edu.ufps.Sisvencat.models.ClasesDAO.PedidoDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.ProductoDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Color;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Item;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class prueba {

    public static void main(String[] args) {

        try {
            PedidoDAO pDAO = new PedidoDAO();
            Pedido p = pDAO.getPedidoDelVendedor("12345", 1);
            System.out.println(p.toString());
            for (Item item : p.getItems()) {
                System.out.println(item.toString());
                Producto pr = item.getProducto();
                System.out.println(pr.toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }
}
