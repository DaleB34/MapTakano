package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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
                //and other things to make
                CameraUpdate point = CameraUpdateFactory.newLatLngZoom(new LatLng(33.9312, -117.1928), 14);
                gMap.moveCamera(point);
                gMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(getActivity()));

                final LatLng vvhsLatLng = new LatLng(33.9312,-117.1928);

                String vvhsEvents = "<ol style=\"margin-top:3em;\">" +
                                     "<li>Ms.Rioux Gets One Million dollars</li>" +
                                    "<li>Ms.Rioux Gets One Million dollars</li>"
                                    + "</ol>";

                Marker vvhs = gMap.addMarker(
                        new MarkerOptions()
                                .position(vvhsLatLng)
                                .title("Valley View High School")
                                .snippet("<p>Future Events</p>" + vvhsEvents)
                );
                vvhs.showInfoWindow();


                //onclick map functionality
//                gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener()
//                {
//                    @Override
//                    public void onMapClick(@NonNull LatLng latLng)
//                    {
//                        MarkerOptions markerOptions = new MarkerOptions();
//                        markerOptions.position(latLng);
//                        markerOptions.title(latLng.latitude + " KG " + latLng.longitude);
//                        gMap.clear();
//                        gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));
//                        gMap.addMarker(markerOptions);
//
//                    }
//                }
//
//                );
            }
        });
        return view;
    }
}