package testexcel;
import org.apache.poi.ss.usermodel.Workbook;
public class TaskLog {
    private String fileName;
    private Workbook workbook;

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
