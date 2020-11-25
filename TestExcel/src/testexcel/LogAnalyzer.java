package testexcel;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.main.STOnOffStyleType;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class LogAnalyzer {
    static ArrayList<TaskLog> logs = new ArrayList<>();
    static ArrayList<Attempt> attempts = new ArrayList<>();

    static void analyze(String folder) {
        readXslxFiles(folder);
        System.out.println("The amount of TaskLog files: " + logs.size());
        extractAttempts();
        System.out.println("The overall amount of attempts is " + attempts.size());
    }

    private static void extractAttempts() {
        int attemptCount = 0;

        for(TaskLog log: logs){
            int lineCount = 0;
            Workbook workbook = log.getWorkbook();
            String idTask = log.getFileName();
            System.out.println("Student attempts from the file " + idTask + " are being extracted");
            Sheet sheet = workbook.getSheetAt(0);
            for(Row row : sheet){
                if ( lineCount++ == 0) continue;

                Cell emailCell = row.getCell(4);
                String email = emailCell.getStringCellValue();

                if(email.trim().isEmpty()) break;

                Cell startCell = row.getCell(6);
                String startString = startCell.getStringCellValue();
                Cell endCell = row.getCell(7);
                String endString = endCell.getStringCellValue();

                SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy hh:mm a", Locale.US);
                Date start = null;
                Date end = null;
                try {
                    start = sdf.parse(startString);
                    end = sdf.parse(endString);
                } catch (ParseException ex) {
                    System.out.println(("!!!! Transformation Error: " + startString + " or " + endString));
                    continue;
                }

                Cell gradeCell = row.getCell(9);
                float grade = 0.f;

                try {
                    grade = (float) gradeCell.getNumericCellValue();
                } catch(IllegalStateException ex){
                    grade = 0;
                }
                Attempt attempt = new Attempt(attemptCount++, email, idTask, start, end, grade);
                attempts.add(attempt);
                System.out.println("email=" + email + " start=" + startString + " end=" + endString + " grade=" + grade);

            }
        }
    }

    private static void readXslxFiles(String folder) {
        System.out.println("We are in the readXslxFiles method");

        File dir = new File(folder);

        if(!dir.exists()){
            System.out.println("Folder" + folder + "doesn't exist");
            return;
        }

        File[] listOfFiles = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".xlsx");
            }
        });

        if( listOfFiles.length == 0){
            System.out.println("There is no files *.xlsx to work with in /" + folder);
            return;
        }

        for(File f: listOfFiles) {
            System.out.println("File: " + dir + File.separator + f.getName() + "...");

            try{
                Workbook workbook = WorkbookFactory.create(f);
                logs.add(new TaskLog(f.getName(), workbook));
            } catch(IOException ex){
                System.out.println("File reading error " + f.getName());
            } catch(EncryptedDocumentException ex){
                System.out.println("Encrypted file error " + f.getName());
            }
        }

    }
}
