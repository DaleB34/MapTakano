package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private View window;
    private Context context;

    public CustomInfoWindowAdapter(Context context)
    {
        this.context = context;
        window = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
    }

    private void rendowWindowText(Marker marker, View view)
    {
        String title = marker.getTitle();
        TextView tvTitle = (TextView) view.findViewById(R.id.title);
        if(!title.equals(""))
        {
            tvTitle.setText(title);
        }

        String snippet = marker.getTitle();
        TextView tvSnippet = (TextView) view.findViewById(R.id.snippet);
        if(!snippet.equals(""))
        {
            tvSnippet.setText(snippet);
        }
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        rendowWindowText(marker, window);
        return null;
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        rendowWindowText(marker, window);
        return null;
    }
}
