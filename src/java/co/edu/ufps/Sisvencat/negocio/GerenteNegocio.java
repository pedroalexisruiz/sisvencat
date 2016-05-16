/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDAO.GerenteDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class GerenteNegocio implements Serializable, IGerenteNegocio{
    
    Gerente gerente;

    public GerenteNegocio() {
    }

    public GerenteNegocio(String cedula) throws SQLException {

        this.gerente = new GerenteDAO().getGerente(cedula);
        
    }
    
    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    
    
}
