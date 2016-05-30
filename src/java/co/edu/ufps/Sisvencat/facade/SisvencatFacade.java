package co.edu.ufps.Sisvencat.facade;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Color;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Item;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import co.edu.ufps.Sisvencat.models.util.Encriptador;
import co.edu.ufps.Sisvencat.negocio.IAdminNegocio;
import co.edu.ufps.Sisvencat.negocio.IGeneralNegocio;
import co.edu.ufps.Sisvencat.negocio.IGerenteNegocio;
import co.edu.ufps.Sisvencat.negocio.IVendedorNegocio;
import co.edu.ufps.Sisvencat.negocio.NegocioFactory;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SisvencatFacade implements Serializable {

    NegocioFactory invocador;
    IAdminNegocio adminN;
    IGeneralNegocio generalN;
    IGerenteNegocio gerenteN;
    IVendedorNegocio vendedorN;

    public SisvencatFacade() {
        this.invocador = new NegocioFactory();
    }

    public IAdminNegocio getAdminN() {
        return adminN;
    }

    public void iniciarNegocioAdmin(Persona p) {

        this.adminN = invocador.getAdminNegocio(p);
        this.generalN = null;
        this.gerenteN = null;
        this.vendedorN = null;

    }
    
    public boolean iniciarCampaña(Campaña cam)throws SQLException, ParseException{
        return this.adminN.iniciarCampaña(cam);
    }
    
    public boolean finalizarCampaña() throws SQLException{
        return this.adminN.desactivarCampaña();
    }
    
    public boolean subirProductos(ArrayList<Producto> productos)throws SQLException{
        return this.adminN.subirProductos(productos);
    }
    
    public boolean modificarProducto(Producto p) throws SQLException{
        return this.adminN.modificarProducto(p);
    }
    
    public boolean modificarPremio(Premio p) throws SQLException{
        return this.adminN.modificarPremio(p);
    }
    
    public List<Categoria> getCategorias() throws SQLException{
        if (this.adminN != null) {
            return this.adminN.getCategorias();
        }
        if (this.vendedorN != null) {
            return this.vendedorN.getCategorias();
        } else {
            return this.generalN.getCategorias();
        }
    }
    
    public ArrayList<Tipo> getTipos() throws SQLException{
        if (this.adminN != null) {
            return this.adminN.getTiposDePrenda();
        }
        if (this.vendedorN != null) {
            return this.vendedorN.getTiposDePrenda();
        } else {
            return this.generalN.getTiposDePrenda();
        }
    }
    
    public ArrayList<Color> getColores()throws SQLException{
        
        if (this.adminN != null) {
            return this.adminN.getColores();
        }
        if (this.vendedorN != null) {
            return this.vendedorN.getColores();
        } else {
            return this.generalN.getColores();
        }
    }
    
    public ArrayList<String> getTallas()throws SQLException{
        
        if (this.adminN != null) {
            return this.adminN.getTallas();
        }
        if (this.vendedorN != null) {
            return this.vendedorN.getTallas();
        } else {
            return this.generalN.getTallas();
        }
    }
    
    public boolean insertarImagenDeProducto(ArrayList<String> urls, long codigo_p) throws SQLException{
        return this.adminN.insertarImagenDeProducto(urls, codigo_p);
    }
    
    public boolean insertarImagenDePremio(ArrayList<String> urls, long codigo_p) throws SQLException{
        return this.adminN.insertarImagenDePremio(urls, codigo_p);
    }
    
    public List<Pedido> getPedidos() throws SQLException, ParseException{
        return this.adminN.getPedidos();
    }

    public boolean registrarPremio(Premio pre) throws SQLException{
        return this.adminN.subirPremio(pre);
    }
    
    public boolean registrarZona(Zona zona) throws SQLException{
        return this.adminN.registrarZona(zona);
    }
    
    public void iniciarNegocioGeneral() throws SQLException, ParseException {
        this.generalN = invocador.getGeneralNegocio();
        this.adminN = null;
        this.gerenteN = null;
        this.vendedorN = null;
    }

    public boolean existeNegocioGeneral() {
        return this.generalN != null;
    }
    
    public List<Producto> getProductosCampañaCategoriaYTipo(int cat, int tipo) throws SQLException{
        return this.generalN.getProductosCampañaPorCategoriaYTipoPrenda(cat, tipo);
    }
    
    public Categoria getCategoria(int id) throws SQLException{
        return this.generalN.getCategoria(id);
    }
    public void iniciarNegocioGerente(String cedula) throws SQLException {

        this.gerenteN = invocador.getGerenteNegocio(cedula);
        this.generalN = null;
        this.adminN = null;
        this.vendedorN = null;
    }

    public boolean existeNegocioGerente() {
        return this.gerenteN != null;
    }

    public Gerente getGerenteLogeado() {
        return this.gerenteN.getGerente();
    }

    public boolean modificarDatosGerente(String nombre, String apellido, String correo, String direccion, String telefono) throws SQLException {

        Gerente gerente = this.gerenteN.getGerente();
        gerente.setNombre(nombre);
        gerente.setApellido(apellido);
        gerente.setCorreo(correo);
        gerente.setDireccion(direccion);
        gerente.setTelefono(telefono);

        if (this.gerenteN.actualizarDatos(gerente)) {
            this.gerenteN.setGerente(gerente);
            return true;
        }

        return false;
    }

    public boolean cambiarContraseñaGerente(String contrasena, String contrasenanueva) throws SQLException {
        return this.gerenteN.cambiarPassword(contrasena, contrasenanueva);
    }

    public void iniciarNegocioVendedor(String cedula) throws SQLException, ParseException {
        this.vendedorN = invocador.getVendedorNegocio(cedula);
        this.generalN = null;
        this.adminN = null;
        this.gerenteN = null;
    }

    public boolean existeNegocioVendedor() {
        return this.vendedorN != null;
    }

    public Campaña getCampañaActiva() {

        if (this.adminN != null) {
            return this.adminN.getCampañaActiva();
        }
        if (this.vendedorN != null) {
            return this.vendedorN.getCampañaActiva();
        } else {
            return this.generalN.getCampañaActiva();
        }
    }

    public Producto getProducto(long codigo_p) {

        if (this.adminN != null) {
            return this.adminN.getProducto(codigo_p);
        }
        if (this.vendedorN != null) {
            return this.vendedorN.getProducto(codigo_p);
        } else {
            return this.generalN.getProducto(codigo_p);
        }
    }
    
    public Premio getPremio(long codigo_pre) throws SQLException{
        
        if (this.adminN != null) {
            return this.adminN.getPremio(codigo_pre);
        }
        if (this.vendedorN != null) {
            return this.vendedorN.getPremio(codigo_pre);
        } else {
            return this.generalN.getPremio(codigo_pre);
        }
    }

    public List<Premio> listarPremios() throws SQLException {
        if (this.adminN != null) {
            return this.adminN.getListadoPremios();
        } else {
            return this.vendedorN.listarPremios();
        }
    }

    public boolean registrarVendedor(int PuntajeAcumulado, String cedula, String nombre, String Apellido, String correo, String Direccion, String telefono, String contraseña) throws SQLException {

        Vendedor vendedor = new Vendedor(PuntajeAcumulado, cedula, nombre, Apellido, correo, Direccion, telefono, Encriptador.encriptar(contraseña), 3);
        return this.gerenteN.registrarVendedor(vendedor);
    }

    public Vendedor getVendedorLogeado() {
        return this.vendedorN.getVendedor();
    }

    public boolean existeItem(long codigo_p) {
        return this.vendedorN.existeItem(codigo_p);
    }

    public boolean agregarItemAlPedido(Item item) {
        return this.vendedorN.agregarItemAlPedido(item);
    }

    public boolean eliminaItemDelPedido(int codigo_item) {
        return this.vendedorN.eliminarItemDelPedido(codigo_item);
    }

    public boolean registrarPedido() throws SQLException {
        return this.vendedorN.registrarPedido();
    }
    
    public boolean solicitarPremio(long codigo_pre) throws SQLException{
        return this.vendedorN.solicitarPremio(codigo_pre);
    }

    public boolean modificarDatosVendedor(String nombre, String apellido, String correo, String direccion, String telefono) throws SQLException {

        Vendedor vendedor = this.vendedorN.getVendedor();
        vendedor.setNombre(nombre);
        vendedor.setApellido(apellido);
        vendedor.setCorreo(correo);
        vendedor.setDireccion(direccion);
        vendedor.setTelefono(telefono);

        if (this.vendedorN.actualizarDatos(vendedor)) {
            this.vendedorN.setVendedor(vendedor);
            return true;
        }

        return false;
    }

    public boolean cambiarContraseñaVendedor(String contrasena, String contrasenanueva) throws SQLException {
        return this.vendedorN.cambiarPassword(contrasena, contrasenanueva);
    }
}
