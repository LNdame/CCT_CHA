package ansteph.com.cha.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import ansteph.com.cha.R;
import ansteph.com.cha.model.ScreeningQuestion;

/**
 * Created by loicStephan on 06/11/2016.
 */

public class Question_open_ended_num extends LinearLayout {


    private TextView questiondesc;
    private EditText questionanswer;
   LinearLayout containerLyt;// quest_open_endedlyt

    private int questionStyle, headerStye;
    private ScreeningQuestion screeningQuestion;

    private String descText;

    public Question_open_ended_num(Context context) {
        super(context, null);
        initViews( context);
       // LayoutInflater.from(context).inflate(R.layout.question_open_num, this);
    }

    public Question_open_ended_num(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews( context, attrs);

    }

    public Question_open_ended_num(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews( context, attrs);

    }


    private void initViews(Context context)
    {
        LayoutInflater.from(context).inflate(R.layout.question_open_num, this);
        containerLyt = (LinearLayout) findViewById(R.id.quest_open_endedlyt) ;

        questiondesc = (TextView) findViewById(R.id.txtquestiondesc);

        if(!TextUtils.isEmpty(getDescText()) )
            questiondesc.setText(getDescText());


        questionanswer = (EditText) findViewById(R.id.txtresponse);
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



        LayoutInflater.from(context).inflate(R.layout.question_open_num, this);
        containerLyt = (LinearLayout) findViewById(R.id.quest_open_endedlyt) ;

        questiondesc = (TextView) findViewById(R.id.txtquestiondesc);

        if(!TextUtils.isEmpty(getDescText()) )
            questiondesc.setText(getDescText());

        questiondesc.setTextAppearance(context,headerStye);
        questionanswer = (EditText) findViewById(R.id.txtresponse);
    }

    public String getAnswer()
    {
        return questionanswer.getText().toString().trim();
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
