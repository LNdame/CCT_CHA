package ansteph.com.cha.model;

import java.util.Date;

/**
 * Created by loicStephan on 06/11/2016.
 */

public class Screening {

    int screenID;
    int patientID;
    Date ScreenDate;

    public Screening(int screenID, int patientID, Date screenDate) {
        this.screenID = screenID;
        this.patientID = patientID;
        ScreenDate = screenDate;
    }


    public Screening(int patientID, Date screenDate) {
        this.patientID = patientID;
        ScreenDate = screenDate;
    }


    public int getScreenID() {
        return screenID;
    }

    public void setScreenID(int screenID) {
        this.screenID = screenID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public Date getScreenDate() {
        return ScreenDate;
    }

    public void setScreenDate(Date screenDate) {
        ScreenDate = screenDate;
    }
}
