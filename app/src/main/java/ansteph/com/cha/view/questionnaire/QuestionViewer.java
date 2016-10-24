package ansteph.com.cha.view.questionnaire;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import ansteph.com.cha.R;

public class QuestionViewer extends AppCompatActivity {


    FragmentPagerAdapter adapterViewPager;
    ViewPager viewPager;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private Button btnprevious, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_viewer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapterViewPager = new QuestionViewerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);

        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnprevious = (Button) findViewById(R.id.btn_previous);
        btnNext = (Button) findViewById(R.id.btn_next);
        addBottomDots(0);

        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem();
                if (current > -1) {
                    // move to next screen
                    viewPager.setCurrentItem(current-1);
                } else {

                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem(+1);
                if (current < 2) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {

                }
            }
        });

    }


    private void addBottomDots(int currentPage)
    {
        dots = new TextView[2];

        int[] colorsActive =getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for(int i = 0; i < dots.length; i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);

    }

    private int getItem(int i){
        return viewPager.getCurrentItem() + i;
    }
    private int getItem(){return viewPager.getCurrentItem();}

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener()
    {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addBottomDots(position);

            //changing the next button text 'NEXT' / 'GOT IT'
            if(position == 1)
            {
                //last page. make button text to GOT IT
                btnNext.setText(getString(R.string.start));
                btnprevious.setVisibility(View.VISIBLE);
            }else{
                //still pages are left
                btnNext.setText(getString(R.string.next));
                btnprevious.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };





    public static  class QuestionViewerAdapter extends FragmentPagerAdapter{

        private static int NUM_ITEMS = 2;

        public  QuestionViewerAdapter (FragmentManager fragmentManager)
        {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0: return QuestionLytFragment.newInstance("Page # 1",0,2);
                case 1: return ReferralFragment.newInstance("Page # 2",1,3);

                default: return null;
            }
        }


        @Override
        public int getCount() {
            return NUM_ITEMS;
        }


        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "Questionnaire";
                case 1:return "Referral";

                default: return null;
            }

        }
    }


}
