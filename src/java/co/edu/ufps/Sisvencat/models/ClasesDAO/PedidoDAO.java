/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOPedido;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Item;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class PedidoDAO implements Serializable, IDAOPedido {

    private Conexion con;
    public static final DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    public PedidoDAO() throws SQLException {
        con = new Conexion();
    }

    @Override
    public boolean insertar(Pedido pedido, long codigo_cam) throws SQLException {

        String consultaidpedido = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = "
                + "'ufps_98' AND   TABLE_NAME   = 'pedido' LIMIT 1";
        String consultaiditem = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = "
                + "'ufps_98' AND   TABLE_NAME   = 'item' LIMIT 1";
        String consulta = "INSERT INTO item (Producto_Codigo_p,Cantidad,Valor_total,Codigo_item) VALUES(?,?,?,?)";
        String consulta2 = "INSERT INTO itemsporpedido (Codigo_pedido,Codigo_item) VALUES(?,?)";
        String consulta3 = "INSERT INTO pedido (Vendedor_Persona_Cedula, Campana_Codigo_cam,Valor_total,Fecha_pedido,Codigo_pedido) VALUES(?,?,?,CURDATE(),?)";
        PreparedStatement state = null;
        PreparedStatement state2 = null;
        PreparedStatement state3 = null;
        PreparedStatement stateiditem = null;
        PreparedStatement stateidpedido = null;
        ResultSet rs = null;
        
        try {
            if (con == null) {
                con = new Conexion();
            }
            con.getConexion().setAutoCommit(false);
            stateiditem = con.getConexion().prepareStatement(consultaiditem);
            stateidpedido = con.getConexion().prepareStatement(consultaidpedido);
            
            int idp =0, idi=0;
            rs = stateiditem.executeQuery();
            
            while(rs.next()){
                idi=rs.getInt(1);
            }
            
            rs = stateidpedido.executeQuery();
            
            while(rs.next()){
                idp=rs.getInt(1);
            }
            
            state3 = con.getConexion().prepareStatement(consulta3);
            state = con.getConexion().prepareStatement(consulta);
            state2 = con.getConexion().prepareStatement(consulta2);

            state3.setString(1, pedido.getCedulaVendedor());
            state3.setLong(2, codigo_cam);
            state3.setInt(3, pedido.getValorTotal());
            state3.setInt(4, idp);
            
            state2.setLong(1, idp);
            
            for (Item item : pedido.getItems()) {
                state.setLong(1, item.getProducto().getCodigo_p());
                state.setInt(2, item.getCantidad());
                state.setInt(3, item.getValorTotal());
                state.setInt(4, idi);
                
                state2.setLong(2, idi);
                state.addBatch();
                state2.addBatch();
                idi++;
            }
            
            state3.execute();
            state.executeBatch();
            state2.executeBatch();
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
            if (state3 != null) {
                state3.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return true;
    }

    @Override
    public boolean modificar(Pedido pe) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Pedido pe) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pedido> listarPorCampaña(Campaña cam) throws SQLException, ParseException {

        String consulta = "SELECT pedido.*,persona.*,premio.* FROM pedido INNER JOIN premio ON "
                + "pedido.Premio_Codigo_prem=premio.Codigo_prem WHERE "
                + "pedido.Campana_Codigo_cam=?";
        List<Pedido> pedidos = new ArrayList();

        if (con == null) {
            con = new Conexion();
        }

        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setLong(1, cam.getCodigo_cam());
        ResultSet rs = state.executeQuery();

        Pedido p = null;

        while (rs.next()) {
            Calendar fechapedido = Calendar.getInstance();
            fechapedido.setTime(formater.parse(rs.getString("Fecha_pedido")));

            p = new Pedido(rs.getInt("Codigo_pedido"), rs.getString("Vendedor_Persona_Cedula"), rs.getInt("Valor_total"), fechapedido);
            p.setItems(new ItemDAO().getItemsPorPedido(p.getCodigo_pedido()));
            pedidos.add(p);
        }
        this.closeConn();
        return pedidos;
    }

    @Override
    public Pedido getPedido(Pedido pe) throws SQLException, ParseException {
        String consulta = "SELECT * FROM pedido WHERE ";
        Pedido pedido = null;
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pe.getCodigo_pedido());
            rs = state.executeQuery();

            while (rs.next()) {
                Calendar fechapedido = Calendar.getInstance();
                fechapedido.setTime(formater.parse(rs.getString("Fecha_pedido")));
                pedido = new Pedido(pe.getCodigo_pedido(), rs.getString("Vendedor_Persona_Cedula"), rs.getInt("Valor_total"), fechapedido);
                pedido.setItems(new ItemDAO().getItemsPorPedido(pedido.getCodigo_pedido()));
            }
        } catch (SQLException | ParseException e) {
            throw e;
        }
        return pedido;
    }

    @Override
    public Pedido getPedidoDelVendedor(String cedula, long codigo_cam) throws SQLException, ParseException {

        String consulta = "SELECT * FROM pedido WHERE Vendedor_Persona_Cedula=? AND Campana_Codigo_cam=? LIMIT 1";
        PreparedStatement state = null;
        ResultSet rs = null;
        Pedido pedido = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setString(1, cedula);
            state.setLong(2, codigo_cam);
            rs = state.executeQuery();

            while (rs.next()) {
                Calendar fechapedido = Calendar.getInstance();
                fechapedido.setTime(formater.parse(rs.getString("Fecha_pedido")));
                pedido = new Pedido(rs.getInt("Codigo_pedido"), cedula, rs.getInt("Valor_Total"), fechapedido);
                pedido.setItems(new ItemDAO().getItemsPorPedido(pedido.getCodigo_pedido()));
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
        return pedido;
    }

    @Override
    public void closeConn() throws SQLException {
        con.close();
        con = null;
    }

}
