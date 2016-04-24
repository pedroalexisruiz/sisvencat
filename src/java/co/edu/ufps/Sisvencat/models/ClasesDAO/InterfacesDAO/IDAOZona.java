/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import java.util.List;
/**
 *comportamineto de un IDAOZona
 * @author oso
 */
public interface IDAOZona {
    public int insertar(Zona zona);
    public int modificar(Zona zona);
    public int eliminar(Zona zona);
    public List<Zona> listar();
    public List<Zona> listar(String where);
    public boolean closeConn() throws Exception;
}
