package com.example.infopapp.entities;

import androidx.annotation.NonNull;

import static com.example.infopapp.utils.StringConstants.STUDENT;

public class Student extends User {

    private int cohort = 0;
    private String specialization;

    // empty constructor
    public Student(){
        setUserType(STUDENT);
    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
        setUserType(STUDENT);
    }

    public Student(String firstName, String lastName, int cohort, String specialization) {
        super(firstName, lastName);
        this.cohort = cohort;
        this.specialization = specialization;
        setUserType(STUDENT);
    }


    //==========================================getters=============================================
    public int getCohort() {
        return cohort;
    }

    public String getSpecialization() {
        return specialization;
    }

    //===========================================setters============================================

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setCohort(int cohort) {
        this.cohort = cohort;
    }

    @NonNull
    @Override
    public String toString() {
        return getFirstName()+ " " + getLastName();
    }
}
