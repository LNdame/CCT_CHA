package ansteph.com.cha.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import ansteph.com.cha.model.School;

/**
 * Created by loicStephan on 06/11/2016.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static  String DATABASE_NAME = "healthscreen.db";//healthscreen.sqlite
    public static  String DB_PATH= "/data/data/ansteph.com.cha/databases/";

    private static SQLiteDatabase chadb;
    private final Context context;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }


    ///check that the database is there
    public boolean checkDatabase()
    {
        SQLiteDatabase db = null;
        try{
            String mypath = DB_PATH +DATABASE_NAME;
            db= SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e)
        {
            //too bad no db add a toast here
        }
        if(db!=null)
        {
            db.close();
        }

        return db!=null? true : false;
    }

    public void createDatabase() throws IOException
    {
        boolean dbExist = checkDatabase();

        if(!dbExist)
        {

            //empty db detected create new one and overwrite
            this.getReadableDatabase();
            try{
                copyDatabase();
            }catch(IOException e)
            {
                throw new Error ("Error copying the database");}
        }


    }

    private void copyDatabase()throws IOException
    {
        //open your local db input
        InputStream inputSt = context.getAssets().open(DATABASE_NAME);

        //path to create an empty db
        String outFileName = DB_PATH+DATABASE_NAME;

        OutputStream outputSt = new FileOutputStream(outFileName);

        //tranfers bytes  from inputfile to outputfile
        byte[] buffer = new byte[1024];
        int length;
        while((length= inputSt.read(buffer))>0)
        {
            outputSt.write(buffer,0,length);

        }
        //close the stream
        outputSt.flush();
        outputSt.close();
        inputSt.close();
    }


    public static void openDatabase () throws SQLException
    {
        //open db
        String path = DB_PATH+DATABASE_NAME;
        chadb = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);

    }

    public SQLiteDatabase getReadDatabase()
    {
        //open db
        String path = DB_PATH+DATABASE_NAME;
        chadb = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        return chadb;
    }

    @Override
    public synchronized void close()
    {
        if(chadb!=null)
            chadb.close();

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    /*********************** Escape string for single quotes (Insert,Update)************/

    private static String sqlEscapeString(String aString) {
        String aReturn = "";

        if (null != aString) {
            //aReturn = aString.replace("'", "''");
            aReturn = DatabaseUtils.sqlEscapeString(aString);
            // Remove the enclosing single quotes ...
            aReturn = aReturn.substring(1, aReturn.length() - 1);
        }

        return aReturn;
    }

    /***********************************this part concerned the entities in the database*******************************************/
    /** Table names */

    public static final String answers_Table ="answers";
    public static final String assent_Table ="assent";
    public static final String patient_Table ="patient";
    public static final String questionsubdivision_Table ="questionsubdivision";
    public static final String referral_Table ="referral";
    public static final String school_Table ="school";
    public static final String screenincategory_Table ="screenincategory";
    public static final String screening_Table ="screening";
    public static final String screeningquestion_Table ="screeningquestion";





    /********************School Table Fields ************/
    public static final String KEY_SCHOOL_ID = "schoolID";
    public static final String KEY_SCHOOL_SCHNAME = "schoolname";
    public static final String KEY_SCHOOLL_PRINNAME = "principalname";
    public static final String KEY_SCHOOL_PRINCONTACT = "principalcontact";
    public static final String KEY_SCHOOL_PERNAME = "secpersonname";
    public static final String KEY_SCHOOL_PERCONTACT = "secpersonContact";
    public static final String KEY_SCHOOL_GPS = "gpsCoordinate";
    public static final String KEY_SCHOOL_ADD1 = "addressline1";
    public static final String KEY_SCHOOL_ADD2 = "addressline2";

    // Adding new school

    public boolean addSchoolData(School sch) {

        boolean added = false;
        try {
            if(chadb==null)
            {
                openDatabase();
            }

            ContentValues cVal = new ContentValues();

            cVal.put(KEY_SCHOOL_SCHNAME, sqlEscapeString(sch.getSchoolName()));
            cVal.put(KEY_SCHOOLL_PRINNAME, sqlEscapeString(sch.getPrincipalName()));
            cVal.put(KEY_SCHOOL_PRINCONTACT, sqlEscapeString(sch.getPrincipalContact()));
            cVal.put(KEY_SCHOOL_PERNAME, sqlEscapeString(sch.getSecpersonName()));
            cVal.put(KEY_SCHOOL_PERCONTACT, sqlEscapeString(sch.getSecpersonContact()));
            cVal.put(KEY_SCHOOL_GPS, sqlEscapeString(sch.getGpsCoordinate()));
            cVal.put(KEY_SCHOOL_ADD1, sqlEscapeString(sch.getAddresslineOne()));
            cVal.put(KEY_SCHOOL_ADD2, sqlEscapeString(sch.getAddresslineTwo()));

            chadb.insert(school_Table, null, cVal);
            added = true;
        } catch (Exception e) {
            // TODO: handle exception
            added= false;
        }

        return added;
        // Closing database connection
    }

    public boolean UpdateSchoolData(School sch) {

        boolean added = false;
        try {
            if(chadb==null)
            {
                openDatabase();
            }

            ContentValues cVal = new ContentValues();

            cVal.put(KEY_SCHOOL_SCHNAME, sqlEscapeString(sch.getSchoolName()));
            cVal.put(KEY_SCHOOLL_PRINNAME, sqlEscapeString(sch.getPrincipalName()));
            cVal.put(KEY_SCHOOL_PRINCONTACT, sqlEscapeString(sch.getPrincipalContact()));
            cVal.put(KEY_SCHOOL_PERNAME, sqlEscapeString(sch.getSecpersonName()));
            cVal.put(KEY_SCHOOL_PERCONTACT, sqlEscapeString(sch.getSecpersonContact()));
            cVal.put(KEY_SCHOOL_GPS, sqlEscapeString(sch.getGpsCoordinate()));
            cVal.put(KEY_SCHOOL_ADD1, sqlEscapeString(sch.getAddresslineOne()));
            cVal.put(KEY_SCHOOL_ADD2, sqlEscapeString(sch.getAddresslineTwo()));

            chadb.update(school_Table,   cVal, KEY_SCHOOL_ID+" = ? ", new String[]{ String.valueOf(sch.getSchoolID()) });
            added = true;
        } catch (Exception e) {
            // TODO: handle exception
            added= false;
        }

        return added;
        // Closing database connection
    }

    public List<School> getAllSchoolData() {
        List<School> List = new ArrayList<School>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + school_Table;

        try {
            if(chadb==null)
            {
                openDatabase();
            }
            Cursor cursor = chadb.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    School sch = new School(
                          Integer.parseInt(cursor.getString(0)),
                            (cursor.getString(1)),
                            (cursor.getString(2)),
                            (cursor.getString(3)),
                            (cursor.getString(4)) ,
                            (cursor.getString(5)) ,
                            (cursor.getString(6)) ,
                            (cursor.getString(7)) ,
                            (cursor.getString(8))
                    );

                    // Adding contact to list
                    List.add(sch);
                } while (cursor.moveToNext());
            }
        } catch (SQLException se) {
            // TODO: handle exception
            se.printStackTrace();;
        }
        return List;
    }




}
