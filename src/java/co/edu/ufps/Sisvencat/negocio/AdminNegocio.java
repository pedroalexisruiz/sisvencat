package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDAO.AdministradorDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.CampañaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.GerenteDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOAdministrador;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOCampana;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOVendedor;
import co.edu.ufps.Sisvencat.models.ClasesDAO.PersonaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.PremioDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.VendedorDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.ZonaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Administrador;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class AdminNegocio implements Serializable, IAdminNegocio {

    private Administrador admin;
    private Campaña campañaActiva;

    public AdminNegocio() {
    }

    public AdminNegocio(Persona p) {
        
        this.admin = new Administrador();
        this.admin.setCedula(p.getCedula());
        this.admin.setNombre(p.getNombre());
        this.admin.setApellido(p.getApellido());
        this.admin.setCorreo(p.getCorreo());
        this.admin.setTipoUsr(1);
        this.admin.setDireccion(p.getDireccion());
        this.admin.setValido(true);
        this.admin.setTelefono(p.getTelefono());
        this.admin.setContraseña(p.getContraseña());
        
        try {
            this.campañaActiva = new CampañaDAO().listarCampañasPorEstado(1).get(0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public Administrador getAdmin() {
        return admin;
    }

    @Override
    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    @Override
    public Campaña getCampañaActiva() {
        return campañaActiva;
    }

    @Override
    public void setCampañaActiva(Campaña campañaActiva) {
        this.campañaActiva = campañaActiva;
    }

    @Override
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

            IDAOAdministrador aDAO = new AdministradorDAO();
            this.admin.setContraseña(contrasenanueva);

            return aDAO.cambiarContrasena(admin);
        } else {
            return false;
        }

    }

    @Override
    public int iniciarCampaña(Campaña campaña)throws SQLException {

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
    public Campaña getCampaña(String codigoCampaña)throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Campaña> getListadoDeCampañas() throws SQLException,ParseException {
        
        IDAOCampana cDAO = new CampañaDAO();
        
        return cDAO.listarCampañas();
    }
    
    @Override
    public List<Campaña> getListadoDeCampañasPorEstado(int est) throws SQLException,ParseException {
        
        IDAOCampana cDAO = new CampañaDAO();
        
        return cDAO.listarCampañasPorEstado(est);
    }

    @Override
    public int modificarCampaña(Campaña campaña)throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int desactivarCampaña(Campaña campaña)throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarZona(Zona zona)throws SQLException {
        return new ZonaDAO().insertar(zona);
    }

    @Override
    public Zona getZona(int codigoZona)throws SQLException {
        
        ZonaDAO zDAO = new ZonaDAO();
        Zona zona = new Zona(codigoZona,null,0);
        
        return zDAO.getZona(zona);
    }

    @Override
    public List<Zona> getListadoDeZonas()throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Zona> getListadoDeZonasPorEstado(int estado)throws SQLException{
        
        return new ZonaDAO().listarPorEstado(estado);
    }

    @Override
    public boolean modificarZona(Zona zona) throws SQLException{
        
        return new ZonaDAO().modificar(zona);
    }
    
    @Override
    public boolean poseeGerente(int Zona_Codigo_z) throws SQLException{
        
        return new ZonaDAO().poseeGerente(Zona_Codigo_z);
        
    }

    @Override
    public boolean desactivarZona(Zona zona) throws SQLException{
        return new ZonaDAO().cambiarEstado(zona);
    }

    @Override
    public List<Gerente> getListadoDeGerentes() throws SQLException{
        
        GerenteDAO gDAO = new GerenteDAO();
        
        return gDAO.listar();
        
    }
    
    @Override
    public List<Gerente> getListadoDeGerentesPorEstado(int estado)throws SQLException{
        
        GerenteDAO gDAO = new GerenteDAO();
        
        return gDAO.listarPorEstado(estado);
    }

    @Override
    public boolean registrarGerente(Gerente gerente) throws SQLException{
        
        GerenteDAO gDAO = new GerenteDAO();
        
        return gDAO.insertar(gerente);
        
    }

    @Override
    public Gerente getGerente(String numDocumentoGerente)throws SQLException {
        
        GerenteDAO gDAO = new GerenteDAO();
        
        Gerente ge = gDAO.getGerente(numDocumentoGerente);
        
        return ge;
    }

    @Override
    public boolean actualizarGerente(Gerente gerente) throws SQLException{
        
        return new GerenteDAO().modificar(gerente);
    }

    @Override
    public boolean cambiarEstadoGerente(String cedula, int estado) throws SQLException{
        
        Gerente ger = new Gerente();
        ger.setCedula(cedula);
        ger.setEstado(estado);
        
        return new GerenteDAO().cambiarEstado(ger);
    }

    @Override
    public List<Vendedor> getListadoDeVendedores() throws SQLException {
        
        IDAOVendedor vDAO = new VendedorDAO();
        
        return vDAO.listar();
    }
    
    @Override
    public List<Vendedor> getListadoDeVendedoresPorEstado(int est) throws SQLException{
        
        IDAOVendedor vDAO = new VendedorDAO();
        
        return vDAO.listarPorEstado(est);
    }

    @Override
    public List<Vendedor> getListadoDeVendedoresPorZona(String codigoZona) throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int registrarVendedor(Vendedor vendedor) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vendedor getVendedor(String numDocVendedor) throws SQLException{
        
        return new VendedorDAO().getVendedor(numDocVendedor);
    }

    @Override
    public boolean actualizarVendedor(Vendedor vendedor) throws SQLException{
        
        return new VendedorDAO().modificar(vendedor);
        
    }

    @Override
    public boolean cambiarEstadoVendedor(String cedula, int estado) throws SQLException{
        
        Vendedor vendedor = new Vendedor();
        vendedor.setCedula(cedula);
        vendedor.setEstado(estado);
        
        return new VendedorDAO().cambiarEstado(vendedor);
    }

    @Override
    public List<Premio> getListadoPremios() throws SQLException {
        
        return new PremioDAO().listar();
    }

}
