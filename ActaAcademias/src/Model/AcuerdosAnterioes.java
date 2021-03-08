package Model;

/**
 *
 * @author Chriss Yañez
 */
public class AcuerdosAnterioes {
    
    private String acuerdo;
    private String responsable;
    private String fecha;
    private String avance;

    public AcuerdosAnterioes() {
    }

    public AcuerdosAnterioes(String acuerdo, String responsable, String fecha, String avance) {
        this.acuerdo = acuerdo;
        this.responsable = responsable;
        this.fecha = fecha;
        this.avance = avance;
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

    public String getAvance() {
        return avance;
    }

    public void setAvance(String avance) {
        this.avance = avance;
    }
    
}
