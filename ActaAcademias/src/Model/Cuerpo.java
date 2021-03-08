package Model;

/**
 *
 * @author Chriss Yañez
 */
public class Cuerpo {
    
    private String num;
    private String horaInicial;
    private String dia;
    private String mes;
    private String years;
    private String lugar;
    private String academia;
    private String presidente;
    private String secretario;
    private String orden;
    private String horaFinal;
    
    public Cuerpo() {}

    public Cuerpo(String num, String horaInicial, String dia, String mes,
            String years, String lugar, String academia, String presidente, 
            String secretario, String orden, String horaFinal) {
        this.num = num;
        this.horaInicial = horaInicial;
        this.dia = dia;
        this.mes = mes;
        this.years = years;
        this.lugar = lugar;
        this.academia = academia;
        this.presidente = presidente;
        this.secretario = secretario;
        this.orden = orden;
        this.horaFinal = horaFinal;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getSecretario() {
        return secretario;
    }

    public void setSecretario(String secretario) {
        this.secretario = secretario;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }
    
}
