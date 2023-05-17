package com.main.omwayapp.ui.views.map

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.main.omwayapp.Location

/*private fun RequestPermission(){
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION),PERMISSION_ID
        )
    }
    private fun CheckPermissions():Boolean{
        if(
            ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED||
            ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED
        ){
            return true
        }
        return false
    }
    private fun isLocationEnabled():Boolean{
        var locationManager:LocationManager=getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }*/

@Composable
fun rememberMapLifeCycle(map: MapView): LifecycleObserver {
    return remember {
        LifecycleEventObserver{source,event->
            when(event){
                Lifecycle.Event.ON_CREATE->map.onCreate(Bundle())
                Lifecycle.Event.ON_START->map.onStart()
                Lifecycle.Event.ON_RESUME->map.onResume()
                Lifecycle.Event.ON_PAUSE->map.onPause()
                Lifecycle.Event.ON_STOP->map.onPause()
                Lifecycle.Event.ON_DESTROY->map.onDestroy()
                Lifecycle.Event.ON_ANY->throw IllegalStateException()
            }
        }
    }
}

@Composable
fun OurGoogleMaps(location: Location, onReady:(GoogleMap)->Unit){
    //Map
    val context= LocalContext.current
    val mapView = remember { MapView(context) }
    val lifecycle= LocalLifecycleOwner.current.lifecycle
    lifecycle.addObserver(rememberMapLifeCycle(map = mapView))
    //Map
    AndroidView(factory = {
        mapView.apply {
            mapView.getMapAsync { googleMap ->
                val zoomLevel=18f
                val uam= LatLng(12.10877952,-86.2564972)
                googleMap.moveCamera(
                    CameraUpdateFactory.
                    newLatLngZoom(location.coordinate,zoomLevel))
                googleMap.addMarker(
                    MarkerOptions().
                    position(location.coordinate).
                    title(location.title).
                    snippet(location.description))
                //googleMap.mapType=2
            }
        }
    })

}