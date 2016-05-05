package com.example.android.bankqueue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class BankPicker extends AppCompatActivity implements OnMapReadyCallback {

    public String markerTitle;
    public String otdStreet="otdStreet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_picker);
        setTitle("Выбор отделения");

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        }
    public void onMapReady(GoogleMap map) {
        final Button okBtn = (Button) findViewById(R.id.okBtn);
        okBtn.setEnabled(false);
        LatLng lt=new LatLng(58.020906,56.236994);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(lt,10));
        Marker sibM=map.addMarker(new MarkerOptions()
        .position(new LatLng(58.001163,56.259819))
        .title("Сибирская 52")
        .snippet("Время работы: 09:00-20:00")
        .draggable(false));

        sibM.showInfoWindow();

        Marker leninM=map.addMarker(new MarkerOptions()
        .position(new LatLng(58.008729,56.230437))
        .title("Ленина 64")
        .snippet("Время работы: 09:00-17:00")
        .draggable(false));

        leninM.showInfoWindow();

        Marker krup=map.addMarker(new MarkerOptions()
                .position(new LatLng(58.017041, 56.279939))
                .title(" Крупской 31")
                .snippet("Время работы: 10:00-19:00")
                .draggable(false));

        krup.showInfoWindow();

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                markerTitle=marker.getTitle();
                okBtn.setEnabled(true);
                return false;
            }
        });
    }

    public  void ok(View view)
    {
        Intent gPick =new Intent(this, GoalPicker.class);
        gPick.putExtra(otdStreet, markerTitle);
        startActivity(gPick);
    }

}