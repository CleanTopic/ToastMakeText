package com.whynot.toastthird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private final String PREF_COUNTER_KEY = "PREF_COUNTER_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        int startupCounter = prefs.getInt(PREF_COUNTER_KEY, 0);
        startupCounter++;

        if(startupCounter > 2){
            Toast toast = Toast.makeText(getApplicationContext(),"Hello!", Toast.LENGTH_LONG);
            toast.show();
        }
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putInt(PREF_COUNTER_KEY, startupCounter);
        prefsEditor.apply();
    }
}