package Doc;

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
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Object[] getActa(String path) {
        LeerXML(path);
        return acta;
    }


}
