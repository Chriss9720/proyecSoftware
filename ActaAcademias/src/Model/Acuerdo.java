package Model;

/**
 *
 * @author Chriss Yañez
 */
public class Acuerdo {
    
    private String acuerdo;
    private String responsable;
    private String fecha;

    public Acuerdo() {
    }

    public Acuerdo(String acuerdo, String responsable, String fecha) {
        this.acuerdo = acuerdo;
        this.responsable = responsable;
        this.fecha = fecha;
    }

    public String getAcuerdo() {
        return acuerdo;
    }

    public void setAcuerdo(String acuerdo) {
        this.acuerdo = acuerdo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
