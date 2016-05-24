/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOItem;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Item;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class ItemDAO implements Serializable, IDAOItem {

    private Conexion con;

    public ItemDAO() throws SQLException {
        con = new Conexion();
    }

    @Override
    public Item getItem(long codigoItem) throws SQLException {

        String consulta = "SELECT * FROM item WHERE Codigo_item=? LIMIT 1";
        PreparedStatement state = null;
        ResultSet rs = null;
        Item item = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, codigoItem);
            rs = state.executeQuery();
            Producto p = null;

            while (rs.next()) {
                p = new Producto();
                p.setCodigo_p(rs.getLong("Codigo_item"));
                p = new ProductoDAO().getProducto(p);
                item = new Item(codigoItem, p, rs.getInt("Cantidad"), rs.getInt("Valor_total"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return item;
    }

    @Override
    public ArrayList<Item> getItemsPorPedido(long codigoPedido) throws SQLException {

        String consulta = "SELECT item.* FROM item INNER JOIN itemsporpedido ON "
                + "item.Codigo_item=itemsporpedido.Codigo_item WHERE itemsporpedido.Codigo_pedido=?";
        PreparedStatement state = null;
        ArrayList<Item> items = new ArrayList();
        ResultSet rs = null;
        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, codigoPedido);
            rs = state.executeQuery();
            Producto p = null;
            Item item = null;

            while (rs.next()) {
                p = new Producto();
                p.setCodigo_p(rs.getLong("Producto_Codigo_p"));
                p = new ProductoDAO().getProducto(p);
                item = new Item(rs.getLong("Codigo_item"), p, rs.getInt("Cantidad"), rs.getInt("Valor_total"));
                items.add(item);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return items;
    }

    @Override
    public boolean agregarItem(Item item, Pedido pedido) throws SQLException {

        String consulta = "INSERT INTO item (Producto_Codigo_p,Cantidad,Valor_total) VALUES(?,?,?)";
        String consulta2 = "INSERT INTO itemsporpedido (Codigo_pedido,Codigo_item) VALUES(?,?)";
        PreparedStatement state = null;
        PreparedStatement state2 = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            con.getConexion().setAutoCommit(false);
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, item.getCodigo_item());
            state.setInt(2, item.getCantidad());
            state.setInt(3, item.getValorTotal());
            state2 = con.getConexion().prepareStatement(consulta2);
            state2.setLong(1, pedido.getCodigo_pedido());
            state2.setLong(2, item.getCodigo_item());

            state.execute();
            state2.execute();
            con.getConexion().commit();
        } catch (SQLException e) {

            if (con != null) {
                try {
                    System.out.println("Error en la transacción. Revirtiendo Cambios");
                    con.getConexion().rollback();
                } catch (SQLException ex) {
                    throw ex;
                }
            }
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (state2 != null) {
                state2.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return true;
    }

    @Override
    public boolean modificarItem(Item item) throws SQLException {

        String consulta = "UPDATE item SET Cantidad=?,Valor_total=? WHERE Codigo_item=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setInt(1, item.getCantidad());
            state.setInt(2, item.getValorTotal());
            state.setLong(3, item.getCodigo_item());
            state.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }
        return true;
    }

    @Override
    public boolean eliminarItem(Item item) throws SQLException {
        String consulta = "DELETE FROM item WHERE Codigo_item=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, item.getCodigo_item());
            state.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }
        return true;
    }

    @Override
    public void closeConn() throws SQLException {
        con.close();
        con = null;
    }
}
