/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Prueba {

    public static void main(String[] args) {

        Campaña ca = new Campaña();
        ca.setCodigo_cam(2);
        CampañaDAO caDAO = new CampañaDAO();

        ProductoDAO pDAO = new ProductoDAO();

        List<Producto> productos;
        try {
            productos = pDAO.listarDisponibleoNo(ca, false);
            for (Producto producto : productos) {
                System.out.println(producto.toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
