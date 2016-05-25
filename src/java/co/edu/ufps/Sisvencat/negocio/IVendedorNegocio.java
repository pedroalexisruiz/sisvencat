/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Item;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IVendedorNegocio {
    
    public Vendedor getVendedor();

    public void setVendedor(Vendedor vendedor);
    
    public Campaña getCampañaActiva();
    
    public boolean actualizarDatos(Vendedor vendedor)throws SQLException;
    
    public boolean cambiarPassword(String contrasena, String contrasenanueva) throws SQLException;
    
    public List<Premio> listarPremios() throws SQLException;
    
    public boolean solicitarPremio(Premio premio) throws SQLException;

    public List<Producto> listarProductos() throws SQLException;
    
    public boolean agregarAlPedido(Item item) throws SQLException;
    
    public boolean enviarPedido(Pedido pedido) throws SQLException;
}