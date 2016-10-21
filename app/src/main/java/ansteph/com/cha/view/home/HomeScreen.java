package ansteph.com.cha.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import ansteph.com.cha.R;
import ansteph.com.cha.view.patient.PatientList;
import ansteph.com.cha.view.school.SchoolList;

public class HomeScreen extends AppCompatActivity {
    private Boolean isFabOpen = false;
    FloatingActionButton fabPatient, fab, fabSchool;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);



       fabPatient = (FloatingActionButton) findViewById(R.id.fabPatient);
        fabSchool = (FloatingActionButton) findViewById(R.id.fabSchool);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });

        fabPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(), PatientList.class));
            }
        });

        fabSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SchoolList.class));
            }
        });
    }


    public void animateFab()
    {
        if(isFabOpen){
            fab.startAnimation(rotate_backward);
            fabSchool.startAnimation(fab_close);
            fabPatient.startAnimation(fab_close);
            fabSchool.setClickable(false);
            fabPatient.setClickable(false);

            isFabOpen = false;

        }else{
            fab.startAnimation(rotate_forward);
            fabSchool.startAnimation(fab_open);
            fabPatient.startAnimation(fab_open);
            fabSchool.setClickable(true);
            fabPatient.setClickable(true);

            isFabOpen = true;
        }
    }

}
