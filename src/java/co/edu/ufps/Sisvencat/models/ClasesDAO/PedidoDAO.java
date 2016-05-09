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
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
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
    public boolean insertar(Pedido pe) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar(Pedido pe) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Pedido pe) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pedido> listarPorCampaña(Campaña cam) throws Exception {
        
        String consulta = "SELECT pedido.*,persona.*,premio.* FROM pedido INNER JOIN persona ON "
                + "pedido.Vendedor_Persona_Cedula=persona.Cedula INNER JOIN premio ON "
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
        Vendedor v = null;
        Premio pre = null;
        
        while(rs.next()){
            v = new Vendedor(rs.getInt("Puntaje_Acumulado"),rs.getString("Cedula"),
                    rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("Correo"),
                    rs.getString("Direccion"),rs.getString("Telefono"),
                    rs.getString("contrasena"),rs.getInt("TipoUsuario"));
            pre = new Premio(rs.getInt("Codigo_prem"),rs.getString("Nombre_Premio"),rs.getString("Descripcion"),rs.getInt("Punto_requerido"),rs.getInt("CantDisponible"),null);
            Calendar fechapedido = Calendar.getInstance();
            fechapedido.setTime(formater.parse(rs.getString("Fecha_pedido")));
            
            p = new Pedido(rs.getInt("Codigo_pedido"),pre,v,rs.getInt("Valor_total"),fechapedido);
            
            pedidos.add(p);
        }
        
        return pedidos;
    }

    @Override
    public Pedido getPedido(Pedido pe) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConn() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
