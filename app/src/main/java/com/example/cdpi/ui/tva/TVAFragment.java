package com.example.cdpi.ui.tva;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.cdpi.R;

public class TVAFragment extends Fragment implements View.OnClickListener {

    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       this.root = inflater.inflate(R.layout.activity_rate, container, false);

        EditText ht = root.findViewById(R.id.ht);
        EditText tx = root.findViewById(R.id.tx);
        ht.setText("0");
        tx.setText("0");

        Button but = root.findViewById(R.id.button);
        but.setOnClickListener(this);

        return root;
    }


    public void calculerTaux(View v){
        EditText ht = root.findViewById(R.id.ht);
        EditText tx = root.findViewById(R.id.tx);
        TextView ttc = root.findViewById(R.id.ttc);

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

    @Override
    public void onClick(View v) {
        calculerTaux(v);
    }
}
