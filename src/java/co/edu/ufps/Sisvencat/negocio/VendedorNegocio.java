/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDAO.CampañaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOVendedor;
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
public class VendedorNegocio implements Serializable, IVendedorNegocio{
    
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
        
        if(campañas.isEmpty()){
            this.vendedor = new VendedorDAO().getVendedorCompleto(cedula, 0);
        }else{
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
    public boolean agregarAlPedido(Item item) throws SQLException {
        
        if(this.vendedor.getPedido()==null){
            this.vendedor.setPedido(new Pedido());
            this.vendedor.getPedido().getItems().add(item);
        }else{
            this.vendedor.getPedido().getItems().add(item);
        }
        return true;
    }

    @Override
    public boolean enviarPedido(Pedido pedido) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
