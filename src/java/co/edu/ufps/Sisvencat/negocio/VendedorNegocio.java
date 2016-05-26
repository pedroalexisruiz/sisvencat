/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDAO.CampañaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOVendedor;
import co.edu.ufps.Sisvencat.models.ClasesDAO.PedidoDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.PremioDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.ProductoDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.VendedorDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Item;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class VendedorNegocio implements Serializable, IVendedorNegocio {

    private Vendedor vendedor;
    private Campaña campañaActiva;

    public VendedorNegocio() {
    }

    public VendedorNegocio(String cedula) throws SQLException, ParseException {
        List<Campaña> campañas = null;

        try {
            CampañaDAO cDAO = new CampañaDAO();
            campañas = cDAO.listarCampañasPorEstado(1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        if (campañas.isEmpty()) {
            this.vendedor = new VendedorDAO().getVendedorCompleto(cedula, 0);
        } else {
            this.campañaActiva = campañas.get(0);
            this.vendedor = new VendedorDAO().getVendedorCompleto(cedula, this.campañaActiva.getCodigo_cam());
        }
    }

    @Override
    public Vendedor getVendedor() {
        return vendedor;
    }

    @Override
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public Campaña getCampañaActiva() {
        return campañaActiva;
    }

    @Override
    public Producto getProducto(long codig_p) {

        for (Producto producto : this.campañaActiva.getProductos()) {
            if (producto.getCodigo_p() == codig_p) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public boolean existeItem(long codigo_p) {
        boolean estado = false;

        if (this.vendedor.getPedido() == null) {
            estado = false;
        } else {
            for (Item item : this.vendedor.getPedido().getItems()) {
                if (item.getProducto().getCodigo_p() == codigo_p) {
                    estado = true;
                    break;
                }
            }
        }

        return estado;
    }

    @Override
    public boolean agregarItemAlPedido(Item item) {

        Pedido pedido = null;
        try {
            if (this.vendedor.getPedido() == null) {
                pedido = new Pedido(this.vendedor.getCedula(), 0, null);
                pedido.setItems(new ArrayList<Item>());
            } else {
                pedido = this.vendedor.getPedido();
            }

            pedido.agregarItem(item);
            pedido.setValorTotal(pedido.getValorTotal() + item.getValorTotal());
            this.vendedor.setPedido(pedido);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean eliminarItemDelPedido(int posicion_item) {

        Pedido pedido = this.vendedor.getPedido();
        pedido.getItems().remove(posicion_item);
        return true;
    }

    @Override
    public boolean registrarPedido() throws SQLException {
        boolean estado = new PedidoDAO().insertar(this.vendedor.getPedido(), this.campañaActiva.getCodigo_cam());

        if (estado) {
            this.vendedor.getPedido().setEstado((byte) 1);
        }
        return estado;
    }

    @Override
    public boolean actualizarDatos(Vendedor vendedor) throws SQLException {

        IDAOVendedor vDAO = new VendedorDAO();

        return vDAO.modificar(vendedor);
    }

    @Override
    public boolean cambiarPassword(String contrasena, String contrasenanueva) throws SQLException {

        if (this.vendedor.getContraseña().equals(contrasena)) {

            IDAOVendedor vDAO = new VendedorDAO();
            this.vendedor.setContraseña(contrasenanueva);

            return vDAO.cambiarContraseña(vendedor);

        } else {
            return false;
        }
    }

    @Override
    public List<Premio> listarPremios() throws SQLException {
        return new PremioDAO().listar();
    }

    @Override
    public boolean solicitarPremio(Premio premio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listarProductos() throws SQLException {
        return new ProductoDAO().listar();
    }

    @Override
    public boolean agregarAlPedido(Item item) {

        if (this.vendedor.getPedido() == null) {
            this.vendedor.setPedido(new Pedido());
        }
        this.vendedor.getPedido().getItems().add(item);
        this.vendedor.getPedido().setValorTotal(this.vendedor.getPedido().getValorTotal() + item.getValorTotal());

        return true;
    }

    @Override
    public boolean enviarPedido(Pedido pedido) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
