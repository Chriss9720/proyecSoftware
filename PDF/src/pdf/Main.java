/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author Chriss Yañez
 */
public class Main {

    private static int pag = 1;
    private static float cont;

    public static void main(String[] args) {
        PDDocument document;
        PDPageContentStream contentStream;
        PDFont pdfFont;
        Object[] obj = new LeerXML().getActa("src/Documentos/document.xml");
        try {
            Encabezado eca = (Encabezado) obj[0];
            document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.LETTER);
            String path = (Main.class.getResource("/Fuentes/Calibri Regular.ttf").getFile());
            path = path.substring(1, path.length()).replace("%20", " ");
            File normal = new File(path);
            path = (Main.class.getResource("/Fuentes/Calibri Bold.TTF").getFile());
            path = path.substring(1, path.length()).replace("%20", " ");
            File bold = new File(path);
            document.addPage(page);
            try {
                contentStream = new PDPageContentStream(document, page);
                float fontSize = 12;
                float leading = 1.5f * fontSize;
                PDRectangle mediabox = page.getBBox();
                float margin = 55;
                float width = mediabox.getWidth() - 2 * margin;
                float startY = mediabox.getUpperRightY();
                float limite = mediabox.getWidth() - margin;
                float size;
                String txt;
                //numpag
                txt = "1";
                pdfFont = PDTrueTypeFont.loadTTF(document, normal);
                centrar(txt, contentStream, 25, pdfFont, fontSize, leading, limite);
                //encabezado
                encabezado(contentStream, margin, startY, limite, document,
                        eca, bold, mediabox, fontSize);
                //No Acta
                startY -= 110;
                pdfFont = PDTrueTypeFont.loadTTF(document, bold);
                txt = "Acta No. " + eca.getNoActa();
                contentStream.beginText();
                contentStream.setFont(pdfFont, fontSize);
                size = fontSize * pdfFont.getStringWidth(txt) / 1000;
                contentStream.moveTextPositionByAmount(mediabox.getWidth()
                        - size - margin, startY);
                contentStream.drawString(txt);
                contentStream.endText();
                //Primer parrafo
                pdfFont = PDTrueTypeFont.loadTTF(document, normal);
                Cuerpo cue = (Cuerpo) obj[1];
                txt = "En Ciudad Obregón, Sonora, siendo las "
                        + cue.getHoraInicio() + " horas del dia "
                        + cue.getDia() + " de " + cue.getMes() + " del año "
                        + cue.getYear() + " reunidos en " + cue.getLugar()
                        + " del Instituto Tecnológico Superior de Cajeme, los "
                        + "maestros miembros de la academia de "
                        + cue.getAcademia() + ", cuya lista se anexa a la "
                        + "presente acta; se inicia la reunión, bajo la "
                        + "presidencia de " + cue.getPresidente() + ", "
                        + "auxiliado en la secretaria por "
                        + cue.getSecretaria() + " de acuerdo con el siguiente:";
                startY -= 40;
                cont = justificar(txt, fontSize, pdfFont, width, contentStream,
                        margin, startY, leading) - 15;
                //Orden del dia
                pdfFont = PDTrueTypeFont.loadTTF(document, bold);
                txt = "ORDEN DEL DÍA";
                cont = centrar(txt, contentStream, cont, pdfFont,
                        fontSize, leading, limite) - 5;
                contentStream.drawLine(margin, cont, mediabox.getWidth() - margin, cont);
                pdfFont = PDTrueTypeFont.loadTTF(document, normal);
                txt = cue.getOrden().replaceAll("\n", "");
                txt = txt.substring(0, 1500);
                float cont2 = justificar(txt, fontSize, pdfFont, width - 10, contentStream,
                        margin + 5, cont - 15, leading);
                contentStream.drawLine(margin, cont, margin, cont2);
                contentStream.drawLine(limite, cont, limite, cont2);
                contentStream.drawLine(margin, cont2, limite, cont2);
                cont = cont2 - 25;
                //Acuerdos
                txt = "Aprobado el Orden del Día, se procede a la revisión de "
                        + "acuerdos de la minuta anterior bajo el siguiente:";
                contentStream = addPage(txt, fontSize, pdfFont, width,
                        contentStream, margin, leading, page, document,
                        limite, normal, eca, bold);
                pdfFont = PDTrueTypeFont.loadTTF(document, bold);
                txt = "SEGUIMIENTO DE ACUERDOS ANTERIORES";
                cont += 20;
                centrar(txt, contentStream, cont, pdfFont, fontSize, leading, limite);
                cont -= 20;
                txt = (Main.class.getResource("/Imagenes/fondo.png").getFile());
                txt = txt.substring(1, txt.length()).replace("%20", " ");
                File imgPath = new File(txt);
                Image i = new ImageIcon(txt).getImage();
                PDImageXObject pdImage = PDImageXObject
                        .createFromFile(imgPath.getAbsolutePath(), document);
                contentStream.drawImage(pdImage, margin, cont - i.getHeight(null));
                contentStream.drawLine(margin, cont, limite, cont);
                contentStream.drawLine(margin, cont, margin, cont - i.getHeight(null));
                contentStream.drawLine(limite, cont, limite, cont - i.getHeight(null));
                contentStream.drawLine(margin, cont - i.getHeight(null), limite, cont - i.getHeight(null));
                float dif = (limite - margin) / 3;
                float[] espacios = {dif + margin,
                    (dif * 2) + margin - 5,
                    ((dif * 2) + margin) + (dif / 2) + 5};
                contentStream.drawLine(espacios[0], cont, espacios[0], cont - i.getHeight(null));
                contentStream.drawLine(espacios[1], cont, espacios[1], cont - i.getHeight(null));
                contentStream.drawLine(espacios[2], cont, espacios[2], cont - i.getHeight(null));
                cont -= 20;
                txt = "ACUERDO";
                centrar(txt, contentStream, cont, pdfFont, fontSize,
                        leading, espacios[0] + margin);
                txt = "RESPONSABLE";
                centrar(txt, contentStream, cont, pdfFont, fontSize,
                        leading, espacios[1] + espacios[0]);
                txt = "FECHA DE";
                centrar(txt, contentStream, cont + 5, pdfFont, fontSize,
                        leading, espacios[2] + espacios[1]);
                txt = "CUMPLIMIENTO";
                centrar(txt, contentStream, cont - 10, pdfFont, fontSize,
                        leading, espacios[2] + espacios[1]);
                txt = "AVANCE";
                centrar(txt, contentStream, cont, pdfFont, fontSize,
                        leading, limite + espacios[2]);
                
                contentStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.save("D:\\Codigos\\Java\\PDF\\src\\Documentos\\document.pdf");
            document.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static PDPageContentStream addPage(String txt, float fontSize,
            PDFont pdfFont, float width, PDPageContentStream contentStream,
            float margin, float leading, PDPage page, PDDocument document,
            float limite, File normal, Encabezado eca, File bold) throws IOException {
        contentStream.close();
        pag++;
        page = new PDPage(PDRectangle.LETTER);
        document.addPage(page);
        contentStream = new PDPageContentStream(document, page);

        encabezado(contentStream, margin, page.getBBox().getHeight(),
                limite, document, eca, bold, page.getBBox(), fontSize);

        cont = justificar(txt, fontSize, pdfFont, width, contentStream,
                margin, page.getBBox().getHeight() - 110, leading) - 15;
        txt = String.valueOf(pag);
        pdfFont = PDTrueTypeFont.loadTTF(document, normal);
        centrar(txt, contentStream, 25, pdfFont, fontSize, leading, limite);
        return contentStream;
    }

    private static void encabezado(PDPageContentStream contentStream,
            float margin, float startY, float limite, PDDocument document,
            Encabezado eca, File bold, PDRectangle mediabox,
            float fontSize) throws IOException {
        String txt;
        contentStream.drawLine(margin, startY - 25, limite, startY - 25);
        txt = (Main.class.getResource("/Imagenes/logo.png").getFile());
        txt = txt.substring(1, txt.length()).replace("%20", " ");
        File imgPath = new File(txt);
        Image i = new ImageIcon(txt).getImage();
        PDImageXObject pdImage = PDImageXObject
                .createFromFile(imgPath.getAbsolutePath(), document);
        contentStream.drawImage(pdImage, margin + 5,
                startY - 30 - i.getHeight(null));
        contentStream.drawLine(margin, startY - 25, margin,
                startY - 35 - i.getHeight(null));
        contentStream.drawLine(margin + i.getWidth(null) + 10,
                startY - 25, margin + i.getWidth(null) + 10,
                startY - 35 - i.getHeight(null));
        contentStream.drawLine(limite, startY - 25, limite,
                startY - 35 - i.getHeight(null));
        contentStream.drawLine(margin, startY - 35 - i.getHeight(null),
                limite, startY - 35 - i.getHeight(null));
        PDFont pdfFont = PDTrueTypeFont.loadTTF(document, bold);
        txt = eca.getTitulo();
        float x = margin + i.getWidth(null) + 10;
        x += (((mediabox.getWidth() - x) - margin) / 2);
        float size = fontSize * pdfFont.getStringWidth(txt) / 1000;
        contentStream.beginText();
        contentStream.setFont(pdfFont, fontSize);
        contentStream.moveTextPositionByAmount(x - (size / 2), startY - 50);
        contentStream.drawString(txt);
        contentStream.endText();
        contentStream.beginText();
        txt = eca.getVersion();
        contentStream.setFont(pdfFont, fontSize);
        size = fontSize * pdfFont.getStringWidth(txt) / 1000;
        contentStream.moveTextPositionByAmount(x - (size / 2), startY - 75);
        contentStream.drawString(txt);
        contentStream.endText();
    }

    private static float justificar(String parrafo, float fontSize,
            PDFont pdfFont, float width, PDPageContentStream contentStream,
            float startX, float startY, float leading) throws IOException {
        float r = startY;
        List<String> lines = new ArrayList<>();
        int lastSpace = -1;
        while (parrafo.length() > 0) {
            int spaceIndex = parrafo.indexOf(' ', lastSpace + 1);
            if (spaceIndex < 0) {
                spaceIndex = parrafo.length();
            }
            String subString = parrafo.substring(0, spaceIndex);
            float size = fontSize * pdfFont.getStringWidth(subString) / 1000;
            if (size > width) {
                if (lastSpace < 0) {
                    lastSpace = spaceIndex;
                }
                subString = parrafo.substring(0, lastSpace);
                lines.add(subString);
                parrafo = parrafo.substring(lastSpace).trim();
                lastSpace = -1;
            } else if (spaceIndex == parrafo.length()) {
                lines.add(parrafo);
                parrafo = "";
            } else {
                lastSpace = spaceIndex;
            }
        }
        contentStream.beginText();
        contentStream.setFont(pdfFont, fontSize);
        contentStream.moveTextPositionByAmount(startX, startY);
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            float charSpacing = 0;
            if (line.length() > 1) {
                float size = fontSize * pdfFont.getStringWidth(line) / 1000;
                float free = width - size;
                if (free > 0) {
                    charSpacing = free / (line.length() - 1);
                }
            }
            if (i < (lines.size() - 1)) {
                contentStream.appendRawCommands(String.format("%f Tc\n",
                        charSpacing).replace(',', '.'));
            }
            contentStream.drawString(line);
            r -= leading;
            if (i < (lines.size() - 1)) {
                contentStream.moveTextPositionByAmount(0, -leading);
            }
        }
        contentStream.endText();
        return r;
    }

    private static float centrar(String txt, PDPageContentStream contentStream,
            float cont, PDFont pdfFont, float fontSize,
            float leading, float limite) throws IOException {
        contentStream.beginText();
        contentStream.setFont(pdfFont, fontSize);
        float size = fontSize * pdfFont.getStringWidth(txt) / 1000;
        contentStream.moveTextPositionByAmount((limite / 2) - (size / 2), cont);
        contentStream.drawString(txt);
        contentStream.endText();
        return cont - leading;
    }

}
