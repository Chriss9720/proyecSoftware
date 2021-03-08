package pdf;

import java.util.LinkedList;

/**
 *
 * @author Chriss Yañez
 */
public class Acuerdos {

    private String nombre;
    private LinkedList<String> responsables;
    private String fechaLimite;
    private String porcentaje;

    public Acuerdos() {
    }

    public Acuerdos(String nombre, LinkedList<String> responsables, String fechaLimite, String porcentaje) {
        this.nombre = nombre;
        this.responsables = responsables;
        this.fechaLimite = fechaLimite;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public LinkedList<String> getResponsables() {
        return responsables;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setResponsables(LinkedList<String> responsables) {
        this.responsables = responsables;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

}
