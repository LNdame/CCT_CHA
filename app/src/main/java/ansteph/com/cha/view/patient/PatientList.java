package ansteph.com.cha.view.patient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    }

    @OnClick(R.id.fab)
    void onFabClick(){
        startActivity(new Intent(getApplicationContext(), EditPatient.class));
    }

    private void setupRecyclerView()
    { recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        setContactsAdapter(desuNoto);}



    private void setContactsAdapter(String[] array) {
        recyclerView.setAdapter(
                new SimpleStringRecyclerViewAdapter(this, Arrays.asList(array), CONTACTS));
    }

    private void setCountriesAdapter(String[] array) {
        recyclerView.setAdapter(
                new SimpleStringRecyclerViewAdapter(this, Arrays.asList(array), COUNTRIES));
    }

    public static class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

        private final TypedValue mTypedValue = new TypedValue();
        private int mBackground;
        private List<String> mValues;
        private int[] mMaterialColors;
        private int mType;

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
            return mValues.get(position);
        }

        public SimpleStringRecyclerViewAdapter(Context context, List<String> items, int type) {
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
            mMaterialColors = context.getResources().getIntArray(R.array.colors);
            mBackground = mTypedValue.resourceId;
            mValues = items;
            mType = type;
        }

        @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.mat_list_item, parent, false);
            view.setBackgroundResource(mBackground);
            return new ViewHolder(view);
        }

        @Override public void onBindViewHolder(final ViewHolder holder, int position) {
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
            holder.mBoundString = mValues.get(position);
            holder.mIcon.setShapeColor(mMaterialColors[RANDOM.nextInt(mMaterialColors.length)]);
            holder.mTextView.setText(mValues.get(position));
            holder.mIcon.setLetter(mValues.get(position));
        }

        @Override public int getItemCount() {
            return mValues.size();
        }
    }

}
