package com.example.cdpi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        EditText ht = findViewById(R.id.ht);
        EditText tx = findViewById(R.id.tx);
        ht.setText("0");
        tx.setText("0");
    }

    public void calculerTaux(View v){
        EditText ht = findViewById(R.id.ht);
        EditText tx = findViewById(R.id.tx);
        TextView ttc = findViewById(R.id.ttc);

        Float htf = Float.parseFloat(ht.getText().toString());
        Float txf = Float.parseFloat(tx.getText().toString());
        ttc.setText(""+calcul(htf,txf));
    }

    private Float calcul(Float htf, Float txf) {
        Float tva = htf*(txf/100);
        Float resultat = htf+tva;
        Double arrondi = (Math.floor(resultat*100f))/100f;

        return arrondi.floatValue();
    }
}
