package com.main.omwayapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.compose.MapType
import com.main.omwayapp.ui.theme.OMWayAppTheme

//Hola amigos, bienvenidos a la app del futuro $$$
data class Location(val coordinate: LatLng,
                    val title:String,
                    val description:String)

//Unique id
var PERMISSION_ID=25
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OMWayAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        val uam=Location(LatLng(12.10877952,-86.2564972),"UAM","Universidad Americana")
                        OurGoogleMaps(uam){}
                    }
                }
            }
        }
    }



    @Composable
    fun OurGoogleMaps(location: Location,onReady:(GoogleMap)->Unit){
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
}
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
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OMWayAppTheme {
        Greeting("Android")
    }
}

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