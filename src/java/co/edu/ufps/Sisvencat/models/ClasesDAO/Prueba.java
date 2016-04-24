/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class Prueba {

    public static void main(String[] args) {
        Zona zona = new Zona(7,"Barrancabermeja", 2);
        ZonaDAO zdao = new ZonaDAO();
        int x = zdao.cambiarEstado(zona);
        
        List<Zona> zonas = zdao.listar();
        
        for (Zona zona1 : zonas) {
            System.out.println(zona1.getCodigo_z()+"-"+zona1.getNombre());
        }
    }

}
