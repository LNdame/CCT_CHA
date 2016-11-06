package ansteph.com.cha.model;

/**
 * Created by loicStephan on 06/11/2016.
 */

public class ScreeningQuestion {

    int scquID;
    String scqudesc;
    int scCatID;
    int qusubID;

    public ScreeningQuestion(int scquID, String scqudesc, int scCatID, int qusubID) {
        this.scquID = scquID;
        this.scqudesc = scqudesc;
        this.scCatID = scCatID;
        this.qusubID = qusubID;
    }


    public ScreeningQuestion(String scqudesc, int scCatID, int qusubID) {
        this.scqudesc = scqudesc;
        this.scCatID = scCatID;
        this.qusubID = qusubID;
    }

    public int getScquID() {
        return scquID;
    }

    public void setScquID(int scquID) {
        this.scquID = scquID;
    }

    public String getScqudesc() {
        return scqudesc;
    }

    public void setScqudesc(String scqudesc) {
        this.scqudesc = scqudesc;
    }

    public int getScCatID() {
        return scCatID;
    }

    public void setScCatID(int scCatID) {
        this.scCatID = scCatID;
    }

    public int getQusubID() {
        return qusubID;
    }

    public void setQusubID(int qusubID) {
        this.qusubID = qusubID;
    }
}
