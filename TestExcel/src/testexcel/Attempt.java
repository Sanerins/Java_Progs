package testexcel;

import java.util.Date;

public class Attempt {
    private int idAttempt;
    private String idStud;
    private String idTask;
    private Date start;
    private Date end;
    private float grade;

    public Attempt(int idAttempt, String idStud, String idTask, Date start, Date end, float grade) {
        this.idAttempt = idAttempt;
        this.idStud = idStud;
        this.idTask = idTask;
        this.start = start;
        this.end = end;
        this.grade = grade;
    }

    public int getIdAttempt() {
        return idAttempt;
    }

    public void setIdAttempt(int idAttempt) {
        this.idAttempt = idAttempt;
    }

    public String getIdStud() {
        return idStud;
    }

    public void setIdStud(String idStud) {
        this.idStud = idStud;
    }

    public String getIdTask() {
        return idTask;
    }

    public void setIdTask(String idTask) {
        this.idTask = idTask;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
