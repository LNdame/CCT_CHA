package ansteph.com.cha.view.patient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ansteph.com.cha.R;
import ansteph.com.cha.materiallettericon.MaterialLetterIcon;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PatientList extends AppCompatActivity {

    RecyclerView recyclerView;
    private static final int PATIENTS = 0;

    private static final int COUNTRIES = 1;
    private static final Random RANDOM = new Random();

    RecyclerView.Adapter mPatientAdapter;
    public SearchView search;

    private static final String[] desuNoto = {
            "Alane Avey", "Belen Brewster", "Brandon Brochu", "Carli Carrol", "Della Delrio",
            "Esther Echavarria", "Etha Edinger", "Felipe Flecha", "Ilse Island", "Kecia Keltz",
            "Lourie Lucas", "Lucille Leachman", "Mandi Mcqueeney", "Murray Matchett", "Nadia Nero",
            "Nannie Nipp", "Ozella Otis", "Pauletta Poehler", "Roderick Rippy", "Sherril Sager",
            "Taneka Tenorio", "Treena Trentham", "Ulrike Uhlman", "Virgina Viau", "Willis Wysocki"
    };
    private static final String[] countries = {
            "Albania", "Australia", "Belgium", "Canada", "China", "Dominica", "Egypt", "Estonia",
            "Finland", "France", "Germany", "Honduras", "Italy", "Japan", "Madagascar", "Netherlands",
            "Norway", "Panama", "Portugal", "Romania", "Russia", "Slovakia", "Vatican", "Zimbabwe"
    };


    private List<String> list = new ArrayList<String>();

    @Bind(R.id.fab) FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        setupRecyclerView();
        search = (SearchView) findViewById( R.id.search);
        search.setOnQueryTextListener(listener);
    }

    @OnClick(R.id.fab)
    void onFabClick(){
        startActivity(new Intent(getApplicationContext(), EditPatient.class));
    }

    private void setupRecyclerView()
    { recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        setContactsAdapter(desuNoto);}



    private void setContactsAdapter(String[] array) {
        list = Arrays.asList(array); // TODO: 22/10/2016 when the object is being used change this logic 
        mPatientAdapter = new  PatientRecyclerViewAdapter(this, Arrays.asList(array), PATIENTS);
        recyclerView.setAdapter(mPatientAdapter);
    }

    private void setCountriesAdapter(String[] array) {
        recyclerView.setAdapter(
                new PatientRecyclerViewAdapter(this, Arrays.asList(array), COUNTRIES));
    }



    SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String query) {
            query = query.toLowerCase();
            final List<String> filteredList = new ArrayList<>();

            for (int i= 0; i<list.size(); i++)
            {
                final String text = list.get(i).toLowerCase();
                if(text.contains(query)){
                    filteredList.add(list.get(i));
                }
            }

            recyclerView.setLayoutManager(new LinearLayoutManager(PatientList.this));
            mPatientAdapter =new PatientRecyclerViewAdapter(PatientList.this, filteredList, PATIENTS);
            recyclerView.setAdapter(mPatientAdapter);
            mPatientAdapter.notifyDataSetChanged();  // data set changed
            return  true;
        }
    };





    public static class PatientRecyclerViewAdapter
            extends RecyclerView.Adapter<PatientRecyclerViewAdapter.ViewHolder> {

        private final TypedValue mTypedValue = new TypedValue();
        private int mBackground;
        private List<String> mPatientList;
        private int[] mMaterialColors;
        private int mType;

        Context mContext;

        public PatientRecyclerViewAdapter(Context context, List<String> items, int type) {
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
            mMaterialColors = context.getResources().getIntArray(R.array.colors);
            mBackground = mTypedValue.resourceId;
            mPatientList = items;
            mType = type;
            mContext = context;
        }

        @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.mat_list_item, parent, false);
            view.setBackgroundResource(mBackground);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO: 22/10/2016 change this to accomodate the patient item remove this label once done
                    mContext.startActivity(new Intent(mContext, EditPatient.class));
                }
            });
            return new ViewHolder(view);
        }

        @Override public void onBindViewHolder(final ViewHolder holder, int position) {
            switch (mType) {
                case PATIENTS:
                    holder.mIcon.setInitials(true);
                    holder.mIcon.setInitialsNumber(2);
                    holder.mIcon.setLetterSize(18);
                    break;
                case COUNTRIES:
                    holder.mIcon.setLettersNumber(3);
                    holder.mIcon.setLetterSize(16);
                    holder.mIcon.setShapeType(MaterialLetterIcon.Shape.RECT);
                    break;
            }
            holder.mBoundString = mPatientList.get(position);
            holder.mIcon.setShapeColor(mMaterialColors[RANDOM.nextInt(mMaterialColors.length)]);
            holder.mTextView.setText(mPatientList.get(position));
            holder.mIcon.setLetter(mPatientList.get(position));
        }

        @Override public int getItemCount() {
            return mPatientList.size();
        }


        public static class ViewHolder extends RecyclerView.ViewHolder {
            public String mBoundString;

            public final View mView;
            public final MaterialLetterIcon mIcon;
            public final TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIcon = (MaterialLetterIcon) view.findViewById(R.id.icon);
                mTextView = (TextView) view.findViewById(android.R.id.text1);
            }

            @Override public String toString() {
                return super.toString() + " '" + mTextView.getText();
            }
        }

        public String getValueAt(int position) {
            return mPatientList.get(position);
        }



    }

}
