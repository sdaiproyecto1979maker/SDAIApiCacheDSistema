package sdai.com.sis.cachesdsistema;

import jakarta.ejb.Local;

/**
 * @date 08/05/2025
 * @author Sergio_M
 * @since VERSIONCACHEDSISTEMAENCURSO
 */
@Local
public interface IContenedorDCache {

    Object recuperarInstancia(KeyCache keyCache);

    void almacenarInstancia(KeyCache keyCache, Object instancia);

}
