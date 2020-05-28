package com.example.cdpi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.gson.Gson;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TEST ERREUR","Mon erreur de Test");
        Log.i("TEST INFO","Mon info de Test");
        Log.w("TEST WARNING","Mon warning de Test");
        Button but = findViewById(R.id.btn1);
        but.setText("Hello");
        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"YOUPI",Toast.LENGTH_LONG).show();
    }

    public void toto(View v){
        Toast.makeText(this,"YOUPI2",Toast.LENGTH_LONG).show();
    }
}
