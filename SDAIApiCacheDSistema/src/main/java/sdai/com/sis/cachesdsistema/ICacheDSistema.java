package sdai.com.sis.cachesdsistema;

/**
 * @date 08/05/2025
 * @author Sergio_M
 * @since VERSIONCACHEDSISTEMAENCURSO
 */
public interface ICacheDSistema {

    Object recuperarInstancia(KeyCache keyCache);

    void almacenarInstancia(KeyCache keyCache, Object instancia);

    void eliminarInstancia(KeyCache keyCache);

    void eliminarInstancias();

    Integer getMinutosEnContenedor();

    Integer getInstanciasMaximas();

}
