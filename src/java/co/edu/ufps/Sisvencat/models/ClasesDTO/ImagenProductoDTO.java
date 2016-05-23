
package co.edu.ufps.Sisvencat.models.ClasesDTO;

import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class ImagenProductoDTO extends Imagen  implements Serializable{

    public ImagenProductoDTO() {
    }

    public ImagenProductoDTO(String urlImagen) {
        super(urlImagen);
    }

    public ImagenProductoDTO(long id, String urlImagen) {
        super(id, urlImagen);
    }
}