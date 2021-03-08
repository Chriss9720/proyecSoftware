package Doc;

import Model.Cuerpo;
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

        key.add("Cuerpo");
        value.add(new Cuerpo("XXXX", "5:00", "08", "03", "21", "Casa",
                "ISC", "Anabel", "Sergio", "Todo lo que se vio va aqui", "22"));
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
                Cuerpo cuerpo = (Cuerpo) value.get(0);
                raiz.appendChild(getNode(document, itemNode, "num", cuerpo.getNum()));
                raiz.appendChild(getNode(document, itemNode, "horaInicio", cuerpo.getHoraInicial()));
                raiz.appendChild(getNode(document, itemNode, "dia", cuerpo.getDia()));
                raiz.appendChild(getNode(document, itemNode, "mes", cuerpo.getMes()));
                raiz.appendChild(getNode(document, itemNode, "year", cuerpo.getYears()));
                raiz.appendChild(getNode(document, itemNode, "academia", cuerpo.getAcademia()));
                raiz.appendChild(getNode(document, itemNode, "presidente", cuerpo.getPresidente()));
                raiz.appendChild(getNode(document, itemNode, "secretaria", cuerpo.getSecretario()));
                raiz.appendChild(getNode(document, itemNode, "orden", cuerpo.getOrden()));
                raiz.appendChild(getNode(document, itemNode, "horaFinal", cuerpo.getHoraFinal()));
                raiz.appendChild(getNode(document, itemNode, "lugar", cuerpo.getLugar()));

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
