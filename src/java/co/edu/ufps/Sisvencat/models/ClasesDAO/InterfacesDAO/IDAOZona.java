/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import java.sql.SQLException;
import java.util.List;
/**
 *comportamineto de un IDAOZona
 * @author oso
 */
public interface IDAOZona {
    
    public int insertar(Zona zona)throws SQLException;
    
    public boolean modificar(Zona zona)throws SQLException;
    
    public boolean cambiarEstado(Zona zona)throws SQLException;
    
    public List<Zona> listar()throws SQLException;
    
    public List<Zona> listarPorEstado(int estado)throws SQLException;
    
    public Zona getZona(Zona zona) throws SQLException;
    
    public boolean poseeGerente(int Zona_Codigo_Z)throws  SQLException;
    
    public void closeConn() throws SQLException ;
}
