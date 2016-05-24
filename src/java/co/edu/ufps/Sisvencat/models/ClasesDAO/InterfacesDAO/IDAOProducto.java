
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOProducto {
    
    public boolean insertar(Producto pro, Campaña cam) throws SQLException;
    
    public boolean insertarVarios(ArrayList<Producto> productos, Campaña cam) throws SQLException;
    
    public boolean insertarTallas(Producto pro) throws SQLException;
    
    public boolean desasignarTallas(long codigo_p) throws SQLException;
    
    public boolean insertarColores(Producto pro) throws SQLException;
    
    public boolean desasignarColores(long codigo_p) throws SQLException;

    public boolean modificar(Producto pro) throws SQLException;
            
    public boolean eliminar(Producto pro, Campaña cam) throws SQLException;

    public ArrayList<Producto> listar() throws SQLException;
    
    public List<Producto> listarPorCampaña(Campaña cam) throws SQLException;

    public List<Producto> listarDisponibleoNo(Campaña cam, boolean disp) throws SQLException;

    public Producto getProducto(Producto pro) throws SQLException;
    
    public boolean existe(Producto p) throws SQLException;
    
    public void closeConn() throws SQLException ;
}
