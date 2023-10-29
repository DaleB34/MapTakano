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
                CameraUpdate point = CameraUpdateFactory.newLatLngZoom(new LatLng(33.9627, -117.2580), 12);
                gMap.moveCamera(point);
                gMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(getActivity()));

                //all school markers

                final LatLng vvhsLatLng = new LatLng(33.9312,-117.1928);

                String vvhsEvents = "<ol style=\"margin-top:3em;\">" +
                                     "<li>Ms.Rioux Gets One Million dollars</li>" +
                                    "<li>Ms.Rioux Gets One Million dollars</li>"
                                    + "</ol>";

                Marker vvhs = gMap.addMarker(
                        new MarkerOptions()
                                .position(vvhsLatLng)
                                .title("Valley View High School\n13135 Nason St.")
                                .snippet("⚫ Saturday Innovation Camp -November 4th" +
                                        "\n⚫ Veteran's Day -November 10th" +
                                        "\n⚫ Thanksgiving Break -November 20th - 24th")
                );

                final LatLng cshsLatLng = new LatLng(33.9624422, -117.2584702);
                Marker cshs = gMap.addMarker(
                        new MarkerOptions()
                                .position(cshsLatLng)
                                .title("Canyon Springs High School\n23100 Cougar Canyon Dr.")
                                .snippet("⚫ Cougar-Ween Costume Contest -October 31st" +
                                        "\n⚫ Marching Band Competition -November 1st" +
                                        "\n⚫ Coffee With Counselors -November 2nd" +
                                        "\n⚫ Winter Sports Parent Meeting -November 2nd" +
                                        "\n⚫ Marching Band Competition -November 7th")
                );

                final LatLng mvhsLatLng = new LatLng(33.9248377,-117.2561141);
                Marker mvhs = gMap.addMarker(
                        new MarkerOptions()
                                .position(mvhsLatLng)
                                .title("Moreno Valley High School\n23300 Cottonwood Ave.")
                                .snippet("⚫ Band Competition -November 1st" +
                                        "\n⚫ Dia De Los Muertos Performance -November 1st" +
                                        "\n⚫ CTE Trade Show Field Trip -November 3rd" +
                                        "\n⚫ Choir Festival -November 7th" +
                                        "\n⚫ 9th Grade AVID Trip -November 7th")
                );

                final LatLng vdlhsLatLng = new LatLng(33.9004429,-117.2083632);
                Marker vdlhs = gMap.addMarker(
                        new MarkerOptions()
                                .position(vdlhsLatLng)
                                .title("Vista Del Lago High School\n15150 Lasselle St.")
                                .snippet("⚫ Baseball Tryouts -November 1st" +
                                        "\n⚫ \"She Kills Monsters\" Play -November 2nd" +
                                        "\n⚫ \"She Kills Monsters\" Play -November 3rd")
                );

                final LatLng mvusdLatLng = new LatLng(33.9183429,-117.2153814);
                Marker mvusd = gMap.addMarker(
                        new MarkerOptions()
                                .position(mvusdLatLng)
                                .title("Moreno Valley Unified School District Office\n25634 Alessandro Blvd.")
                                .snippet("⚫ CBO Committee Meeting -November 1st" +
                                        "\n⚫ Board Study Session -November 2nd" +
                                        "\n⚫ African American Parent Awards -November 9th" +
                                        "\n⚫ Veteran's Day (No School) -November 10th" +
                                        "\n⚫ Regular Board Meeting -November 14th" +
                                        "\n⚫ Bountiful Harvest -November 17th" +
                                        "\n⚫ Thanksgiving Break -November 20th - 24th")
                );


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