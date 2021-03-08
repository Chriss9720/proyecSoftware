package Controller;

import Model.Actividades;
import Model.Encabezado;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Chriss Yañez
 */
public class CrearXML {

    private final String nombre;

    public CrearXML(String nombre) {
        this.nombre = nombre + ".xml";
        crear();
    }

    private void crear() {
        ArrayList<String> key = new ArrayList<>();
        ArrayList value = new ArrayList();

        LinkedList<String> reuniones = new LinkedList();
        reuniones.add("01/01/21");
        reuniones.add("02/02/21");
        reuniones.add("03/03/21");
        reuniones.add("04/04/21");

        Encabezado enca = new Encabezado("ISC", "Ene-Jun 2021", "Hiram", reuniones,
                "Anabel", "Anabel");

        key.add("Encabezado");
        value.add(enca);

        LinkedList<Actividades> acts = new LinkedList();
        for (int i = 0; i < 9; i++) {
            acts.add(new Actividades("acction: " + (i + 1),
                    "asignaturas: " + (i + 1), "Responsable: " + (i + 1),
                    "Fecha: " + (i + 1), "Evidencia: " + (i + 1)));
        }

        key.add("Actividades");
        value.add(acts);

        generar(key, value);
    }

    private void generar(ArrayList<String> key, ArrayList value) {
        if (key.isEmpty() || value.isEmpty() || key.size() != value.size()) {
            System.out.println("ERROR empty ArrayList");
        } else {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            try {
                builder = factory.newDocumentBuilder();
                DOMImplementation implementation = builder.getDOMImplementation();
                Document document = implementation.createDocument(null, "PlanTrabajo", null);
                document.setXmlVersion("1.0");
                Element raiz = document.getDocumentElement();

                Element itemNode = document.createElement(key.get(0));
                Encabezado enca = (Encabezado) value.get(0);
                raiz.appendChild(getNode(document, itemNode, "Nombre", enca.getAcademia()));
                raiz.appendChild(getNode(document, itemNode, "Semestre", enca.getSemestre()));
                raiz.appendChild(getNode(document, itemNode, "Presidente", enca.getPresidente()));
                raiz.appendChild(getNode(document, itemNode, "Jefe", enca.getJefe()));
                raiz.appendChild(getNode(document, itemNode, "Coordinador", enca.getCoordinador()));

                Element subitemNode = document.createElement("Reuniones");
                LinkedList<String> reuniones = enca.getReuniones();
                for (String reunion : reuniones) {
                    itemNode.appendChild(getNode(document, subitemNode, "Reunion", reunion));
                }
                raiz.appendChild(itemNode);

                itemNode = document.createElement(key.get(1));
                LinkedList<Actividades> acts = (LinkedList<Actividades>) value.get(1);
                for (Actividades act : acts) {
                    subitemNode = document.createElement("Actividad");
                    itemNode.appendChild(getNode(document, subitemNode, "Accion", act.getAccion()));
                    itemNode.appendChild(getNode(document, subitemNode, "Asginatura", act.getAsignaturas()));
                    itemNode.appendChild(getNode(document, subitemNode, "Responsable", act.getResponsable()));
                    itemNode.appendChild(getNode(document, subitemNode, "Fecha", act.getFecha()));
                    itemNode.appendChild(getNode(document, subitemNode, "Evidencia", act.getEvidencia()));
                }
                
                raiz.appendChild(itemNode);
                
                Source source = new DOMSource(document);
                Result result = new StreamResult(new java.io.File("src/Documentos/" + nombre));
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);
            } catch (ParserConfigurationException | TransformerException ex) {
                Logger.getLogger(CrearXML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Element getNode(Document document, Element itemNode, String title, String value) {
        Element keyNode = document.createElement(title);
        Text nodeKeyValue = document.createTextNode(value);
        keyNode.appendChild(nodeKeyValue);
        itemNode.appendChild(keyNode);
        return itemNode;
    }

    private void getNodeNr(Document document, Element itemNode, String title, String value) {
        Element keyNode = document.createElement(title);
        Text nodeKeyValue = document.createTextNode(value);
        keyNode.appendChild(nodeKeyValue);
        itemNode.appendChild(keyNode);
    }

}
