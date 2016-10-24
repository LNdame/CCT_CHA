package ansteph.com.cha.view.questionnaire;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ansteph.com.cha.R;

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


        return rootView;
    }

}
