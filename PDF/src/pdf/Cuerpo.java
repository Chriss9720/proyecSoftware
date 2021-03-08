package pdf;

/**
 *
 * @author Chriss Yañez
 */
public class Cuerpo {

    private String horaInicio;
    private String dia;
    private String mes;
    private String year;
    private String academia;
    private String presidente;
    private String secretaria;
    private String orden;
    private String horaFinal;
    private String lugar;

    public Cuerpo() {
    }
    
    public Cuerpo(String horaInicio, String dia, String mes, String year,
            String academia, String presidente, String secretaria,
            String orden, String horaFinal, String lugar) {
        this.horaInicio = horaInicio;
        this.dia = dia;
        this.mes = mes;
        this.year = year;
        this.academia = academia;
        this.presidente = presidente;
        this.secretaria = secretaria;
        this.orden = orden;
        this.horaFinal = horaFinal;
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public String getYear() {
        return year;
    }

    public String getAcademia() {
        return academia;
    }

    public String getPresidente() {
        return presidente;
    }

    public String getSecretaria() {
        return secretaria;
    }

    public String getOrden() {
        return orden;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public void setSecretaria(String secretaria) {
        this.secretaria = secretaria;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

}