/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOPedido;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
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
public class PedidoDAO implements Serializable, IDAOPedido{

    private Conexion con;
    public static final DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    public PedidoDAO() {
        con = new Conexion();
    }
    
    @Override
    public boolean insertar(Pedido pe) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar(Pedido pe) throws SQLException {
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
        
        if(con==null){
            con = new Conexion();
        }
        
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setInt(1, cam.getCodigo_cam());
        ResultSet rs = state.executeQuery();
        
        Pedido p = null;
        Premio pre = null;
        
        while(rs.next()){
            pre = new Premio(rs.getInt("Codigo_prem"),rs.getString("Nombre_Premio"),rs.getString("Descripcion"),rs.getInt("Punto_requerido"),rs.getInt("CantDisponible"),null);
            Calendar fechapedido = Calendar.getInstance();
            fechapedido.setTime(formater.parse(rs.getString("Fecha_pedido")));
            
            p = new Pedido(rs.getInt("Codigo_pedido"),pre, rs.getString("Vendedor_Persona_Cedula"),rs.getInt("Valor_total"),fechapedido);
            
            pedidos.add(p);
        }
        this.closeConn();
        return pedidos;
    }

    @Override
    public Pedido getPedido(Pedido pe) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConn(){
        con.close();
        con = null;
    }
    
}
