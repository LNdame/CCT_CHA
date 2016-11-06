package ansteph.com.cha.model;

import java.util.Date;

/**
 * Created by loicStephan on 06/11/2016.
 */

public class Assent {


    int assentID;
    int patientID;
    String patientName;
    String preexistingCondition;
    String medication;
    byte signature;
    Date assentDate;
    boolean hasParentalConsent;


    public Assent(int assentID, int patientID, String patientName, String preexistingCondition, String medication, Date assentDate, boolean hasParentalConsent) {
        this.assentID = assentID;
        this.patientID = patientID;
        this.patientName = patientName;
        this.preexistingCondition = preexistingCondition;
        this.medication = medication;
        this.assentDate = assentDate;
        this.hasParentalConsent = hasParentalConsent;
    }

    public Assent(int patientID, String patientName, String preexistingCondition, String medication, Date assentDate, boolean hasParentalConsent) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.preexistingCondition = preexistingCondition;
        this.medication = medication;
        this.assentDate = assentDate;
        this.hasParentalConsent = hasParentalConsent;
    }


    public int getAssentID() {
        return assentID;
    }

    public void setAssentID(int assentID) {
        this.assentID = assentID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPreexistingCondition() {
        return preexistingCondition;
    }

    public void setPreexistingCondition(String preexistingCondition) {
        this.preexistingCondition = preexistingCondition;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public byte getSignature() {
        return signature;
    }

    public void setSignature(byte signature) {
        this.signature = signature;
    }

    public Date getAssentDate() {
        return assentDate;
    }

    public void setAssentDate(Date assentDate) {
        this.assentDate = assentDate;
    }

    public boolean isHasParentalConsent() {
        return hasParentalConsent;
    }

    public void setHasParentalConsent(boolean hasParentalConsent) {
        this.hasParentalConsent = hasParentalConsent;
    }


}
