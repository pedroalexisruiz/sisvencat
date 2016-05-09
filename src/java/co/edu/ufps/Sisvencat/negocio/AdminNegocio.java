package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDAO.AdministradorDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.CampañaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOCampana;
import co.edu.ufps.Sisvencat.models.ClasesDAO.PersonaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Administrador;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminNegocio implements Serializable, IAdminNegocio {

    private Administrador admin;
    private Campaña campañaActiva;

    public AdminNegocio() {
    }

    public AdminNegocio(Administrador admin) {
        this.admin = admin;
        try {
            this.campañaActiva = new CampañaDAO().listarCampañasPorEstado(1).get(0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public Campaña getCampañaActiva() {
        return campañaActiva;
    }

    public void setCampañaActiva(Campaña campañaActiva) {
        this.campañaActiva = campañaActiva;
    }

    public boolean login(Persona p) throws SQLException {

        Persona pe = new PersonaDAO().login(p);

        if (pe.getTipoUsr() == 1) {
            this.admin = (Administrador) pe;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean actualizarDatos(Administrador admin) throws SQLException {

        AdministradorDAO aDAO = new AdministradorDAO();
        this.admin = admin;
        return aDAO.modificarDatos(admin);
    }

    @Override
    public boolean cambiarPassword(String contrasena, String contrasenanueva) throws SQLException {

        if (this.admin.getContraseña().equals(contrasena)) {

            AdministradorDAO aDAO = new AdministradorDAO();
            this.admin.setContraseña(contrasenanueva);

            return aDAO.cambiarContrasena(admin);
        } else {
            return false;
        }

    }

    @Override
    public int iniciarCampaña(Campaña campaña) {

        int respuesta = 0;
        IDAOCampana campañaDAO = new CampañaDAO();

        try {
            campañaDAO.inicarCampaña(campaña);
        } catch (SQLException ex) {
            respuesta = ex.getErrorCode();
            ex.printStackTrace();
        }

        return respuesta;
    }

    @Override
    public Campaña getCampaña(String codigoCampaña) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Campaña> getListadoDeCampañas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificarCampaña(Campaña campaña) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int desactivarCampaña(Campaña campaña) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int registrarZona(Zona zona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Zona getZona(String codigoZona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Zona> getListadoDeZonas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificarZona(Zona zona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int desactivarZona(Zona zona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Gerente> getListadoDeGerentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int registrarGerente(Gerente gerente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Gerente getGerente(String numDocumentoGerente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizarGerente(Gerente gerente, int numDocumento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int desactivarGerente(Gerente gerente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vendedor> getListadoDeVendedores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vendedor> getListadoDeVendedoresPorZona(String codigoZona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int registrarVendedor(Vendedor vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vendedor getVendedor(String numDocVendedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizarVendedor(Vendedor vendedor, int numDocumento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int desactivarVendedor(Vendedor vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
