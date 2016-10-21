package ansteph.com.cha.view.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ansteph.com.cha.R;
import ansteph.com.cha.view.home.HomeScreen;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


    private void gotoHome()
    {
        Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
        startActivity(intent);
    }

    public void logClient (View view)
    {

        gotoHome();
    }


    public void registerClient (View view)
    {

        Intent intent = new Intent(getApplicationContext(), Registration.class);
        startActivity(intent);
    }


    public void retrievePwd (View view)
    {

        Intent intent = new Intent(getApplicationContext(), LostPassword.class);
        startActivity(intent);
    }

}
