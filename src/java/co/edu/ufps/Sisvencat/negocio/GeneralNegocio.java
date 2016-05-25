/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDAO.CampañaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOCampana;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class GeneralNegocio implements Serializable, IGeneralNegocio {

    private Campaña campañaActiva;

    public GeneralNegocio() throws SQLException, ParseException {
        this.campañaActiva = new CampañaDAO().listarCampañasPorEstado(1).get(0);
    }

    @Override
    public boolean login(Persona p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Campaña getCampañaActiva() {
        return this.campañaActiva;
    }

    @Override
    public List<Campaña> getListadoDeCampañas() throws SQLException, ParseException {

        IDAOCampana cDAO = new CampañaDAO();

        return cDAO.listarCampañas();
    }

    @Override
    public List<Campaña> getListadoDeCampañasPorEstado(int est) throws SQLException, ParseException {

        IDAOCampana cDAO = new CampañaDAO();

        return cDAO.listarCampañasPorEstado(est);
    }

    @Override
    public List<Producto> getProductosCampañaPorCategoria(int cat) throws SQLException {

        List<Producto> productosencampaña = this.campañaActiva.getProductos();
        List<Producto> productosPorCategoria = new ArrayList();

        for (Producto producto : productosencampaña) {

            if (producto.getCategoria().getId() == cat) {
                productosPorCategoria.add(producto);
            }
        }

        return productosPorCategoria;
    }

    @Override
    public List<Producto> getProductosCampañaPorCategoriaYTipoPrenda(int cat, int tipo) throws SQLException {

        List<Producto> productosencampaña = this.campañaActiva.getProductos();
        List<Producto> productosPorCategoriaYTipo = new ArrayList();

        for (Producto producto : productosencampaña) {

            if (producto.getCategoria().getId() == cat && producto.getTipoProducto().getId() == tipo) {
                productosPorCategoriaYTipo.add(producto);
            }
        }

        return productosPorCategoriaYTipo;

    }
}