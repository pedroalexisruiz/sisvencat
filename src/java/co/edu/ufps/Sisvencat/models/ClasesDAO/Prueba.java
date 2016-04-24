/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;

/**
 *
 * @author Administrador
 */
public class Prueba {

    public static void main(String[] args) {
        Zona zona = new Zona("Medellín");
        ZonaDAO zdao = new ZonaDAO();
        int x = zdao.insertar(zona);
        
        if(x==0){
            System.out.println("Si Inserté esa meirda");
        }
    }

}
