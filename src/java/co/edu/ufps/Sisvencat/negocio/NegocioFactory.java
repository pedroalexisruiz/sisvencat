/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Administrador;
import java.io.Serializable;

/**
 *
 * @author salaas402
 */
public class NegocioFactory implements Serializable{

    public NegocioFactory() {
    }

    public IAdminNegocio getAdminNegocio(Administrador admin){
        return new AdminNegocio(admin);
    }
}
