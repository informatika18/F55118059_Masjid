package com.example.f55118059_masjid;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

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



        // marker pengguna
        LatLng pengguna = new LatLng(4.155999, 117.902975);
        mMap.addMarker(new MarkerOptions().position(pengguna).title("Lokasi saya").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pengguna));
        LatLngBounds australiaBounds =new LatLngBounds(
                new LatLng(-44 , 113),
                new LatLng(-10, 154)
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(australiaBounds.getCenter(),13.5f));
        // Add a marker in masjid1
        LatLng masjid1 = new LatLng(4.15809, 117.90373);
        mMap.addMarker(new MarkerOptions().position(masjid1).title("ini Masjid Baburahim"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(masjid1));

        //add a marker masjid2
        LatLng masjid2 = new LatLng(4.1478354, 117.909170);
        mMap.addMarker(new MarkerOptions().position(masjid2).title("ini Masjid Nurul Huda"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(masjid2));

        //add marker masjid3
        LatLng masjid3 = new LatLng(4.151509, 117.905540);
        mMap.addMarker(new MarkerOptions().position(masjid3).title("ini Masjid As Shobirin"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(masjid3));

        //polyline ke masjid Baburahim
        mMap.addPolyline(new PolylineOptions().add(
                pengguna,
                new LatLng(4.15613, 117.90309),
                new LatLng(4.15638,117.90295),
                new LatLng(4.15665, 117.90280),
                new LatLng(4.15703,117.90259),
                new LatLng(4.15708, 117.90263),
                new LatLng(4.15725,117.90292),
                new LatLng(4.15753, 117.90344),
                new LatLng(4.15773, 117.90381),
                masjid1
        ).width(10).color(Color.BLUE));
    }
}