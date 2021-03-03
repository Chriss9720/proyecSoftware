package Model;

/**
 *
 * @author Chriss Yañez
 */
public class User {
    
    private String mat;
    private String file;
    private String nombre;
    private String apellidoP;
    private String apelleidoM;
    private String correo;
    private String cip;
    private String carrera;
    private String academia;
    private String puesto;

    public User(String mat, String file, String nombre, String apellidoP, String apelleidoM, 
            String correo, String cip, String carrera, String academia, String puesto) {
        this.mat = mat;
        this.file = file;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apelleidoM = apelleidoM;
        this.correo = correo;
        this.cip = cip;
        this.carrera = carrera;
        this.academia = academia;
        this.puesto = puesto;
    }
    
    public User() {}

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApelleidoM() {
        return apelleidoM;
    }

    public void setApelleidoM(String apelleidoM) {
        this.apelleidoM = apelleidoM;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    @Override
    public String toString() {
        return "matricula: " + this.mat
                +"\nfoto: " + this.file
                +"\nnombre: " + this.nombre
                +"\napellidoP: " + this.apellidoP
                +"\napellidoM: " + this.apelleidoM
                +"\nacademia: " + this.academia
                +"\ncarrera: " + this.carrera
                +"\ncip: " + this.cip
                +"\ncorreo: " + this.correo
                +"\npuesto: " + this.puesto;
    }
    
}
