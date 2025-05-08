package sdai.com.sis.cachesdsistema;

import sdai.com.sis.utilidades.Hora;

/**
 * @date 08/05/2025
 * @author Sergio_M
 * @since VERSIONCACHEDSISTEMAENCURSO
 */
public final class InstanciaDContenedor {

    private final String keyCache;
    private final Object instancia;
    private final Hora horaDCreacion;

    InstanciaDContenedor(String keyCache, Object instancia) {
        this.keyCache = keyCache;
        this.instancia = instancia;
        this.horaDCreacion = Hora.getHoraDSistema();
    }

    Boolean isInstanciaCaducada(Integer minutosEnContenedor) {
        Hora horaDSistema = Hora.getHoraDSistema();
        Integer minutosTranscurridos = this.horaDCreacion.getMinutosTranscurridos(horaDSistema);
        return minutosTranscurridos >= minutosEnContenedor;
    }

    public String getKeyCache() {
        return keyCache;
    }

    public Object getInstancia() {
        return instancia;
    }

    public Hora getHoraDCreacion() {
        return horaDCreacion;
    }

}
