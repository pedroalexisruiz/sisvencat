package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDAO.AdministradorDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.CampañaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.CategoriasDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.ColorDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.GerenteDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.ImagenPremioDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.ImagenProductoDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOAdministrador;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOCampana;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOImagenPremio;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOImagenProducto;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOVendedor;
import co.edu.ufps.Sisvencat.models.ClasesDAO.PedidoDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.PersonaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.PremioDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.ProductoDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.TallasDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.TipoDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.VendedorDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.ZonaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Administrador;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Color;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.ImagenPremioDTO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.ImagenProductoDTO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import co.edu.ufps.Sisvencat.models.util.Encriptador;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
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
            List<Campaña> campañas = new CampañaDAO().listarCampañasPorEstado(1);
            this.campañaActiva = (!campañas.isEmpty()) ? campañas.get(0) : null;
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

        Encriptador e = new Encriptador();
        
        if (this.admin.getContraseña().equals(e.encriptar(contrasena))) {

            IDAOAdministrador aDAO = new AdministradorDAO();
            this.admin.setContraseña(e.encriptar(contrasenanueva));

            return aDAO.cambiarContrasena(admin);
        } else {
            return false;
        }

    }

    @Override
    public boolean iniciarCampaña(Campaña campaña) throws SQLException, ParseException {

        IDAOCampana campañaDAO = new CampañaDAO();

        boolean estado = campañaDAO.iniciarCampaña(campaña);
        
        if(estado){
            this.campañaActiva = campañaDAO.listarCampañasPorEstado(1).get(0);
        }
        return estado;
    }

    @Override
    public Campaña getCampaña(String codigoCampaña) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Campaña> getListadoDeCampañas() throws SQLException, ParseException {

        IDAOCampana cDAO = new CampañaDAO();

        return cDAO.listarCampañas();
    }

    @Override
    public List<Campaña> getListadoDeCampañasPorEstado(int est) throws SQLException, ParseException {

        IDAOCampana cDAO = new CampañaDAO();

        return cDAO.listarCampañasPorEstado(est);
    }

    @Override
    public int modificarCampaña(Campaña campaña) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desactivarCampaña() throws SQLException {
        IDAOCampana cDAO = new CampañaDAO();
        boolean estado = cDAO.finalizarCampaña(campañaActiva);

        this.campañaActiva = null;
        return estado;
    }

    @Override
    public boolean registrarZona(Zona zona) throws SQLException {
        return new ZonaDAO().insertar(zona);
    }

    @Override
    public Zona getZona(int codigoZona) throws SQLException {

        ZonaDAO zDAO = new ZonaDAO();
        Zona zona = new Zona(codigoZona, null, 0);

        return zDAO.getZona(zona);
    }

    @Override
    public List<Zona> getListadoDeZonas() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Zona> getListadoDeZonasPorEstado(int estado) throws SQLException {

        return new ZonaDAO().listarPorEstado(estado);
    }

    @Override
    public boolean modificarZona(Zona zona) throws SQLException {

        return new ZonaDAO().modificar(zona);
    }

    @Override
    public boolean poseeGerente(int Zona_Codigo_z) throws SQLException {

        return new ZonaDAO().poseeGerente(Zona_Codigo_z);

    }

    @Override
    public boolean desactivarZona(Zona zona) throws SQLException {
        return new ZonaDAO().cambiarEstado(zona);
    }

    @Override
    public List<Gerente> getListadoDeGerentes() throws SQLException {

        GerenteDAO gDAO = new GerenteDAO();

        return gDAO.listar();

    }

    @Override
    public List<Gerente> getListadoDeGerentesPorEstado(int estado) throws SQLException {

        GerenteDAO gDAO = new GerenteDAO();

        return gDAO.listarPorEstado(estado);
    }

    @Override
    public boolean registrarGerente(Gerente gerente) throws SQLException {

        GerenteDAO gDAO = new GerenteDAO();

        return gDAO.insertar(gerente);

    }

    @Override
    public Gerente getGerente(String numDocumentoGerente) throws SQLException {

        GerenteDAO gDAO = new GerenteDAO();

        Gerente ge = gDAO.getGerente(numDocumentoGerente);

        return ge;
    }

    @Override
    public boolean actualizarGerente(Gerente gerente) throws SQLException {

        return new GerenteDAO().modificar(gerente);
    }

    @Override
    public boolean cambiarEstadoGerente(String cedula, int estado) throws SQLException {

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
    public List<Vendedor> getListadoDeVendedoresPorEstado(int est) throws SQLException {

        IDAOVendedor vDAO = new VendedorDAO();

        return vDAO.listarPorEstado(est);
    }

    @Override
    public List<Vendedor> getListadoDeVendedoresPorZona(String codigoZona) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int registrarVendedor(Vendedor vendedor) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vendedor getVendedor(String numDocVendedor) throws SQLException {

        return new VendedorDAO().getVendedor(numDocVendedor);
    }

    @Override
    public boolean actualizarVendedor(Vendedor vendedor) throws SQLException {

        return new VendedorDAO().modificar(vendedor);

    }

    @Override
    public boolean cambiarEstadoVendedor(String cedula, int estado) throws SQLException {

        Vendedor vendedor = new Vendedor();
        vendedor.setCedula(cedula);
        vendedor.setEstado(estado);

        return new VendedorDAO().cambiarEstado(vendedor);
    }

    @Override
    public List<Premio> getListadoPremios() throws SQLException {
        return new PremioDAO().listar();
    }

    @Override
    public Producto getProducto(long codigo_p) {

        for (Producto producto : this.campañaActiva.getProductos()) {
            if (producto.getCodigo_p() == codigo_p) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public List<Categoria> getCategorias() throws SQLException {
        return new CategoriasDAO().getCategorias();
    }

    @Override
    public ArrayList<Tipo> getTiposDePrenda() throws SQLException {
        return new TipoDAO().getTipos();
    }

    @Override
    public ArrayList<Color> getColores() throws SQLException {
        return new ColorDAO().getColores();
    }

    @Override
    public ArrayList<String> getTallas() throws SQLException {
        return new TallasDAO().getTallas();
    }

    @Override
    public boolean modificarProducto(Producto p) throws SQLException {

        ProductoDAO pDAO = new ProductoDAO();
        boolean estado = pDAO.modificar(p);
        estado = estado && pDAO.desasignarColores(p.getCodigo_p());
        estado = estado && pDAO.desasignarTallas(p.getCodigo_p());
        estado = estado && pDAO.insertarColores(p);
        estado = estado && pDAO.insertarTallas(p);

        if (estado) {
            this.campañaActiva.setProductos(new ProductoDAO().listarPorCampaña(campañaActiva));
        }

        return estado;
    }

    @Override
    public boolean insertarImagenDeProducto(ArrayList<String> urls, long codigo_p) throws SQLException {

        ImagenProductoDTO imagen = null;
        ArrayList<ImagenProductoDTO> imagenes = new ArrayList();
        boolean estado = false;
        IDAOImagenProducto iDAO = new ImagenProductoDAO();

        for (int i = 0; i < urls.size(); i++) {
            imagen = new ImagenProductoDTO(urls.get(i));
            imagenes.add(imagen);
        }

        for (int i = 0; i < this.campañaActiva.getProductos().size(); i++) {

            if (this.campañaActiva.getProductos().get(i).getCodigo_p() == codigo_p) {
                this.campañaActiva.getProductos().get(i).getImagenes().addAll(imagenes);
                estado = iDAO.subirImagenes(this.campañaActiva.getProductos().get(i), imagenes);
                break;
            }
        }
        return estado;
    }

    @Override
    public Premio getPremio(long codig_pre) throws SQLException {

        for (Premio premio : new PremioDAO().listar()) {
            if (premio.getCodigo_premio() == codig_pre) {
                return premio;
            }
        }
        return null;
    }

    @Override
    public boolean modificarPremio(Premio p) throws SQLException {
        return new PremioDAO().modificar(p);
    }

    @Override
    public boolean insertarImagenDePremio(ArrayList<String> urls, long codigo_p) throws SQLException {

        ImagenPremioDTO imagen = null;
        ArrayList<ImagenPremioDTO> imagenes = new ArrayList();
        boolean estado = false;
        IDAOImagenPremio iDAO = new ImagenPremioDAO();
        PremioDAO pDAO = new PremioDAO();

        List<Premio> premios = pDAO.listar();
        Premio premio = null;

        for (int i = 0; i < urls.size(); i++) {
            imagen = new ImagenPremioDTO(urls.get(i));
            imagenes.add(imagen);
        }

        for (int i = 0; i < premios.size(); i++) {
            premio = premios.get(i);

            if (premio.getCodigo_premio() == codigo_p) {
                premio.getImagenes().addAll(imagenes);
                estado = iDAO.insertar(premio, imagenes);
                break;
            }
        }
        return estado;
    }

    @Override
    public List<Pedido> getPedidos() throws SQLException, ParseException {
        return new PedidoDAO().listarPorCampaña(this.campañaActiva);
    }
    
    @Override
    public boolean subirProductos(ArrayList<Producto> productos) throws SQLException{
        ProductoDAO pDAO = new ProductoDAO();
        boolean estado = pDAO.insertarVarios(productos, campañaActiva);
        this.campañaActiva.setProductos(pDAO.listarPorCampaña(campañaActiva));
        return estado;
    }

}
