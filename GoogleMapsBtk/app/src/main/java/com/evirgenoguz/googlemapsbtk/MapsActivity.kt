package com.evirgenoguz.googlemapsbtk

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.evirgenoguz.googlemapsbtk.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.Marker
import java.lang.Exception
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMapLongClickListener(dinleyici)


        // Add a marker in Sydney and move the camera
        /*
        val ankara = LatLng(39.9208372, 32.8454561)
        mMap.addMarker(MarkerOptions().position(ankara).title("Marker in Ankara"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ankara, 15f))
        */

        //Casting yaptık as ile
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        locationListener = object: LocationListener{
            override fun onLocationChanged(location: Location) {
                //println(location.latitude)
                //println(location.altitude)
                mMap.clear() //haritadaki markerları sıfırlamak için
                val guncelKonum = LatLng(location.latitude, location.longitude)
                mMap.addMarker(MarkerOptions().position(guncelKonum).title("Güncel Konum"))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(guncelKonum, 13f))

                val geocoder = Geocoder(this@MapsActivity, Locale.getDefault())

                try {
                    val adresListesi = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                    if (adresListesi.size > 0){
                        println(adresListesi.get(0).toString())
                    }

                } catch (e: Exception){
                    e.printStackTrace()
                }

            }

        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            //izin verilmemis
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        } else {
            //izin verilmiş
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1f, locationListener)
            val sonBilinenkonum = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (sonBilinenkonum != null){
                val sonBilinenLatLng = LatLng(sonBilinenkonum.latitude, sonBilinenkonum.longitude)
                mMap.addMarker(MarkerOptions().position(sonBilinenLatLng).title("Son Bilinen Konum"))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sonBilinenLatLng, 15f))
            }
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if (requestCode == 1){
            if (grantResults.size > 0){
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1f, locationListener)
                }
            }
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }


    val dinleyici = object: GoogleMap.OnMapLongClickListener {
        override fun onMapLongClick(p0: LatLng?) {
            mMap.clear()

            val geocoder = Geocoder(this@MapsActivity, Locale.getDefault())

            if (p0 != null){

                var adres = ""

                try {
                    val adresListesi = geocoder.getFromLocation(p0.latitude, p0.longitude, 1)

                    if (adresListesi.size > 0) {

                        if (adresListesi.get(0).thoroughfare != null) {
                            adres += adresListesi.get(0).thoroughfare
                            if (adresListesi.get(0).subThoroughfare != null) {
                                adres += adresListesi.get(0).subThoroughfare
                            }
                        }
                    }
                } catch (e: Exception){
                    e.printStackTrace()
                }

                mMap.addMarker(MarkerOptions().position(p0).title(adres))

            }
        }

    }



}