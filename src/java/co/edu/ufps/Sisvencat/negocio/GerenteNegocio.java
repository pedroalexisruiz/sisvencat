/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDAO.GerenteDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOGerente;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOVendedor;
import co.edu.ufps.Sisvencat.models.ClasesDAO.VendedorDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.util.Encriptador;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class GerenteNegocio implements Serializable, IGerenteNegocio {

    private Gerente gerente;

    public GerenteNegocio() {
    }

    public GerenteNegocio(String cedula) throws SQLException {

        this.gerente = new GerenteDAO().getGerente(cedula);

    }

    @Override
    public Gerente getGerente() {
        return gerente;
    }

    @Override
    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    @Override
    public boolean actualizarDatos(Gerente ger) throws SQLException {

        IDAOGerente gDAO = new GerenteDAO();

        return gDAO.modificar(ger);
    }

    @Override
    public boolean cambiarPassword(String contrasena, String contrasenanueva) throws SQLException {

        Encriptador e = new Encriptador();
        if (this.gerente.getContraseña().equals(e.encriptar(contrasena))) {

            IDAOGerente gDAO = new GerenteDAO();
            this.gerente.setContraseña(e.encriptar(contrasenanueva));

            return gDAO.cambiarContraseña(gerente);

        } else {
            return false;
        }

    }

    @Override
    public boolean registrarVendedor(Vendedor vendedor) throws SQLException {

        IDAOVendedor vDAO = new VendedorDAO();
        return vDAO.registrar(vendedor, gerente);
        
    }

}
