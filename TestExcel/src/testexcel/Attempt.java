/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testexcel;

import java.util.Date;

/**
 *
 * @author student
 */
public class Attempt {
    private int idAttempt;
    private String idStud;
    private String idTask;
    private Date start;
    private Date end;
    private float grade;

    public Attempt(int idAttempt, String idTask, String idStud, Date start, Date end, float grade) {
        this.idAttempt = idAttempt;
        this.idStud = idStud;
        this.idTask = idTask;
        this.start = start;
        this.end = end;
        this.grade = grade;
    }

    /**
     * @return the idAttempt
     */
    public int getIdAttempt() {
        return idAttempt;
    }

    /**
     * @param idAttempt the idAttempt to set
     */
    public void setIdAttempt(int idAttempt) {
        this.idAttempt = idAttempt;
    }

    /**
     * @return the idStud
     */
    public String getIdStud() {
        return idStud;
    }

    /**
     * @param idStud the idStud to set
     */
    public void setIdStud(String idStud) {
        this.idStud = idStud;
    }

    /**
     * @return the idTask
     */
    public String getIdTask() {
        return idTask;
    }

    /**
     * @param idTask the idTask to set
     */
    public void setIdTask(String idTask) {
        this.idTask = idTask;
    }

    /**
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public Date getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * @return the grade
     */
    public float getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(float grade) {
        this.grade = grade;
    }
    
}
