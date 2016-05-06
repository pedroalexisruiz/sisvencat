/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pedroruiz
 */
public interface IDAOCampana {
    
    public boolean inicarCampaña(Campaña cam) throws SQLException;
    
    public boolean finalizarCampaña(Campaña cam) throws SQLException;
    
    public List<Campaña> listarCampañas() throws Exception;
    
    public List<Campaña> listarCampañasPorEstado(int estado) throws Exception;
    
    public Campaña getCampaña(Campaña cam) throws Exception;
    
    public void closeConn() throws SQLException;
}
