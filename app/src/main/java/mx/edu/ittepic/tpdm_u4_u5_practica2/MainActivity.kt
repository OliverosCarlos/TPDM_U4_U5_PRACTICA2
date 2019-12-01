package mx.edu.ittepic.tpdm_u4_u5_practica2

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var txt: TextView ?= null


    private var locationManager : LocationManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?
        setContentView(Lienzo(this,locationManager!!))

    }

}
