package pdf;

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

        key.add("Encabezado");
        value.add(new Encabezado("ACTA DE JUNTA DE ACADEMIA", "F01PSA01.02", "3"));

        key.add("Cuerpo");
        value.add(new Cuerpo("5:00", "25", "Febrero", "2021",
                "ISC - Ingeneria en sistemas", "Hiram", "Sergio",
                "Todo lo que se vio va aquí", "20:00", "Area de sitemas"));

        LinkedList<String> responsables = new LinkedList();
        responsables.add("1");
        responsables.add("2");
        responsables.add("3");
        LinkedList<Acuerdos> acuerdos = new LinkedList();
        acuerdos.add(new Acuerdos("Nombre1", responsables, "mañana", "0%"));
        acuerdos.add(new Acuerdos("Nombre2", responsables, "viernes", "10%"));
        Acuerdo acuerdo = new Acuerdo(acuerdos);

        key.add("Acuerdo");
        value.add(acuerdo);

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
                Document document = implementation.createDocument(null, "acta", null);
                document.setXmlVersion("1.0");
                Element raiz = document.getDocumentElement();

                Element itemNode = document.createElement(key.get(0));
                Encabezado enca = (Encabezado) value.get(0);
                raiz.appendChild(getNode(document, itemNode, "noActa", enca.getNoActa()));
                raiz.appendChild(getNode(document, itemNode, "titulo", enca.getTitulo()));
                raiz.appendChild(getNode(document, itemNode, "version", enca.getVersion()));
                raiz.appendChild(itemNode);

                itemNode = document.createElement(key.get(1));
                Cuerpo cuerpo = (Cuerpo) value.get(1);
                raiz.appendChild(getNode(document, itemNode, "horaInicio", cuerpo.getHoraInicio()));
                raiz.appendChild(getNode(document, itemNode, "dia", cuerpo.getDia()));
                raiz.appendChild(getNode(document, itemNode, "mes", cuerpo.getMes()));
                raiz.appendChild(getNode(document, itemNode, "year", cuerpo.getYear()));
                raiz.appendChild(getNode(document, itemNode, "academia", cuerpo.getAcademia()));
                raiz.appendChild(getNode(document, itemNode, "presidente", cuerpo.getPresidente()));
                raiz.appendChild(getNode(document, itemNode, "secretaria", cuerpo.getSecretaria()));
                raiz.appendChild(getNode(document, itemNode, "orden", cuerpo.getOrden()));
                raiz.appendChild(getNode(document, itemNode, "horaFinal", cuerpo.getHoraFinal()));
                raiz.appendChild(getNode(document, itemNode, "lugar", cuerpo.getLugar()));

                itemNode = document.createElement(key.get(2));
                Acuerdo acuerdo = (Acuerdo) value.get(2);
                for (Acuerdos item : acuerdo.getAcuerdos()) {
                    Element subNodo = document.createElement("Acuerdos");
                    getNodeNr(document, subNodo, "nombre", item.getNombre());
                    Element terNodo = document.createElement("responsables");
                    item.getResponsables().forEach(resp -> {
                        subNodo.appendChild(getNode(document, terNodo, "responsable", resp));
                    });
                     getNodeNr(document, subNodo, "fechaLimite", item.getFechaLimite());
                     getNodeNr(document, subNodo, "porcentaje", item.getPorcentaje());
                    itemNode.appendChild(subNodo);
                }
                raiz.appendChild(itemNode);

                Source source = new DOMSource(document);
                Result result = new StreamResult(new java.io.File("src/Documentos/" + nombre)); //nombre del archivo
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);
                System.out.println("Documento xml creado");
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
