/*
 * @author Pedro Ruiz, Manuel Osorio, Yermison Chavez, Hender Guarin
 * @version Sisvencat 1.0 * 
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public interface IDAOTipoPrenda {
    
    public ArrayList<Tipo> getTipos() throws SQLException;
    
    public void closeConn() throws SQLException;
}
