package ansteph.com.cha.model;

/**
 * Created by loicStephan on 05/11/2016.
 */

public class School {
    int schoolID;
    String schoolName;
    String principalName;
    String principalContact;
    String secpersonName;
    String secpersonContact;
    String addresslineOne;
    String addresslineTwo;
    String gpsCoordinate;


    public School(int schoolID, String schoolName, String principalName,
                  String principalContact, String secpersonName, String secpersonContact, String addresslineOne, String addresslineTwo, String gpsCoordinate) {
        this.schoolID = schoolID;
        this.schoolName = schoolName;
        this.principalName = principalName;
        this.principalContact = principalContact;
        this.secpersonName = secpersonName;
        this.secpersonContact = secpersonContact;
        this.addresslineOne = addresslineOne;
        this.addresslineTwo = addresslineTwo;
        this.gpsCoordinate = gpsCoordinate;
    }


    public School(String schoolName, String principalName, String principalContact,
                  String secpersonName, String secpersonContact, String addresslineOne, String addresslineTwo, String gpsCoordinate) {
        this.schoolName = schoolName;
        this.principalName = principalName;
        this.principalContact = principalContact;
        this.secpersonName = secpersonName;
        this.secpersonContact = secpersonContact;
        this.addresslineOne = addresslineOne;
        this.addresslineTwo = addresslineTwo;
        this.gpsCoordinate = gpsCoordinate;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getPrincipalContact() {
        return principalContact;
    }

    public void setPrincipalContact(String principalContact) {
        this.principalContact = principalContact;
    }

    public String getSecpersonName() {
        return secpersonName;
    }

    public void setSecpersonName(String secpersonName) {
        this.secpersonName = secpersonName;
    }

    public String getSecpersonContact() {
        return secpersonContact;
    }

    public void setSecpersonContact(String secpersonContact) {
        this.secpersonContact = secpersonContact;
    }

    public String getAddresslineOne() {
        return addresslineOne;
    }

    public void setAddresslineOne(String addresslineOne) {
        this.addresslineOne = addresslineOne;
    }

    public String getAddresslineTwo() {
        return addresslineTwo;
    }

    public void setAddresslineTwo(String addresslineTwo) {
        this.addresslineTwo = addresslineTwo;
    }

    public String getGpsCoordinate() {
        return gpsCoordinate;
    }

    public void setGpsCoordinate(String gpsCoordinate) {
        this.gpsCoordinate = gpsCoordinate;
    }

    @Override
    public String toString() {
        return  addresslineOne + '\'' +
                ", " + addresslineTwo + '\'' +
                ", ['" + gpsCoordinate + '\'' +
                ']';
    }
}
