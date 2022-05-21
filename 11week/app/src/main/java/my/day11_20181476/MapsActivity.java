package my.day11_20181476;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import my.day11_20181476.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    LocationListener locationListener;
    LocationManager locationManager;

    LatLng prey_loc;//이전위치
    LatLng curr_loc;//현제위치

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                updateMap(location);
            }
        };


        /*
        LatLng Dju = new LatLng(36.33507530825203, 127.45754662933541);
        LatLng Wsu = new LatLng(36.33604492758869, 127.45377642297358);

        mMap.addMarker(new MarkerOptions().position(Dju).title("대전대학교"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Dju));

        mMap.addMarker(new MarkerOptions().position(Wsu).title("우송대학교"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Wsu));*/
    }

    private void updateMap(Location location) {

        //위도
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        //경도
        curr_loc = new LatLng(latitude, longitude);




        if (prey_loc == null) {
            CameraUpdate factory = CameraUpdateFactory.zoomTo(15);
            mMap.moveCamera(factory);

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            mMap.setMyLocationEnabled(true);

            prey_loc = curr_loc;

        }
    }
}