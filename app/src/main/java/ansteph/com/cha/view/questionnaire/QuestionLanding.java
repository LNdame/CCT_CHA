package ansteph.com.cha.view.questionnaire;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import ansteph.com.cha.R;
import ansteph.com.cha.app.Constants;
import ansteph.com.cha.customview.HealthTest;
import ansteph.com.cha.customview.Screening_item;

public class QuestionLanding extends AppCompatActivity {



    Screening_item mDiabetes, mOral, mVisual, mNutritional, mPhisical, mHearing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_landing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        setScreningItems();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void setScreningItems()
    {
         mDiabetes = (Screening_item) findViewById(R.id.dash_btn_diabetes);
        mDiabetes.setDoneVisible(true);
        mDiabetes.setTestindicator(HealthTest.Diabetes);

        mOral = (Screening_item) findViewById(R.id.dash_btn_oral);
        mOral.setTestindicator(HealthTest.Oral);

        mVisual = (Screening_item) findViewById(R.id.dash_btn_visual);
        mVisual.setTestindicator(HealthTest.Visual);

        mNutritional = (Screening_item) findViewById(R.id.dash_btn_nutritional);
        mNutritional.setTestindicator(HealthTest.Nutritional);

        mPhisical = (Screening_item) findViewById(R.id.dash_btn_physical);
        mPhisical.setTestindicator(HealthTest.Physical);

        mHearing = (Screening_item) findViewById(R.id.dash_btn_hearing);
        mHearing.setTestindicator(HealthTest.Hearing);
      //  mDiabetes = (Screening_item) findViewById(R.id.dash_btn_diabetes);


    }

    public void questionnaireLaunch (View view)
    {
        Toast .makeText(this, "Got it", Toast.LENGTH_LONG).show();

        Intent i = null;
        switch (view.getId())
        {
            case R.id.dash_btn_diabetes: i = new Intent(getApplicationContext(), QuestionViewer.class);
                i.putExtra(Constants.SCREENID_KEY, Constants.DIABETES_SCRID);startActivity(i); break;
            case R.id.dash_btn_oral:i = new Intent(getApplicationContext(), QuestionViewer.class);
                i.putExtra(Constants.SCREENID_KEY, Constants.TB_SCRID);startActivity(i); break;
            case R.id.dash_btn_visual:i = new Intent(getApplicationContext(), QuestionViewer.class);
                i.putExtra(Constants.SCREENID_KEY, Constants.NUTRITIONAL_SCRID);startActivity(i); break;
            case R.id.dash_btn_nutritional:i = new Intent(getApplicationContext(), QuestionViewer.class);
                i.putExtra(Constants.SCREENID_KEY, Constants.VISUAL_SCRID);startActivity(i); break;
        }
    }





}
