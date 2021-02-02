/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testexcel;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
class LogAnalyzer {

    static ArrayList<TaskLog> logs = new ArrayList<>();
    static ArrayList<Attempt> attempts = new ArrayList<>();
    static TreeMap<String, Student> students = new TreeMap<>();

    static void analyze(String folder) {

        readXslxFiles(folder);
        System.out.println("Количество объектов TaskLog: " + logs.size());

        extractAttempts();
        System.out.println("Количество попыток всего: " + attempts.size());

        makeStudentsList();

        // calculateRating();
    }

    private static void readXslxFiles(String folder) {
        System.out.println("Мы в методе readXslxFiles");

        File dir = new File(folder); // папка data

        if (!dir.exists()) {
            System.out.println("папка " + folder + " не существует");
            return;
        }

        File[] listOfFiles = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("xlsx");
            }
        });

        if (listOfFiles.length == 0) {
            System.out.println("Нет файлов *.xlsx для обработки в /" + folder);
            return;
        }

        for (File f : listOfFiles) {
            System.out.println("Файл: " + dir + File.separator + f.getName() + "...");

            try {
                Workbook workbook = WorkbookFactory.create(f);
                logs.add(new TaskLog(f.getName(), workbook));
            } catch (IOException ex) {
                System.out.println("Ошибка чтения файла " + f.getName());
            } catch (EncryptedDocumentException ex) {
                System.out.println("Проблема с зашифрованным файлом " + f.getName());

            }
        }
    }

    private static void extractAttempts() {
        int attemptCount = 0;

        for (TaskLog log : logs) {
            int lineCount = 0;
            Workbook workbook = log.getWorkbook();
            String idTask = log.getFileName();
            System.out.println("Извлекаются попытки из " + idTask);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (lineCount++ == 0) {
                    continue;
                }

                Cell emailCell = row.getCell(4);
                String email = emailCell.getStringCellValue();

                if (email.trim().isEmpty()) {
                    break;
                }
                int dogIndex = email.indexOf('@');
                String idStud = email.substring(0, dogIndex);

                Cell startCell = row.getCell(6);
                String startString = startCell.getStringCellValue();
                Cell endCell = row.getCell(7);
                String endString = endCell.getStringCellValue();
                //----------------------------------------------------------------------------------------          
                SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy hh:mm a", Locale.US);
                Date start = null;
                Date end = null;
                try {
                    start = sdf.parse(startString);
                    end = sdf.parse(endString);
                } catch (ParseException ex) {
                    // System.out.println("!!!! Ошибка преобразования даты и времени" + startString
                    //        + " или " + endString );
                    end = null;
                }

                //--------------------------------------------------------------            
                Cell gradeCell = row.getCell(10);
                float grade = 0.f;
                try {
                    grade = (float) gradeCell.getNumericCellValue();
                } catch (IllegalStateException e) {
                    /* ничего не делаем */ }
                // (int idAttempt, String idTask, String idStud, Date start, Date end, float grade)
                Attempt attempt = new Attempt(attemptCount++, idTask, idStud, start, end, grade);
                attempts.add(attempt);
                // System.out.println("idStud=" + idStud + " start=" + start.toString()
                //        + " end=" + end + " grade=" + grade);
            }

        }

    }

    private static void calculateRating() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void makeStudentsList() {
        for (TaskLog log : logs) {
            int studentCount = 0;
            Workbook workbook = log.getWorkbook();
            System.out.println("Извлекаются студенты из файла " + log.getFileName());
            Sheet sheet = workbook.getSheetAt(0);
            int lineCount = 0;
            for (Row row : sheet) {
                if (lineCount++ == 0) {
                    continue;
                }
                Cell surnameCell = row.getCell(0);
                String surname = surnameCell.getStringCellValue();
                Cell nameCell = row.getCell(1);
                String name = nameCell.getStringCellValue();

                Cell emailCell = row.getCell(4);
                String email = emailCell.getStringCellValue();

                if (email.trim().isEmpty()) {
                    break;
                }
                int dogIndex = email.indexOf('@');

                String idStud = email.substring(0, dogIndex);

                if (!students.containsKey(idStud)) {
                    studentCount++;
                    String group = idStud.substring(0, 7);
                    Student student = new Student(name, surname, group);
                    students.put(idStud, student);
                }
            }
            System.out.println(log.getFileName() + " : " + studentCount + " новых студентов");
        }

        Set<Map.Entry<String, Student>> set = students.entrySet();

        for (Map.Entry<String, Student> entry : set) {
            System.out.println("id:" + entry.getKey() + " student : " + entry.getValue());
        }

    }
}
