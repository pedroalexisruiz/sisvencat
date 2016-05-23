
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOProducto {
    
    public int insertar(Producto pro, Campaña cam) throws Exception;

    public boolean modificar(Producto pro) throws Exception;

    public int eliminar(Producto pro, Campaña cam) throws Exception;

    public List<Producto> listar() throws Exception;
    
    public List<Producto> listarPorCampaña(Campaña cam) throws SQLException;

    public List<Producto> listarDisponibleoNo(Campaña cam, boolean disp) throws Exception;

    public Producto getProducto(Producto pro) throws Exception;
    
    public boolean existe(Producto p) throws Exception;
    
    public void closeConn() throws SQLException ;
}
