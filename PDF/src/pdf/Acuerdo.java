package pdf;

import java.util.LinkedList;

/**
 *
 * @author Chriss Yañez
 */
public class Acuerdo {

    private LinkedList<Acuerdos> acuerdos;

    public Acuerdo() {
    }

    public Acuerdo(LinkedList<Acuerdos> acuerdos) {
        this.acuerdos = acuerdos;
    }

    public LinkedList<Acuerdos> getAcuerdos() {
        return acuerdos;
    }

}
