package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_map,container,false);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.MY_MAP);

        //what happens when user clicks on the map
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap gMap) {

                //setting starting point of the project
                CameraUpdate point = CameraUpdateFactory.newLatLngZoom(new LatLng(33.9312, -117.1928), 14);
                gMap.moveCamera(point);
                gMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(MapFragment.this));

                final LatLng vvhsLatLng = new LatLng(33.9312,-117.1928);
                Marker vvhs = gMap.addMarker(
                        new MarkerOptions()
                                .position(vvhsLatLng)
                                .title("Valley View High School")
                                .snippet("Future Events")
                );
                vvhs.showInfoWindow();


                gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener()
                {


                    @Override
                    public void onMapClick(@NonNull LatLng latLng)
                    {
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(latLng);
                        markerOptions.title(latLng.latitude + " KG " + latLng.longitude);
                        gMap.clear();
                        gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));
                        gMap.addMarker(markerOptions);

                    }
                }
                );
            }
        });
        return view;
    }
}