package Controller;

import Model.Actividades;
import Model.Encabezado;
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
            acta = new Object[]{null, null};
            File file = new File(path);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            NodeList list = document.getElementsByTagName("Encabezado");
            Node nodo = list.item(0);
            Element elemento = (Element) nodo;
            Encabezado enc = new Encabezado();
            enc.setAcademia(elemento.getElementsByTagName("Nombre").item(0).getTextContent());
            enc.setSemestre(elemento.getElementsByTagName("Semestre").item(0).getTextContent());
            enc.setPresidente(elemento.getElementsByTagName("Presidente").item(0).getTextContent());
            enc.setJefe(elemento.getElementsByTagName("Jefe").item(0).getTextContent());
            enc.setCoordinador(elemento.getElementsByTagName("Coordinador").item(0).getTextContent());

            list = document.getElementsByTagName("Reunion");
            LinkedList<String> fechas = new LinkedList();
            for (int i = 0; i < list.getLength(); i++) {
                fechas.add(elemento.getElementsByTagName("Reunion").item(i).getTextContent());
            }
            enc.setReuniones(fechas);

            list = document.getElementsByTagName("Actividad");
            LinkedList<Actividades> acts = new LinkedList();
            for (int i = 0; i < list.getLength(); i++) {
                elemento = (Element) list.item(i);
                acts.add(new Actividades());
                acts.getLast().setAccion(elemento.getElementsByTagName("Accion").item(0).getTextContent());
                acts.getLast().setAsignaturas(elemento.getElementsByTagName("Asginatura").item(0).getTextContent());
                acts.getLast().setFecha(elemento.getElementsByTagName("Fecha").item(0).getTextContent());
                acts.getLast().setEvidencia(elemento.getElementsByTagName("Evidencia").item(0).getTextContent());
            }
            acta[0] = enc;
            acta[1] = acts;
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            System.out.println(e);
        }
    }

    public Object[] getActa(String path) {
        LeerXML(path);
        return acta;
    }

}
