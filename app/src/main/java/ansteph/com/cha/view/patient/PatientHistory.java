package ansteph.com.cha.view.patient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ansteph.com.cha.R;
import ansteph.com.cha.view.questionnaire.AssentForm;

public class PatientHistory extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<String> list = new ArrayList<String>();
    RecyclerView.Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.histRecyclerView);
        createList();  // in this method, Create a list of items.
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // call the adapter with argument list of items and context.
        mAdapter = new HistoryAdapter(list,this);
        mRecyclerView.setAdapter(mAdapter);
    }


    public void createList()
    {
        list.add("01/01/2016 23:59:59");
        list.add("01/01/2016 23:59:59");
        list.add("01/01/2016 23:59:59");
        list.add("01/01/2016 23:59:59");
        list.add("01/01/2016 23:59:59");

    }

    public void gotoAssessPat(View view)
    {
        startActivity(new Intent(getApplicationContext(), AssentForm.class));
    }

    public void gotoEditPat(View view)
    {
        startActivity(new Intent(getApplicationContext(), EditPatient.class));
    }



    public static class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{

        private List<String> mtList ;
        public Context mcontext;
        ViewHolder viewHolder;

        public HistoryAdapter(List<String> mtList, Context mcontext) {
            this.mtList = mtList;
            this.mcontext = mcontext;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemLyt = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, null);
            viewHolder = new ViewHolder(itemLyt);

            return viewHolder;
        }
        // Called by RecyclerView to display the data at the specified position.
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.date.setText(mtList.get(position));
        }

        //Returns the total number of items in the data set hold by the adapter.
        @Override
        public int getItemCount() {
            return mtList.size();
        }

        // initializes some private fields to be used by RecyclerView.
        public static class ViewHolder extends RecyclerView.ViewHolder {

            public TextView date;

            public ViewHolder(View itemLayoutView) {
                super(itemLayoutView);

                date = (TextView) itemLayoutView.findViewById(R.id.txtScreenDate);

            }
        }

    }


}
