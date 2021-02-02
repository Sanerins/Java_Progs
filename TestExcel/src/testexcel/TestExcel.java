/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testexcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author student
 */
public class TestExcel {
    static String fname = "dataf_medium.xlsx";
    
    public static void main(String[] args) {
        
        
        LogAnalyzer.analyze("data");
        
        
        // boolean result = ExcelReader.read(fname);
    }
    
}
