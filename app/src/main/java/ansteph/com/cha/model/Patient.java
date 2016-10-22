package ansteph.com.cha.model;

import java.util.Date;

/**
 * Created by loicStephan on 22/10/2016.
 */

public class Patient {

    private String id;
    private String firstname;
    private String surname;
    private String grade;
    private String gender;
    private boolean hasRoadtoHealth;
    private Date dob;

    private String nextofKinName;
    private String nextofKinContact;

    private String addline1 ;
    private String addline2;
    private String school;


    //Created for testing purpose
    public Patient(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public Patient(String firstname, String surname, String grade, String gender, boolean hasRoadtoHealth,
                   Date dob, String nextofKinName, String nextofKinContact, String addline1, String addline2) {
        this.firstname = firstname;
        this.surname = surname;
        this.grade = grade;
        this.gender = gender;
        this.hasRoadtoHealth = hasRoadtoHealth;
        this.dob = dob;
        this.nextofKinName = nextofKinName;
        this.nextofKinContact = nextofKinContact;
        this.addline1 = addline1;
        this.addline2 = addline2;
    }

    public Patient(String id, String firstname, String surname, String grade, String gender, boolean hasRoadtoHealth,
                   Date dob, String nextofKinName, String nextofKinContact, String addline1, String addline2, String school) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.grade = grade;
        this.gender = gender;
        this.hasRoadtoHealth = hasRoadtoHealth;
        this.dob = dob;
        this.nextofKinName = nextofKinName;
        this.nextofKinContact = nextofKinContact;
        this.addline1 = addline1;
        this.addline2 = addline2;
        this.school = school;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isHasRoadtoHealth() {
        return hasRoadtoHealth;
    }

    public void setHasRoadtoHealth(boolean hasRoadtoHealth) {
        this.hasRoadtoHealth = hasRoadtoHealth;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNextofKinName() {
        return nextofKinName;
    }

    public void setNextofKinName(String nextofKinName) {
        this.nextofKinName = nextofKinName;
    }

    public String getNextofKinContact() {
        return nextofKinContact;
    }

    public void setNextofKinContact(String nextofKinContact) {
        this.nextofKinContact = nextofKinContact;
    }

    public String getAddline1() {
        return addline1;
    }

    public void setAddline1(String addline1) {
        this.addline1 = addline1;
    }

    public String getAddline2() {
        return addline2;
    }

    public void setAddline2(String addline2) {
        this.addline2 = addline2;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
