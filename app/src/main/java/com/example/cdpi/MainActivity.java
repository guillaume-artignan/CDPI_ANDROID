package com.example.cdpi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;
public class MainActivity extends AppCompatActivity implements Animator.AnimatorListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TEST ERREUR","Mon erreur de Test");
        Log.i("TEST INFO","Mon info de Test");
        Log.w("TEST WARNING","Mon warning de Test");

    }


    public void connect(View v){
        EditText loginText = findViewById(R.id.main_login);
        EditText passwordText = findViewById(R.id.main_password);


        if (    "g".equals(loginText.getText().toString())
            &&  "p".equals(passwordText.getText().toString())) {

            View main = findViewById(R.id.main_layout);
            main.animate()
                    .alpha(0.0f)
                    .translationX(200)
                    .setDuration(400)
                    .setListener(this);


        }
        else Toast.makeText(this,R.string.message_error_connect,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        Intent i = new Intent(this,MenuActivity.class);
        startActivity(i);
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
