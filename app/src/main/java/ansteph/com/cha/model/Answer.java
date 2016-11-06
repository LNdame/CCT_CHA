package ansteph.com.cha.model;

import java.util.Date;

/**
 * Created by loicStephan on 06/11/2016.
 */

public class Answer {


    int answerID;
    String description;
    int patientID;
    int screenID;
    int scquID;
    int scCatID;
    Date ansDate;


    public Answer(int answerID, String description, int patientID, int screenID, int scquID, int scCatID, Date ansDate) {
        this.answerID = answerID;
        this.description = description;
        this.patientID = patientID;
        this.screenID = screenID;
        this.scquID = scquID;
        this.scCatID = scCatID;
        this.ansDate = ansDate;
    }


    public Answer(String description, int patientID, int screenID, int scquID, int scCatID, Date ansDate) {
        this.description = description;
        this.patientID = patientID;
        this.screenID = screenID;
        this.scquID = scquID;
        this.scCatID = scCatID;
        this.ansDate = ansDate;
    }


    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getScreenID() {
        return screenID;
    }

    public void setScreenID(int screenID) {
        this.screenID = screenID;
    }

    public int getScquID() {
        return scquID;
    }

    public void setScquID(int scquID) {
        this.scquID = scquID;
    }

    public int getScCatID() {
        return scCatID;
    }

    public void setScCatID(int scCatID) {
        this.scCatID = scCatID;
    }

    public Date getAnsDate() {
        return ansDate;
    }

    public void setAnsDate(Date ansDate) {
        this.ansDate = ansDate;
    }
}
