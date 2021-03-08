package Controller;

import Model.Actividades;
import Model.Encabezado;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Chriss Yañez
 */
public class Main {

    public static void main(String[] args) {
        new CrearXML("document");
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
                                String text = r.getText(0).replace("\n", "");
                                if (text != null) {
                                    switch (text) {
                                        case "${presidente}":
                                            text = text.replace("${presidente}", enca.getPresidente());
                                            break;
                                        case "${nombre}":
                                            text = text.replace("${nombre}", enca.getAcademia());
                                            break;
                                        case "sem":
                                            text = text.replace("sem", enca.getSemestre());
                                            break;
                                        case "${jefe}":
                                            text = text.replace("${jefe}", enca.getJefe());
                                            break;
                                        case "${coordinador}":
                                            text = text.replace("${coordinador}", enca.getCoordinador());
                                            break;
                                        case "${1raReunion}":
                                            text = text.replace("${1raReunion}", enca.getReuniones().get(0));
                                            break;
                                        case "${2daReunion}":
                                            text = text.replace("${2daReunion}", enca.getReuniones().get(1));
                                            break;
                                        case "${3raReunion}":
                                            text = text.replace("${3raReunion}", enca.getReuniones().get(2));
                                            break;
                                        case "${4taReunion}":
                                            text = text.replace("${4taReunion}", enca.getReuniones().get(3));
                                            break;
                                        case "${Act1}":
                                            text = text.replace("${Act1}", acts.get(0).getAccion());
                                            break;
                                        case "${Act2}":
                                            text = text.replace("${Act2}", acts.get(1).getAccion());
                                            break;
                                        case "${Act3}":
                                            text = text.replace("${Act3}", acts.get(2).getAccion());
                                            break;
                                        case "${Act4}":
                                            text = text.replace("${Act4}", acts.get(3).getAccion());
                                            break;
                                        case "${Act5}":
                                            text = text.replace("${Act5}", acts.get(4).getAccion());
                                            break;
                                        case "${Act6}":
                                            text = text.replace("${Act6}", acts.get(5).getAccion());
                                            break;
                                        case "${Act7}":
                                            text = text.replace("${Act7}", acts.get(6).getAccion());
                                            break;
                                        case "${Act8}":
                                            text = text.replace("${Act8}", acts.get(7).getAccion());
                                            break;
                                        case "${Act9}":
                                            text = text.replace("${Act9}", acts.get(8).getAccion());
                                            break;
                                        case "${Asi1}":
                                            text = text.replace("${Asi1}", acts.get(0).getAsignaturas());
                                            break;
                                        case "${Asi2}":
                                            text = text.replace("${Asi2}", acts.get(1).getAsignaturas());
                                            break;
                                        case "${Asi3}":
                                            text = text.replace("${Asi3}", acts.get(2).getAsignaturas());
                                            break;
                                        case "${Asi4}":
                                            text = text.replace("${Asi4}", acts.get(3).getAsignaturas());
                                            break;
                                        case "${Asi5}":
                                            text = text.replace("${Asi5}", acts.get(4).getAsignaturas());
                                            break;
                                        case "${Asi6}":
                                            text = text.replace("${Asi6}", acts.get(5).getAsignaturas());
                                            break;
                                        case "${Asi7}":
                                            text = text.replace("${Asi7}", acts.get(6).getAsignaturas());
                                            break;
                                        case "${Asi8}":
                                            text = text.replace("${Asi8}", acts.get(7).getAsignaturas());
                                            break;
                                        case "${Asi9}":
                                            text = text.replace("${Asi9}", acts.get(8).getAsignaturas());
                                            break;
                                        case "${Resp1}":
                                            text = text.replace("${Resp1}", acts.get(0).getResponsable());
                                            break;
                                        case "${Resp2}":
                                            text = text.replace("${Resp2}", acts.get(1).getResponsable());
                                            break;
                                        case "${Resp3}":
                                            text = text.replace("${Resp3}", acts.get(2).getResponsable());
                                            break;
                                        case "${Resp4}":
                                            text = text.replace("${Resp4}", acts.get(3).getResponsable());
                                            break;
                                        case "${Resp5}":
                                            text = text.replace("${Resp5}", acts.get(4).getResponsable());
                                            break;
                                        case "${Resp6}":
                                            text = text.replace("${Resp6}", acts.get(5).getResponsable());
                                            break;
                                        case "${Resp7}":
                                            text = text.replace("${Resp7}", acts.get(6).getResponsable());
                                            break;
                                        case "${Resp8}":
                                            text = text.replace("${Resp8}", acts.get(7).getResponsable());
                                            break;
                                        case "${Resp9}":
                                            text = text.replace("${Resp9}", acts.get(8).getResponsable());
                                            break;
                                        case "${Fec1}":
                                            text = text.replace("${Fec1}", acts.get(0).getFecha());
                                            break;
                                        case "${Fec2}":
                                            text = text.replace("${Fec2}", acts.get(1).getFecha());
                                            break;
                                        case "${Fec3}":
                                            text = text.replace("${Fec3}", acts.get(2).getFecha());
                                            break;
                                        case "${Fec4}":
                                            text = text.replace("${Fec4}", acts.get(3).getFecha());
                                            break;
                                        case "${Fec5}":
                                            text = text.replace("${Fec5}", acts.get(4).getFecha());
                                            break;
                                        case "${Fec6}":
                                            text = text.replace("${Fec6}", acts.get(5).getFecha());
                                            break;
                                        case "${Fec7}":
                                            text = text.replace("${Fec7}", acts.get(6).getFecha());
                                            break;
                                        case "${Fec8}":
                                            text = text.replace("${Fec8}", acts.get(7).getFecha());
                                            break;
                                        case "${Fec9}":
                                            text = text.replace("${Fec9}", acts.get(8).getFecha());
                                            break;
                                        case "${Ev1}":
                                            text = text.replace("${Ev1}", acts.get(0).getEvidencia());
                                            break;
                                        case "${Ev2}":
                                            text = text.replace("${Ev2}", acts.get(1).getEvidencia());
                                            break;
                                        case "${Ev3}":
                                            text = text.replace("${Ev3}", acts.get(2).getEvidencia());
                                            break;
                                        case "${Ev4}":
                                            text = text.replace("${Ev4}", acts.get(3).getEvidencia());
                                            break;
                                        case "${Ev5}":
                                            text = text.replace("${Ev5}", acts.get(4).getEvidencia());
                                            break;
                                        case "${Ev6}":
                                            text = text.replace("${Ev6}", acts.get(5).getEvidencia());
                                            break;
                                        case "${Ev7}":
                                            text = text.replace("${Ev7}", acts.get(6).getEvidencia());
                                            break;
                                        case "${Ev8}":
                                            text = text.replace("${Ev8}", acts.get(7).getEvidencia());
                                            break;
                                        case "${Ev9}":
                                            text = text.replace("${Ev9}", acts.get(8).getEvidencia());
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
        } catch (IOException | InvalidFormatException e) {
            System.err.println("VALIO MADRES: " + e);
        }
    }

}
