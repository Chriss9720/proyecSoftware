package Doc;

/*
 *
 * @author Chriss Yañez
 */
public class Main {

    public static void main(String[] args) {
        new CrearXML("document");
        Object[] obj = new LeerXML().getActa("src/Documentos/document.xml");
        
    }

}
