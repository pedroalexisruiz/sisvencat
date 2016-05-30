/*
 * @author Pedro Ruiz, Manuel Osorio, Yermison Chavez, Hender Guarin
 * @version Sisvencat 1.0 * 
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import java.sql.SQLException;
import java.util.List;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria;
/**
 *
 * @author Administrator
 */
public interface IDAOCategorias {
    
    public List<Categoria> getCategorias() throws SQLException;
    
    public Categoria getCategoria(int id) throws SQLException;
    
    public void closeConn() throws SQLException;
}
