package com.example.cdpi;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng gorgeDuLoup = new LatLng(45.76630401611328,4.805170059204102);
        LatLng somewhere = new LatLng(45.86630501611328,4.905180059204102);
        mMap.addMarker(new MarkerOptions().position(gorgeDuLoup).title("Gorge du Loup"));
        mMap.addMarker(new MarkerOptions().position(somewhere).title("Quelque part"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gorgeDuLoup));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16.0f));

        mMap.addCircle(new CircleOptions()
                                .center(gorgeDuLoup)
                                .radius(10.0)
                                .fillColor(Color.argb(127,0,0,255))
                                .strokeColor(Color.BLUE));

        mMap.addPolygon(new PolygonOptions()
                                .add(gorgeDuLoup)
                                .add(somewhere)
                                .add(new LatLng(45.56630401611328,4.205170059204102))
                                .add(new LatLng(45.46630401611328,4.305170059204102))
                                .fillColor(Color.argb(127,0,0,255)).strokeColor(Color.BLUE));
    }
}
