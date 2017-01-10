package ansteph.com.cha.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import ansteph.com.cha.R;
import ansteph.com.cha.model.ScreeningQuestion;

/**
 * Created by loicStephan on 06/12/2016.
 */

public class Question_close_ended extends LinearLayout {


    private TextView questiondesc;

    LinearLayout containerLyt;// quest_open_endedlyt

    private int questionStyle, headerStye;
    private ScreeningQuestion screeningQuestion;
    private RadioButton radYes, radNo;
    private String descText;

    public Question_close_ended(Context context) {
        super(context);
        initViews( context);
    }

    public Question_close_ended(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews( context,attrs);
    }

    public Question_close_ended(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews( context,attrs);
    }

    private void initViews(Context context)
    {
        LayoutInflater.from(context).inflate(R.layout.question_close_ended, this);
        containerLyt = (LinearLayout) findViewById(R.id.quest_open_closelyt) ;

        questiondesc = (TextView) findViewById(R.id.txtquestiondesc);

        radYes =(RadioButton) findViewById(R.id.radYes);
        radNo =(RadioButton) findViewById(R.id.radNo);
        if(!TextUtils.isEmpty(getDescText()) )
            questiondesc.setText(getDescText());



    }

    private void initViews(Context context, AttributeSet attrs)
    {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.questionLayoutStyle,0,0);

        try{
            questionStyle = a.getResourceId(R.styleable.questionLayoutStyle_questionStyle, R.style.questionnaireItemStyle);
            headerStye = a.getResourceId(R.styleable.questionLayoutStyle_headerStyle,android.R.style.TextAppearance_DeviceDefault  );
        }finally {
            a.recycle();
        }


        LayoutInflater.from(context).inflate(R.layout.question_close_ended, this);
        containerLyt = (LinearLayout) findViewById(R.id.quest_open_closelyt) ;

        questiondesc = (TextView) findViewById(R.id.txtquestiondesc);
        radYes =(RadioButton) findViewById(R.id.radYes);
        radNo =(RadioButton) findViewById(R.id.radNo);

        if(!TextUtils.isEmpty(getDescText()) )
            questiondesc.setText(getDescText());

        questiondesc.setTextAppearance(context,headerStye);

    }

    public String getAnswer()
    {
        return "false";
    }

    public String getDescText() {
        return descText;
    }

    public void setDescText(String descText) {
        this.descText = descText;
        if(questiondesc!=null)
            questiondesc.setText(descText);
    }
}
