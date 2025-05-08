package sdai.com.sis.cachesdsistema;

/**
 * @date 08/05/2025
 * @author Sergio_M
 * @since VERSIONCACHEDSISTEMAENCURSO
 */
public final class CacheDSistema extends AbstractCacheDSistema {

    private CacheDSistema(Class<?> clase) {
        super(clase);
    }

    public static ICacheDSistema getInstancia(Class<?> clase) {
        return new CacheDSistema(clase);
    }

}
