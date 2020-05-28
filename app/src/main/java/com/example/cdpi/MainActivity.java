package com.example.cdpi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("TEST ERREUR","Mon erreur de Test");
        Log.i("TEST INFO","Mon info de Test");
        Log.w("TEST WARNING","Mon warning de Test");


    }
}
