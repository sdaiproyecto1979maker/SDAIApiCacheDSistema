package sdai.com.sis.cachesdsistema;

/**
 * @date 08/05/2025
 * @author Sergio_M
 * @since VERSIONCACHEDSISTEMAENCURSO
 */
public class KeyCache {

    private final Class<?> clase;
    private final Object[] argumentos;

    private KeyCache(Class<?> clase, Object[] argumentos) {
        this.clase = clase;
        this.argumentos = argumentos;
    }

    public static KeyCache getInstancia(Class<?> clase, Object... argumentos) {
        return new KeyCache(clase, argumentos);
    }

    public String getKeyCache() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clase.getName());
        if (argumentos != null && argumentos.length > 0) {
            for (Object argumento : argumentos) {
                stringBuilder.append("#");
                stringBuilder.append(argumento);
            }
        }
        return stringBuilder.toString();
    }
}
