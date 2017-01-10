package ansteph.com.cha.view.questionnaire;


import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import java.util.ArrayList;

import ansteph.com.cha.R;
import ansteph.com.cha.app.Constants;
import ansteph.com.cha.customview.Question_close_ended;
import ansteph.com.cha.customview.Question_open_ended_alpha;
import ansteph.com.cha.customview.Question_open_ended_num;
import ansteph.com.cha.customview.Question_sub_title;
import ansteph.com.cha.helper.DbHelper;
import ansteph.com.cha.model.QuestionSubdivision;
import ansteph.com.cha.model.ScreeningQuestion;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionLytFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionLytFragment extends Fragment {


    public static final String TAG = QuestionLytFragment.class.getSimpleName();

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String PAGE_TITLE = "title";
    private static final String PAGE_NUM = "page";

    // TODO: Rename and change types of parameters
    private String title;
    private int page;
    private static final String ARG_SECTION_NUMBER = "section_number";

    public ArrayList<ScreeningQuestion>  screeningQuestionsList = new ArrayList<>();
    public ArrayList<QuestionSubdivision> questionSubdivisionList = new ArrayList<>();

    public DbHelper databhelper ;

    public QuestionLytFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Parameter 1.
     * @param pagenum Parameter 2.
     * @param sectionNumber Parameter 3.
     * @return A new instance of fragment QuestionLytFragment.
     */

    LinearLayout questionnairelyt ;

    public static QuestionLytFragment newInstance(String title, int pagenum, int sectionNumber) {
        QuestionLytFragment fragment = new QuestionLytFragment();
        Bundle args = new Bundle();
        args.putString(PAGE_TITLE, title);
        args.putInt(PAGE_NUM, pagenum);
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(PAGE_TITLE);
            page = getArguments().getInt(PAGE_NUM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_question_lyt, container, false);

        try {
            databhelper= new DbHelper(getActivity());
            databhelper.createDatabase();
        } catch (Exception e) {

            e.printStackTrace();
        }


        questionnairelyt = (LinearLayout) rootView.findViewById(R.id.questionnairelyt);

       // screeningQuestionsList = (ArrayList<ScreeningQuestion>) databhelper.getAllScreeningQuestData();
        if(((QuestionViewer)getActivity()).getScreenID()!=0)
            GetScreeningQuestion(((QuestionViewer)getActivity()).getScreenID());

       // setQuestionnaireLayout(screeningQuestionsList);




        //  screeningQuestionsList = (ArrayList<ScreeningQuestion>) databhelper.getQuestionSubData(Constants.DIABETES_SCRID);



        return rootView;
    }


    public void GetScreeningQuestion(int id)
    {
        questionSubdivisionList = (ArrayList<QuestionSubdivision>) databhelper.getQuestionSubData(id);

        for (QuestionSubdivision qu : questionSubdivisionList)
        {

            setQuestionnaireLayout((ArrayList<ScreeningQuestion>) databhelper.getScreeningQuestData(qu.getScCatID(),qu.getQusubID()), qu.getQusubName());
           // screeningQuestionsList.addAll((ArrayList<ScreeningQuestion>) databhelper.getScreeningQuestData(qu.getScCatID(),qu.getQusubID()));

           /* for(ScreeningQuestion sq :(ArrayList<ScreeningQuestion>) databhelper.getScreeningQuestData(qu.getScCatID(),qu.getQusubID()) )
            {
                screeningQuestionsList.add(sq);
            }*/
        }

    }

    public void setQuestionnaireLayout(ArrayList<ScreeningQuestion> questionList, String title)
    {
        Question_sub_title sub_title = new Question_sub_title(getActivity());
        sub_title.setQuesTitle(title);

        questionnairelyt.addView(sub_title);

        for (int i = 0; i< questionList.size(); i++)
        {
            Question_open_ended_num questnum = null;
            Question_close_ended questclose = null;
            Question_open_ended_alpha questalpha = null;





            //  Question_open_ended_num quest = new Question_open_ended_num(getActivity());
            ScreeningQuestion sc = questionList.get(i);
            // quest.setDescText(desc);
            LinearLayout lSquest = new LinearLayout(getActivity());
            lSquest.setOrientation(LinearLayout.VERTICAL);

            View lineView = new View(getActivity());
            lineView.setBackgroundColor(Color.DKGRAY);
            ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,1);
            lp.topMargin = 10;
            lp.bottomMargin = 10;
            lp.leftMargin = 10;
            lp.rightMargin = 10;

            lineView.setLayoutParams(lp);


            if( sc.getQuType().equals(Constants.QUTYPE_OPEN_NUM))
            {
                questnum =  new Question_open_ended_num(getActivity());
                questnum.setDescText(sc.getScqudesc());
                lSquest.addView(questnum);

            }else if (sc.getQuType().equals(Constants.QUTYPE_OPEN_ALPHA))
            {
                questalpha =  new Question_open_ended_alpha(getActivity());
                questalpha.setDescText(sc.getScqudesc());
                lSquest.addView(questalpha);
            }else if (sc.getQuType().equals(Constants.QUTYPE_CLOSE_ENDED))
            {

                questclose =  new Question_close_ended(getActivity());
                questclose.setDescText(sc.getScqudesc());
                lSquest.addView(questclose);
            }




            //  lSquest.addView(quest);

            lSquest.addView(lineView);

            questionnairelyt.addView(lSquest);  }
    }


}
