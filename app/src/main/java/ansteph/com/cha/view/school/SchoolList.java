package ansteph.com.cha.view.school;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import ansteph.com.cha.fabtransition.BaseActivity;
import ansteph.com.cha.fabtransition.SheetLayout;
import ansteph.com.cha.materiallettericon.MaterialLetterIcon;

import ansteph.com.cha.view.patient.PatientList;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SchoolList extends BaseActivity implements SheetLayout.OnFabAnimationEndListener {

    @Bind(R.id.bottom_sheet) SheetLayout mSheetLayout;
    @Bind(R.id.fab)FloatingActionButton mFab;
   // @Bind(R.id.list_mails) ListView listmails;



   @Bind(R.id.recyclerview) RecyclerView recyclerView;
    private static final int CONTACTS = 0;
    private static final int COUNTRIES = 1;
    private static final Random RANDOM = new Random();

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

    RecyclerView.Adapter mSchoolAdapter;
    public SearchView search;

    private List<String> list = new ArrayList<String>();

    private static final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_list);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        search = (SearchView) findViewById( R.id.search);
        search.setOnQueryTextListener(listener);

        ButterKnife.bind(this);
        setUpToolbarWithTitle(getString(R.string.schooltitle), true);

        mSheetLayout.setFab(mFab);
        mSheetLayout.setFabAnimationEndListener(this);
        setupRecyclerView();


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

    private void setupRecyclerView()
    { recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        setCountriesAdapter(countries);}



    private void setContactsAdapter(String[] array) {
        recyclerView.setAdapter(
                new SchoolRecyclerViewAdapter(this, Arrays.asList(array), CONTACTS));
    }

    private void setCountriesAdapter(String[] array) {
        list=Arrays.asList(array);
        mSchoolAdapter= new SchoolRecyclerViewAdapter(this, Arrays.asList(array), COUNTRIES);
        recyclerView.setAdapter(mSchoolAdapter);
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

            recyclerView.setLayoutManager(new LinearLayoutManager(SchoolList.this));
            mSchoolAdapter =new SchoolRecyclerViewAdapter(SchoolList.this, filteredList, COUNTRIES);
            recyclerView.setAdapter(mSchoolAdapter);
            mSchoolAdapter.notifyDataSetChanged();  // data set changed
            return  true;
        }
    };




    public static class SchoolRecyclerViewAdapter
            extends RecyclerView.Adapter<SchoolRecyclerViewAdapter.ViewHolder> {

        private final TypedValue mTypedValue = new TypedValue();
        private int mBackground;
        private List<String> mSchoolList;
        private int[] mMaterialColors;
        private int mType;
        Context mContext;


        public SchoolRecyclerViewAdapter(Context context, List<String> items, int type) {
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
            mMaterialColors = context.getResources().getIntArray(R.array.colors);
            mBackground = mTypedValue.resourceId;
            mSchoolList = items;
            mType = type;
            mContext = context;
        }

        @Override public SchoolRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mat_list_item, parent, false);
            view.setBackgroundResource(mBackground);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO: 22/10/2016 change this to accomodate the school item remove this label once done
                    mContext.startActivity(new Intent(mContext, EditSchool.class));
                }
            });



            return new SchoolRecyclerViewAdapter.ViewHolder(view);


        }

        @Override public void onBindViewHolder(final SchoolRecyclerViewAdapter.ViewHolder holder, int position) {
            switch (mType) {
                case CONTACTS:
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
            holder.mBoundString = mSchoolList.get(position);
            holder.mIcon.setShapeColor(mMaterialColors[RANDOM.nextInt(mMaterialColors.length)]);
            holder.mTextView.setText(mSchoolList.get(position));
            holder.mIcon.setLetter(mSchoolList.get(position));
        }

        @Override public int getItemCount() {
            return mSchoolList.size();
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
            return mSchoolList.get(position);
        }
    }




}
