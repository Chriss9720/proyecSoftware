package pdf;

/**
 *
 * @author Chriss Yañez
 */
public class Encabezado {

    private String titulo;
    private String version;
    private String noActa;

    public Encabezado() {
    }

    public Encabezado(String titulo, String version, String noActa) {
        this.titulo = titulo;
        this.version = version;
        this.noActa = noActa;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getVersion() {
        return version;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNoActa() {
        return noActa;
    }

    public void setNoActa(String noActa) {
        this.noActa = noActa;
    }
    
}
