package ansteph.com.cha.model;

/**
 * Created by loicStephan on 06/11/2016.
 */

public class QuestionSubdivision {

    int qusubID, scCatID;
    String qusubName;
    String qusubDesc;


    public QuestionSubdivision(int qusubID, int scCatID, String qusubName, String qusubDesc) {
        this.qusubID = qusubID;
        this.scCatID = scCatID;
        this.qusubName = qusubName;
        this.qusubDesc = qusubDesc;
    }


    public QuestionSubdivision(int scCatID, String qusubName, String qusubDesc) {
        this.scCatID = scCatID;
        this.qusubName = qusubName;
        this.qusubDesc = qusubDesc;
    }

    public QuestionSubdivision(String qusubName, String qusubDesc) {
        this.qusubName = qusubName;
        this.qusubDesc = qusubDesc;
    }

    public int getQusubID() {
        return qusubID;
    }

    public void setQusubID(int qusubID) {
        this.qusubID = qusubID;
    }

    public int getScCatID() {
        return scCatID;
    }

    public void setScCatID(int scCatID) {
        this.scCatID = scCatID;
    }

    public String getQusubName() {
        return qusubName;
    }

    public void setQusubName(String qusubName) {
        this.qusubName = qusubName;
    }

    public String getQusubDesc() {
        return qusubDesc;
    }

    public void setQusubDesc(String qusubDesc) {
        this.qusubDesc = qusubDesc;
    }
}
