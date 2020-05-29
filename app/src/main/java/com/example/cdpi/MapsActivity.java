package com.example.cdpi;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private Circle position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
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




        mMap.addPolygon(new PolygonOptions()
                                .add(gorgeDuLoup)
                                .add(somewhere)
                                .add(new LatLng(45.56630401611328,4.205170059204102))
                                .add(new LatLng(45.46630401611328,4.305170059204102))
                                .fillColor(Color.argb(127,0,0,255)).strokeColor(Color.BLUE));
    }

    @Override
    public void onLocationChanged(Location location) {

        if (position!=null) position.remove();
        LatLng pos = new LatLng(location.getLatitude(),location.getLongitude());
        CircleOptions copt = new CircleOptions()
                    .center(pos)
                    .radius(10.0)
                    .fillColor(Color.argb(127,0,0,255))
                    .strokeColor(Color.BLUE);


        position = mMap.addCircle(copt);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16.0f));

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
