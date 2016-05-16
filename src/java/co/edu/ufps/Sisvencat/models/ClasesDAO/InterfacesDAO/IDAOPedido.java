/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author salaas402
 */
public interface IDAOPedido {
    
    
    public boolean insertar(Pedido pe) throws SQLException;

    public int modificar(Pedido pe) throws SQLException;

    public boolean eliminar(Pedido pe) throws SQLException;

    public List<Pedido> listarPorCampaña(Campaña cam) throws SQLException, ParseException ;

    public Pedido getPedido(Pedido pe) throws SQLException;

    public void closeConn();
}
