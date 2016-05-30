/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDAO.CampañaDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.CategoriasDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.ColorDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOCampana;
import co.edu.ufps.Sisvencat.models.ClasesDAO.PremioDAO;
import co.edu.ufps.Sisvencat.models.ClasesDAO.TallasDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Color;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo;
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
        List<Campaña> campañas = new CampañaDAO().listarCampañasPorEstado(1);
        this.campañaActiva = (!campañas.isEmpty()) ? campañas.get(0) : null;
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

    @Override
    public List<Categoria> getCategorias() throws SQLException {
        return new CategoriasDAO().getCategorias();
    }

    @Override
    public ArrayList<Tipo> getTiposDePrenda() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Color> getColores() throws SQLException {
        return new ColorDAO().getColores();
    }

    @Override
    public ArrayList<String> getTallas() throws SQLException {
        return new TallasDAO().getTallas();
    }

    @Override
    public Premio getPremio(long codig_pre) throws SQLException {

        for (Premio premio : new PremioDAO().listar()) {
            if (premio.getCodigo_premio() == codig_pre) {
                return premio;
            }
        }
        return null;
    }

    @Override
    public Categoria getCategoria(int id) throws SQLException {
        return new CategoriasDAO().getCategoria(id);
    }
    
    @Override
    public Producto getProducto(long codig_p) {

        for (Producto producto : this.campañaActiva.getProductos()) {
            if (producto.getCodigo_p() == codig_p) {
                return producto;
            }
        }
        return null;
    }
}
