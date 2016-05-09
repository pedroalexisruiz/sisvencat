/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import java.util.List;

/**
 *
 * @author salaas402
 */
public interface IDAOPedido {
    
    
    public boolean insertar(Pedido pe) throws Exception;

    public int modificar(Pedido pe) throws Exception;

    public boolean eliminar(Pedido pe) throws Exception;

    public List<Pedido> listarPorCampaña(Campaña cam) throws Exception;

    public Pedido getPedido(Pedido pe) throws Exception;

    public void closeConn() throws Exception;
}
