package Controller;

import Model.Actividades;
import Model.Encabezado;
import java.io.FileOutputStream;
import java.util.LinkedList;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Chriss Yañez
 */
public class Main {

    public static void main(String[] args) {
        //new CrearXML("document");
        Object[] obj = new LeerXML().getActa("src/Documentos/document.xml");
        Encabezado enca;
        LinkedList<Actividades> acts;
        try {
            enca = (Encabezado) obj[0];
            acts = (LinkedList<Actividades>) obj[1];
            XWPFDocument doc = new XWPFDocument(OPCPackage.open("D:\\6To\\Ing de Software\\proyecto\\codigo\\PlanTrabajo\\src\\Documentos\\F03PSA01.03.docx"));
            doc.getTables().forEach(tbl -> {
                tbl.getRows().forEach(row -> {
                    row.getTableCells().forEach(cell -> {
                        cell.getParagraphs().forEach(p -> {
                            p.getRuns().forEach(r -> {
                                String text = r.getText(0);
                                if (text != null) {
                                    switch (text) {
                                        case "${presidente}":
                                            text = text.replace("${presidente}", enca.getPresidente());
                                            break;
                                        case "";
                                        break;
                                    }
                                    r.setText(text, 0);
                                }
                            });
                        });
                    });
                });
            });
            doc.write(new FileOutputStream("D:\\6To\\Ing de Software\\proyecto\\codigo\\PlanTrabajo\\src\\Documentos\\XX.docx"));
        } catch (Exception e) {
            System.err.println("VALIO MADRES: " + e);
        }
    }

}
