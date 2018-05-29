package com.utils;

import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by N.Babenkov on 15.11.2017.
 **/
public class DocxFilesManager {
    public void createDocxFile(Map<String, String> row, File newFile) throws IOException {
        InputStream inputStream = new BufferedInputStream(DocxFilesManager.class.getClassLoader().getResourceAsStream("templet.docx"));

        try (XWPFDocument document = new XWPFDocument(inputStream)) {
            row.forEach((x,y)->replace(document, x, y));

            newFile.createNewFile();
            document.write(new BufferedOutputStream(new FileOutputStream(newFile)));
        }
    }

    private void replace(XWPFDocument document, String findText, String replacement){
        for (XWPFParagraph p : document.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null && text.contains(findText)) {
                            text = text.replace(findText, replacement);
                            r.setText(text, 0);
                    }
                }
            }
        }
        //для замены текста в таблице
        for (XWPFTable tbl : document.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null && text.contains(findText)) {
                                text = text.replace(findText, replacement);
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }
        }
    }

}
