package com.example.cdpi;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            demandePermission();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void demandePermission(){
        //LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},42);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void launchRateActivity(View v){
        Intent i = new Intent(this,RateActivity.class);
        startActivity(i);
    }

    public void launchMapActivity(View v){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Intent i = new Intent(this,MapsActivity.class);
                startActivity(i);
            }else {
                Toast.makeText(this,"Désolé, j'ai pas la permission",Toast.LENGTH_LONG).show();
            }
        }else {
            Intent i = new Intent(this,MapsActivity.class);
            startActivity(i);
        }


    }
}
