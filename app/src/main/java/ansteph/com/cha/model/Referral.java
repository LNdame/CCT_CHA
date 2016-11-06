package ansteph.com.cha.model;

import java.util.Date;

/**
 * Created by loicStephan on 06/11/2016.
 */

public class Referral {


    int referralID;
    boolean  hasReferral;
    String referee;
    Date dateOfReferral;
    Date  dateOfFollowUp;
    int  patientID;
    int screenID;
    int scCatID;


    public Referral(int referralID, boolean hasReferral, String referee, Date dateOfReferral, Date dateOfFollowUp, int patientID, int screenID, int scCatID) {
        this.referralID = referralID;
        this.hasReferral = hasReferral;
        this.referee = referee;
        this.dateOfReferral = dateOfReferral;
        this.dateOfFollowUp = dateOfFollowUp;
        this.patientID = patientID;
        this.screenID = screenID;
        this.scCatID = scCatID;
    }


    public Referral(boolean hasReferral, String referee, Date dateOfReferral, Date dateOfFollowUp, int patientID, int screenID, int scCatID) {
        this.hasReferral = hasReferral;
        this.referee = referee;
        this.dateOfReferral = dateOfReferral;
        this.dateOfFollowUp = dateOfFollowUp;
        this.patientID = patientID;
        this.screenID = screenID;
        this.scCatID = scCatID;
    }


    public int getReferralID() {
        return referralID;
    }

    public void setReferralID(int referralID) {
        this.referralID = referralID;
    }

    public boolean isHasReferral() {
        return hasReferral;
    }

    public void setHasReferral(boolean hasReferral) {
        this.hasReferral = hasReferral;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public Date getDateOfReferral() {
        return dateOfReferral;
    }

    public void setDateOfReferral(Date dateOfReferral) {
        this.dateOfReferral = dateOfReferral;
    }

    public Date getDateOfFollowUp() {
        return dateOfFollowUp;
    }

    public void setDateOfFollowUp(Date dateOfFollowUp) {
        this.dateOfFollowUp = dateOfFollowUp;
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

    public int getScCatID() {
        return scCatID;
    }

    public void setScCatID(int scCatID) {
        this.scCatID = scCatID;
    }
}
