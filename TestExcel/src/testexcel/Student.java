/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testexcel;

/**
 *
 * @author student
 */
public class Student {
    // String idStud;   идентификатор студента
    private String name;
    private String surname;
    private String group;
    private float currentTaskGrade; // баллы за текущую задачу
    private float totalGrade;

    public Student(String name, String surname, String group) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        currentTaskGrade = 0;
        totalGrade = 0;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * @return the currentTaskGrade
     */
    public float getCurrentTaskGrade() {
        return currentTaskGrade;
    }

    /**
     * @param currentTaskGrade the currentTaskGrade to set
     */
    public void setCurrentTaskGrade(float currentTaskGrade) {
        this.currentTaskGrade = currentTaskGrade;
    }

    /**
     * @return the totalGrade
     */
    public float getTotalGrade() {
        return totalGrade;
    }

    /**
     * @param totalGrade the totalGrade to set
     */
    public void setTotalGrade(float totalGrade) {
        this.totalGrade = totalGrade;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", surname=" + surname + ", group=" + group + ", totalGrade=" + totalGrade + '}';
    }

    
    
}
