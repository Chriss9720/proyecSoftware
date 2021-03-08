package Doc;

import Model.Cuerpo;
import java.io.FileOutputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/*
 *
 * @author Chriss Yañez
 */
public class Main {

    public static void main(String[] args) {
        new CrearXML("document");
        Object[] obj = new LeerXML().getActa("src/Documentos/document.xml");
        try {
            Cuerpo cue = (Cuerpo) obj[0];
            
            XWPFDocument doc = new XWPFDocument(OPCPackage.open("D:\\6To\\Ing de Software\\proyecto\\codigo\\ActaAcademias\\src\\Documentos\\F01PSA01.02.docx"));
            //para parrafos
            doc.getParagraphs().stream().map(p -> p.getRuns()).filter(runs
                    -> (runs != null)).forEachOrdered(runs -> {
                runs.forEach(r -> {
                    String text = r.getText(0).replaceAll("\n", "");
                    if (text != null) {
                        if (text.contains("${num}")) {
                            text = text.replace("${num}", cue.getNum());
                        } else if (text.contains("${iH}")) {
                            text = text.replace("${iH}", cue.getHoraInicial());
                        } else if (text.contains("{d}")) {
                            text = text.replace("${d}", cue.getDia());
                        } else if (text.contains("${m}")) {
                            text = text.replace("${m}", cue.getMes());
                        } else if (text.contains("${y}")) {
                            text = text.replace("${y}", cue.getYears());
                        } else if (text.contains("${l}")) {
                            text = text.replace("${l}", cue.getLugar());
                        } else if (text.contains("${ac}")) {
                            text = text.replace("${ac}", cue.getAcademia());
                        } else if (text.contains("${pr}")) {
                            text = text.replace("${pr}", cue.getPresidente());
                        } else if (text.contains("${se}")) {
                            text = text.replace("${se}", cue.getSecretario());
                        } else if (text.contains("${fH}")) {
                            text = text.replace("${fH}", cue.getHoraFinal());
                        } else {
                            text = text.replace("${edito}", "editado");
                        }
                        r.setText(text, 0);
                    }
                });
            });
            //Para tablas
            doc.getTables().forEach(tbl -> {
                tbl.getRows().forEach(row -> {
                    row.getTableCells().forEach(cell -> {
                        cell.getParagraphs().forEach(p -> {
                            p.getRuns().forEach(r -> {
                                String txt = r.getText(0);
                                if (txt != null) {
                                    if (txt.contains("${orden}")) {
                                        txt = txt.replace("${orden}", cue.getOrden());
                                    }
                                    r.setText(txt, 0);
                                }
                            });
                        });
                    });
                });
            });
            doc.write(new FileOutputStream("D:\\6To\\Ing de Software\\proyecto\\codigo\\ActaAcademias\\src\\Documentos\\F01PSA01.XX.docx"));
        } catch (Exception e) {
            System.err.println("error en el main: " + e);
        }

    }

}
