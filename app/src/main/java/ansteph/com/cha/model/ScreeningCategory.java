package ansteph.com.cha.model;

/**
 * Created by loicStephan on 06/11/2016.
 */

public class ScreeningCategory {

    int scCatID;
     String       scCatname;
    String scCatdesc;


    public ScreeningCategory(int scCatID, String scCatname, String scCatdesc) {
        this.scCatID = scCatID;
        this.scCatname = scCatname;
        this.scCatdesc = scCatdesc;
    }

    public ScreeningCategory(String scCatname, String scCatdesc) {
        this.scCatname = scCatname;
        this.scCatdesc = scCatdesc;
    }

    public int getScCatID() {
        return scCatID;
    }

    public void setScCatID(int scCatID) {
        this.scCatID = scCatID;
    }

    public String getScCatname() {
        return scCatname;
    }

    public void setScCatname(String scCatname) {
        this.scCatname = scCatname;
    }

    public String getScCatdesc() {
        return scCatdesc;
    }

    public void setScCatdesc(String scCatdesc) {
        this.scCatdesc = scCatdesc;
    }
}
