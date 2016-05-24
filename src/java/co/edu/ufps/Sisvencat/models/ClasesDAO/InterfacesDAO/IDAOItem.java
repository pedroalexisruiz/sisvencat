/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Item;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public interface IDAOItem {
    
    
    public Item getItem(long codigoItem) throws SQLException;
    
    public ArrayList<Item> getItemsPorPedido(long codigoPedido) throws SQLException;
    
    public boolean agregarItem(Item item, Pedido pedido) throws SQLException;
        
    public boolean modificarItem(Item item) throws SQLException;
    
    public boolean eliminarItem(Item item) throws SQLException;
    
    public void closeConn() throws SQLException;
}
