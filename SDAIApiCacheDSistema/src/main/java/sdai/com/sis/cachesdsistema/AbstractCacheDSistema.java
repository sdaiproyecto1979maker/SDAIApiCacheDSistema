package sdai.com.sis.cachesdsistema;

/**
 * @date 08/05/2025
 * @author Sergio_M
 * @since VERSIONCACHEDSISTEMAENCURSO
 */
public abstract class AbstractCacheDSistema implements ICacheDSistema {

    private final Class<?> clase;
    private final ContenedorDInstancias contenedorDInstancias;

    public AbstractCacheDSistema(Class<?> clase) {
        this.clase = clase;
        this.contenedorDInstancias = new ContenedorDInstancias(this);
    }

    @Override
    public Object recuperarInstancia(KeyCache keyCache) {
        String key = keyCache.getKeyCache();
        InstanciaDContenedor instanciaDContenedor = this.contenedorDInstancias.recuperarInstancia(key);
        return instanciaDContenedor == null ? null : instanciaDContenedor.getInstancia();
    }

    @Override
    public void almacenarInstancia(KeyCache keyCache, Object instancia) {
        String key = keyCache.getKeyCache();
        this.contenedorDInstancias.almacenarInstancia(key, instancia);
    }

    @Override
    public void eliminarInstancia(KeyCache keyCache) {
        String key = keyCache.getKeyCache();
        this.contenedorDInstancias.remove(key);
    }

    @Override
    public void eliminarInstancias() {
        this.contenedorDInstancias.clear();
    }

    @Override
    public Integer getMinutosEnContenedor() {
        return 9999999;
    }

    @Override
    public Integer getInstanciasMaximas() {
        return 9999999;
    }

}
