package com.example.oopsappv6;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class oopsMap extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private static final String TAG = "oopsMap";
    private GoogleMap mMap;
    private Geocoder geocoder;
    int x=LocCount();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oops_map);
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
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setOnMapLongClickListener(this);

        // Add a marker in Sydney and move the camera
        LatLng MGROAD = new LatLng(12.9716, 77.5946);
        mMap.addMarker(new MarkerOptions().position(MGROAD).title(String.valueOf(1)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MGROAD, 16));
        mMap.getUiSettings().setZoomControlsEnabled(true);

        for(int i=1;i<x+1;i++){
            LatLng temp=new LatLng(MapLat(i),MapLongi(i));
            mMap.addMarker(new MarkerOptions().position(temp).title(String.valueOf(i)));

        }
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        Log.d(TAG, "onMapLongClick: "+latLng.toString());
        x++;
        mMap.addMarker(new MarkerOptions().position(latLng).title(String.valueOf(x)));


        WriteLocation(x,latLng.latitude,latLng.longitude,latLng.toString());

    }
    public native void WriteLocation(int teint,double a,double b,String s);
    public native double MapLat(int teint);
    public native double MapLongi(int teint);
    public native int LocCount();


}