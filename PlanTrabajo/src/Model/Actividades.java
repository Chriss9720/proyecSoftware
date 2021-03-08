package Model;

/**
 *
 * @author Chriss Yañez
 */
public class Actividades {
    
    private String accion;
    private String asignaturas;
    private String responsable;
    private String fecha;
    private String evidencia;

    public Actividades() {}
    
    public Actividades(String accion, String asignaturas, String responsable, 
            String fecha, String evidencia) {
        this.accion = accion;
        this.asignaturas = asignaturas;
        this.responsable = responsable;
        this.fecha = fecha;
        this.evidencia = evidencia;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(String asignaturas) {
        this.asignaturas = asignaturas;
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

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }
    
}
