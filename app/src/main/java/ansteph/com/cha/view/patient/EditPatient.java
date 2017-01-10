package ansteph.com.cha.view.patient;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import ansteph.com.cha.R;
import ansteph.com.cha.helper.DbHelper;
import ansteph.com.cha.model.Patient;
import ansteph.com.cha.model.School;

public class EditPatient extends AppCompatActivity {


    //UI reference
    EditText edtName,edtSurname,edtGrade,edtEmisNum, edtNokName,edtNokContact,edtNokAddrLine1,edtNokAddrLine2;

    TextView txtDOB;
    RadioButton radYES,radNO;
    Spinner spinGender, spinSchool;
    ImageButton imgCalendar;

    Button btnAddPatient;
    public DbHelper databhelper ;

    ArrayList<School> schoolList = new ArrayList<School>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_patient);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            databhelper= new DbHelper(getApplicationContext());
            databhelper.createDatabase();
        } catch (Exception e) {

            e.printStackTrace();
        }


        setupLayout();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    void setupLayout()
    {
        edtName = (EditText) findViewById(R.id.edtfirstname);
        edtSurname = (EditText) findViewById(R.id.edtsurname);
        edtGrade = (EditText) findViewById(R.id.edtgrade);
        edtEmisNum = (EditText) findViewById(R.id.edtemisnum);
        edtNokName = (EditText) findViewById(R.id.edtnokname);
        edtNokContact = (EditText) findViewById(R.id.edtnokcontact);
        edtNokAddrLine1 = (EditText) findViewById(R.id.edtnokaddline1);
        edtNokAddrLine2 = (EditText) findViewById(R.id.edtnokaddline2);

         txtDOB= (TextView) findViewById(R.id.txtdob);;
        radYES = (RadioButton) findViewById(R.id.radYes);
        radNO = (RadioButton) findViewById(R.id.radNo);
        spinGender = (Spinner) findViewById(R.id.spingender);
        spinSchool= (Spinner) findViewById(R.id.spinschool);
        imgCalendar= (ImageButton) findViewById(R.id.imgcalendar);

         btnAddPatient = (Button) findViewById(R.id.btnaddPatient);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinGender.setAdapter(adapter);

        schoolList =(ArrayList<School>)databhelper.getAllSchoolData();



        String[] schoollist = new String[schoolList.size()];
        int i=0;
        for(School sch:schoolList) {
            schoollist[i] = sch.getSchoolName();
            i++;

        }

        ArrayAdapter<String> adapt =  new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, schoollist );
        adapt.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line); //appear white fix it
        spinSchool.setAdapter(adapt);

    }

    Patient getFieldData()
    {

        String name, surname, grade,  emisnum, nokname, nokcontact , nokadddr1, nokaddr2, dob, gender, school;
        int schoolID;


        name =edtName.getText().toString();
        surname=edtSurname.getText().toString();
        grade=edtGrade.getText().toString();
        emisnum=edtEmisNum.getText().toString();
        nokname=edtNokName.getText().toString();
        nokcontact =edtNokContact.getText().toString();
        nokadddr1=edtNokAddrLine1.getText().toString();
        nokaddr2=edtNokAddrLine2.getText().toString();

        dob=txtDOB.getText().toString();
        gender=spinGender.getSelectedItem().toString();
        school=spinSchool.getSelectedItem().toString();
        schoolID =  schoolList.get(spinSchool.getSelectedItemPosition()).getSchoolID();

        boolean hasRoadtoHealth = false;
        if(radYES.isChecked())
            hasRoadtoHealth =true;

        Patient patient = new Patient(name, surname,grade,gender,emisnum,school,schoolID,dob,nokname,nokcontact,nokadddr1,nokaddr2,hasRoadtoHealth);

        return patient;
    }


    boolean isFormCancelled()
    {
        return false;
    }

    public void registerPatient(View view)
    {

        if (databhelper.addPatientData(getFieldData()))
        {
            Snackbar.make(view, "Patient has been successfully added to the records", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }

    }

}
