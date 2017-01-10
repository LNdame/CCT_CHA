package ansteph.com.cha.customview;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ansteph.com.cha.R;
import ansteph.com.cha.app.Constants;
import ansteph.com.cha.view.questionnaire.QuestionViewer;

/**
 * Created by loicStephan on 12/12/2016.
 */

public class Screening_item extends LinearLayout {


    Button btnScreenItem;
    TextView txtDone;
    TextView txtHeader;
    TextView txtDesc;

    boolean isDoneVisible= true;

    HealthTest testindicator;

    public Screening_item(Context context) {
        super(context);
    }

    public Screening_item(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs);
    }

    public Screening_item(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context, attrs);
    }


    private void initViews(final Context context, AttributeSet attrs)
    {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.screening_item);

        LayoutInflater.from(context).inflate(R.layout.screening_item, this);

   //btnScreenItem = (Button) findViewById(R.id.btnleadingLetter);
        //
        txtHeader = (TextView) findViewById(R.id.txtleadingLetter);
        txtDesc = (TextView) findViewById(R.id.txtTitle);
        txtDone = (TextView) findViewById(R.id.txtdone);

       // Drawable top = getResources().getDrawable(R.drawable.ic_dental);
        txtDone.setVisibility(GONE);

        try{
            txtDesc.setText(a.getString(R.styleable.screening_item_title));
           // btnScreenItem.setText(a.getString(R.styleable.screening_item_leadingtitle));
            txtHeader.setText(a.getString(R.styleable.screening_item_leadingtitle));
         //  top = a.getDrawable(R.styleable.screening_item_android_drawableTop,R.drawable.ic_dental)   ;
        }finally {
            a.recycle();
        }

        LinearLayout lytCont = (LinearLayout)findViewById(R.id.lytContainer);
        lytCont.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast .makeText(context, "Got it from within", Toast.LENGTH_LONG).show();
                questionnaireLaunch ( context, testindicator);
            }
        });


  /* //   btnScreenItem.setCompoundDrawables(null,top ,null,null);

        btnScreenItem.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"it rang", Toast.LENGTH_LONG).show();

            }
        });*/
    }




    public void questionnaireLaunch (final Context context, HealthTest healthTest)
    {
       // Diabetes, Oral, Visual, Nutritional, Physical, Hearing, BMI, Chronic

        Intent i = null;
        switch (healthTest)
        {
            case Diabetes: i = new Intent(context, QuestionViewer.class);
                i.putExtra(Constants.SCREENID_KEY, Constants.DIABETES_SCRID);context.startActivity(i); break;
            case Oral:i = new Intent(context, QuestionViewer.class);
                i.putExtra(Constants.SCREENID_KEY, Constants.TB_SCRID);context.startActivity(i); break;
            case Nutritional:i = new Intent(context, QuestionViewer.class);
                i.putExtra(Constants.SCREENID_KEY, Constants.NUTRITIONAL_SCRID);context.startActivity(i); break;
            case Visual:i = new Intent(context, QuestionViewer.class);
                i.putExtra(Constants.SCREENID_KEY, Constants.VISUAL_SCRID);context.startActivity(i); break;
            case Physical:i = new Intent(context, QuestionViewer.class);
                i.putExtra(Constants.SCREENID_KEY, Constants.VISUAL_SCRID);context.startActivity(i); break;
            case Hearing:i = new Intent(context, QuestionViewer.class);
                i.putExtra(Constants.SCREENID_KEY, Constants.VISUAL_SCRID);context.startActivity(i); break;
            case BMI:i = new Intent(context, QuestionViewer.class);
                i.putExtra(Constants.SCREENID_KEY, Constants.VISUAL_SCRID);context.startActivity(i); break;
            case Chronic:i = new Intent(context, QuestionViewer.class);
                i.putExtra(Constants.SCREENID_KEY, Constants.VISUAL_SCRID);context.startActivity(i); break;
        }
    }



    public boolean isDoneVisible() {
        return isDoneVisible;
    }

    public void setDoneVisible(boolean doneVisible) {
        isDoneVisible = doneVisible;

        if(doneVisible)
        {
            txtDone.setVisibility(VISIBLE);
        }else{
            txtDone.setVisibility(GONE);
        }
    }

    public HealthTest getTestindicator() {
        return testindicator;
    }

    public void setTestindicator(HealthTest testindicator) {
        this.testindicator = testindicator;
    }
}
