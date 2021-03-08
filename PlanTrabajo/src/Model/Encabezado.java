package Model;

import java.util.LinkedList;

/**
 *
 * @author Chriss Yañez
 */
public class Encabezado {
    
    private String academia;
    private String semestre;
    private String presidente;
    private LinkedList<String> reuniones;
    private String jefe;
    private String coordinador;

    public Encabezado(){}
    
    public Encabezado(String academia, String semestre, 
            String presidente, LinkedList<String> reuniones, String jefe, 
            String coordinador) {
        this.academia = academia;
        this.semestre = semestre;
        this.presidente = presidente;
        this.reuniones = reuniones;
        this.jefe = jefe;
        this.coordinador = coordinador;
    }

    public LinkedList<String> getReuniones() {
        return reuniones;
    }

    public void setReuniones(LinkedList<String> reuniones) {
        this.reuniones = reuniones;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public String getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }
    
}
