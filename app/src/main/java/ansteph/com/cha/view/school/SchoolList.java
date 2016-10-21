package ansteph.com.cha.view.school;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import ansteph.com.cha.R;
import ansteph.com.cha.fabtransition.BaseActivity;
import ansteph.com.cha.fabtransition.SheetLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SchoolList extends BaseActivity implements SheetLayout.OnFabAnimationEndListener {

    @Bind(R.id.bottom_sheet) SheetLayout mSheetLayout;
    @Bind(R.id.fab)FloatingActionButton mFab;
    @Bind(R.id.list_mails) ListView listmails;


    private static final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_list);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);
        setUpToolbarWithTitle(getString(R.string.schooltitle), true);

        mSheetLayout.setFab(mFab);
        mSheetLayout.setFabAnimationEndListener(this);
    }



    @OnClick(R.id.fab)
    void onFabClick() {mSheetLayout.expandFab();}




    @Override
    public void onFabAnimationEnd() {
        Intent intent = new Intent(this, EditSchool.class);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            mSheetLayout.contractFab();
        }
    }
}
