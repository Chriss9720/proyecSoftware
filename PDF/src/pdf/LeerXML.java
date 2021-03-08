package pdf;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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

            NodeList list = document.getElementsByTagName("Encabezado");
            Node nodo = list.item(0);
            Element elemento = (Element) nodo;
            Encabezado enc = new Encabezado();
            enc.setTitulo(elemento.getElementsByTagName("titulo").item(0).getTextContent());
            enc.setVersion(elemento.getElementsByTagName("version").item(0).getTextContent());
            enc.setNoActa(elemento.getElementsByTagName("noActa").item(0).getTextContent());
            acta[0] = enc;

            list = document.getElementsByTagName("Cuerpo");
            nodo = list.item(0);
            elemento = (Element) nodo;
            Cuerpo cuer = new Cuerpo();
            cuer.setHoraInicio(elemento.getElementsByTagName("horaInicio").item(0).getTextContent());
            cuer.setDia(elemento.getElementsByTagName("dia").item(0).getTextContent());
            cuer.setMes(elemento.getElementsByTagName("mes").item(0).getTextContent());
            cuer.setYear(elemento.getElementsByTagName("year").item(0).getTextContent());
            cuer.setAcademia(elemento.getElementsByTagName("academia").item(0).getTextContent());
            cuer.setPresidente(elemento.getElementsByTagName("presidente").item(0).getTextContent());
            cuer.setSecretaria(elemento.getElementsByTagName("secretaria").item(0).getTextContent());
            cuer.setOrden(elemento.getElementsByTagName("orden").item(0).getTextContent());
            cuer.setHoraFinal(elemento.getElementsByTagName("horaFinal").item(0).getTextContent());
            cuer.setLugar(elemento.getElementsByTagName("lugar").item(0).getTextContent());
            acta[1] = cuer;

            list = document.getElementsByTagName("Acuerdo");
            nodo = list.item(0);
            elemento = (Element) nodo;
            list = elemento.getElementsByTagName("Acuerdos");
            LinkedList<Acuerdos> acu = new LinkedList();
            for (int i = 0; i < list.getLength(); i++) {
                acu.add(new Acuerdos());
                elemento = (Element) list.item(i);
                acu.get(i).setNombre(elemento.getElementsByTagName("nombre").item(0).getTextContent());
                acu.get(i).setFechaLimite(elemento.getElementsByTagName("fechaLimite").item(0).getTextContent());
                acu.get(i).setPorcentaje(elemento.getElementsByTagName("porcentaje").item(0).getTextContent());
                NodeList subList = elemento.getElementsByTagName("responsable");
                LinkedList<String> resp = new LinkedList();
                for (int j = 0; j < subList.getLength(); j++) {
                    resp.add(elemento.getElementsByTagName("responsable").item(j).getTextContent());
                }
                acu.get(i).setResponsables(resp);
            }
            Acuerdo acuerdo = new Acuerdo(acu);
            acta[2] = acuerdo;

        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println(e);
        }
    }

    public Object[] getActa(String path) {
        LeerXML(path);
        return acta;
    }


}
