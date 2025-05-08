package sdai.com.sis.cachesdsistema;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @date 08/05/2025
 * @author Sergio_M
 * @since VERSIONCACHEDSISTEMAENCURSO
 */
public final class ContenedorDInstancias extends ConcurrentHashMap<String, InstanciaDContenedor> {

    private final ICacheDSistema cacheDSistema;

    ContenedorDInstancias(ICacheDSistema cacheDSistema) {
        this.cacheDSistema = cacheDSistema;
    }

    InstanciaDContenedor recuperarInstancia(String keyCache) {
        if (!super.containsKey(keyCache)) {
            return null;
        }
        Integer minutosEnContenedor = this.cacheDSistema.getMinutosEnContenedor();
        InstanciaDContenedor instanciaDContenedor = super.get(keyCache);
        if (instanciaDContenedor.isInstanciaCaducada(minutosEnContenedor)) {
            super.remove(keyCache);
            return null;
        }
        return instanciaDContenedor;
    }

    void almacenarInstancia(String keyCache, Object instancia) {
        Integer numeroDInstancias = super.size();
        Integer instanciasMaximas = this.cacheDSistema.getInstanciasMaximas();
        if (numeroDInstancias >= instanciasMaximas) {
            Integer minutosEnContenedor = this.cacheDSistema.getMinutosEnContenedor();
            InstanciaDContenedor[] instanciasDContenedor = super.values().toArray(new InstanciaDContenedor[0]);
            for (InstanciaDContenedor instanciaDContenedor : instanciasDContenedor) {
                if (instanciaDContenedor.isInstanciaCaducada(minutosEnContenedor)) {
                    String key = instanciaDContenedor.getKeyCache();
                    super.remove(key);
                }
            }
        }
        InstanciaDContenedor instanciaDContenedor = new InstanciaDContenedor(keyCache, instancia);
        super.put(keyCache, instanciaDContenedor);
    }

}
