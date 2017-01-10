package ansteph.com.cha.customview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import ansteph.com.cha.R;

/**
 * Created by loicStephan on 09/12/2016.
 */

public class Question_sub_title extends LinearLayout {


    private TextView quesTitle;
    private String title;
    public Question_sub_title(Context context) {
        super(context);
        initViews(context);
    }

    public Question_sub_title(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Question_sub_title(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void initViews(Context context)
    {
        LayoutInflater.from(context).inflate(R.layout.questionsubdivisiontitle, this);


        quesTitle = (TextView) findViewById(R.id.txtTitle);

        if(!TextUtils.isEmpty(getQuesTitle()) )
            quesTitle.setText(getQuesTitle());



    }


    public String getQuesTitle() {
        return title;
    }

    public void setQuesTitle(String title) {
        this.title = title;
        if(quesTitle!=null)
            quesTitle.setText(title);
    }
}
