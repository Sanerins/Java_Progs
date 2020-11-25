/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testexcel;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 *
 * @author student
 */
public class ExcelReader {

    static boolean read(String fname) {
        long start = System.currentTimeMillis();
        Workbook workbook;
        
        try {
            workbook = WorkbookFactory.create(new File(fname));
        } catch (IOException ex) {
            System.out.println("Ошибка чтения файла");
            return false;
        } catch (EncryptedDocumentException ex) {
            System.out.println("Проблема с зашифрованным файлом");
            return false;
        }
        
        System.out.println("Количество листов : " + workbook.getNumberOfSheets());
        
        Sheet sheet = workbook.getSheetAt(0);
        
        System.out.println("Имя листа с индексом 0 : " + sheet.getSheetName());
        
        int lastRowNum = sheet.getLastRowNum();
        Row lastRow = sheet.getRow(lastRowNum);
        int lastCellNum = lastRow.getLastCellNum();
        
        int a[][] = new int[lastRowNum + 1][lastCellNum];
        
        int rowCount = 0;
        for( Row row : sheet) {
            int cellCount = 0;
            for(Cell cell : row ) {
                int x = (int)cell.getNumericCellValue();
                a[rowCount][cellCount++] = x;
            }
            rowCount++;
        }
        System.out.println("Содержимое массива а:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + ",\t");
            }
            System.out.println();
        }
        long end = System.currentTimeMillis();
        System.out.println("Время работы: " + (end-start) + " миллисекунд");
        return true;
    }
    
}
