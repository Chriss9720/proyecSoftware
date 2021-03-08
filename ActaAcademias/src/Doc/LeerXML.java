package Doc;

import Model.Acuerdo;
import Model.AcuerdosAnterioes;
import Model.Cuerpo;
import java.io.File;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Chriss Yañez
 */
public class LeerXML {

    private Object[] acta = null;

    private void LeerXML(String path) {
        try {
            acta = new Object[]{null, null, null};
            File file = new File(path);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            
            NodeList list = document.getElementsByTagName("Cuerpo");
            Node nodo = list.item(0);
            Element elemento = (Element) nodo;
            Cuerpo cuerp = new Cuerpo();
            cuerp.setNum(elemento.getElementsByTagName("num").item(0).getTextContent());
            cuerp.setHoraInicial(elemento.getElementsByTagName("horaInicio").item(0).getTextContent());
            cuerp.setDia(elemento.getElementsByTagName("dia").item(0).getTextContent());
            cuerp.setMes(elemento.getElementsByTagName("mes").item(0).getTextContent());
            cuerp.setYears(elemento.getElementsByTagName("year").item(0).getTextContent());
            cuerp.setAcademia(elemento.getElementsByTagName("academia").item(0).getTextContent());
            cuerp.setPresidente(elemento.getElementsByTagName("presidente").item(0).getTextContent());
            cuerp.setSecretario(elemento.getElementsByTagName("secretaria").item(0).getTextContent());
            cuerp.setOrden(elemento.getElementsByTagName("orden").item(0).getTextContent());
            cuerp.setHoraFinal(elemento.getElementsByTagName("horaFinal").item(0).getTextContent());
            cuerp.setLugar(elemento.getElementsByTagName("lugar").item(0).getTextContent());
            acta[0] = cuerp;
            
            list = document.getElementsByTagName("AcuerdoAnt");
            LinkedList<AcuerdosAnterioes> acn = new LinkedList();
            for (int i = 0; i < list.getLength(); i++) {
                elemento = (Element) list.item(i);
                acn.add(new AcuerdosAnterioes());
                acn.getLast().setAcuerdo(elemento.getElementsByTagName("NombreAnt").item(0).getTextContent());
                acn.getLast().setAvance(elemento.getElementsByTagName("Avance").item(0).getTextContent());
                acn.getLast().setFecha(elemento.getElementsByTagName("Fecha").item(0).getTextContent());
                acn.getLast().setResponsable(elemento.getElementsByTagName("Responsable").item(0).getTextContent());
            }
            acta[1] = acn;
            
            list = document.getElementsByTagName("Acuerdo");
            LinkedList<Acuerdo> acu = new LinkedList();
            for (int i = 0; i < list.getLength(); i++) {
                elemento = (Element) list.item(i);
                acu.add(new Acuerdo());
                acu.getLast().setAcuerdo(elemento.getElementsByTagName("Nombre").item(0).getTextContent());
                acu.getLast().setResponsable(elemento.getElementsByTagName("Responsable").item(0).getTextContent());
                acu.getLast().setFecha(elemento.getElementsByTagName("Fecha").item(0).getTextContent());
            }
            acta[2] = acu;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Object[] getActa(String path) {
        LeerXML(path);
        return acta;
    }


}
