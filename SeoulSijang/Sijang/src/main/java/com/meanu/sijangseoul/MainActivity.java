package com.meanu.sijangseoul;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.meanu.sijangseoul.Product.ProductActivity;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LocationListener {


    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public final static int MY_PERMISSIONS_REQUEST_READ_LOCATION = 1;
    @BindView(R.id.floatingButton)
    FloatingActionButton floatingButton;
    private static final String TAG = "stelli";
    @BindView(R.id.buttonToResult)
    Button buttonToResult;
    LocationManager locationManager;
    private double latitude;
    private double longitude;

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        View view = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (view != null) {
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(Color.parseColor("#e8d5c3"));
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.BLACK);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            findViewById(R.id.first_container).setBackground(Objects.requireNonNull(this).getDrawable(R.drawable.backdrop_shape));
        }

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            GetLocationPermission();
            return;
        } else {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                                0,
                                0,
                                this);
                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                                0,
                                0,
                                this);
                    }

                } else {
                    Log.d(TAG, "onRequestPermissionsResult: ");
                    Process.killProcess(android.os.Process.myPid());
                }
                return;
            }

        }
    }

    @OnClick(R.id.buttonToResult)
    void GoSearchFragment(View v) {
        Intent intent = new Intent(MainActivity.this, ProductActivity.class);
        intent.putExtra("transition", 0);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        startActivity(intent);
        this.finish();
    }

    @OnClick(R.id.floatingButton)
    void GoProductGirdFragment(View v) {
        Intent intent = new Intent(MainActivity.this, ProductActivity.class);
        intent.putExtra("transition", 1);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        startActivity(intent);
        this.finish();
    }

    public void GetLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_READ_LOCATION);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d("test", "onLocationChanged, location:" + location);
        longitude = location.getLongitude();
        latitude = location.getLatitude();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
