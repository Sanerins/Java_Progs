/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testexcel;

import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author student
 */
public class TaskLog {
    private String fileName;   // имя файла электронной таблицы
    private Workbook workbook; // объект - электронная таблица
    int maxTime ;    // максимальной время на задачу в секундах

    public TaskLog(String fileName, Workbook workbook) {
        this.fileName = fileName;
        this.workbook = workbook;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }
    
}
