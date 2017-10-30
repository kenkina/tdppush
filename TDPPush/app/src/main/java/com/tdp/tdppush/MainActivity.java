package com.tdp.tdppush;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tdp.tdppush.util.Constants;
import com.tdp.tdppush.util.SharedPreferencesUtil;

public class MainActivity extends AppCompatActivity {

    Context context = this;

    TextView userIdTextView;
    EditText tokenEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        manageFirebas();

        Bundle extras = getIntent().getExtras();
        String userId;

        if (extras != null) {
            userId = extras.getString(Constants.ALUMNO_ID);
            userIdTextView = findViewById(R.id.tokenTextView);
            userIdTextView.setText(userId);

            tokenEditText = findViewById(R.id.tokenEditText);
            tokenEditText.setText(userId);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Mensaje enviado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    private void manageFirebas() {
        String token = FirebaseInstanceId.getInstance().getToken();
        SharedPreferencesUtil.saveTokenToPrefs(context, token);

        Log.d("token ==> ", token);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
