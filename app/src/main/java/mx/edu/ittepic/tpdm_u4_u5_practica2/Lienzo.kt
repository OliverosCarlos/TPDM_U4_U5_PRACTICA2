package mx.edu.ittepic.tpdm_u4_u5_practica2

import android.graphics.*
import android.view.View
import android.graphics.Shader
import android.graphics.LinearGradient
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.widget.Toast


class Lienzo(p:MainActivity,lm: LocationManager): View(p){
    var puntero = p
    var locationManager = lm
    var ancho = 500f
    var alto = 500f

    var coorX = 0.0
    var coorY = 0.0




    var mapa = Mapa(this,0f,0f,600,800,R.drawable.mapatec,puntero)
    var zoomIn = Imagen(this,100f,10f,64,64,R.drawable.zoom_in)
    var zoomOut = Imagen(this,20f,10f,64,64,R.drawable.zoom_out)
    var upArrow = Imagen(this,ancho-140f,alto-210f,64,64,R.drawable.uparrow)
    var rightArrow = Imagen(this,ancho-70f,alto-140f,64,64,R.drawable.rightarrow)
    var downArrow = Imagen(this,ancho-140f,alto-70f,64,64,R.drawable.downarrow)
    var leftArrow = Imagen(this,ancho-210f,alto-140f,64,64,R.drawable.leftarrow)


    var upArrow2 = Imagen(this,ancho-340f,alto-210f,64,64,R.drawable.uparrow)
    var rightArrow2 = Imagen(this,ancho-270f,alto-140f,64,64,R.drawable.rightarrow)
    var downArrow2 = Imagen(this,ancho-340f,alto-70f,64,64,R.drawable.downarrow)
    var leftArrow2 = Imagen(this,ancho-410f,alto-140f,64,64,R.drawable.leftarrow)


    var img: Imagen ?= null
    var map: Mapa ?= null

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        getData()
        val p = Paint()

        mapa.paintMapa(c)
        zoomIn.pintar(c)
        zoomOut.pintar(c)

        upArrow.pintar(c)
        rightArrow.pintar(c)
        downArrow.pintar(c)
        leftArrow.pintar(c)

        upArrow2.pintar(c)
        rightArrow2.pintar(c)
        downArrow2.pintar(c)
        leftArrow2.pintar(c)
    }


    override fun onTouchEvent(e: MotionEvent): Boolean {
        when(e.action){

            MotionEvent.ACTION_DOWN -> {

                if(zoomIn.estaEnArea(e.getX(),e.getY())){
                    //Toast.makeText(puntero,"Tocaste icono zoom in",Toast.LENGTH_SHORT).show()
                    mapa.zoomIn()
                    invalidate()

                }
                if(zoomOut.estaEnArea(e.getX(),e.getY())){
                    //Toast.makeText(puntero,"Tocaste icono zoom out",Toast.LENGTH_SHORT).show()
                    mapa.zoomOut()
                    invalidate()
                }
                if(upArrow.estaEnArea(e.getX(),e.getY())){
                    //Toast.makeText(puntero,"Tocaste icono zoom in",Toast.LENGTH_SHORT).show()
                    mapa.mover(0f,100f)
                    invalidate()

                }
                if(rightArrow.estaEnArea(e.getX(),e.getY())){
                    //Toast.makeText(puntero,"Tocaste icono zoom out",Toast.LENGTH_SHORT).show()
                    mapa.mover(-100f,0f)
                    invalidate()
                }
                if(downArrow.estaEnArea(e.getX(),e.getY())){
                    //Toast.makeText(puntero,"Tocaste icono zoom in",Toast.LENGTH_SHORT).show()
                    mapa.mover(0f,-100f)
                    invalidate()

                }
                if(leftArrow.estaEnArea(e.getX(),e.getY())){
                    //Toast.makeText(puntero,"Tocaste icono zoom out",Toast.LENGTH_SHORT).show()
                    mapa.mover(100f,0f)
                    invalidate()
                }


                if(upArrow2.estaEnArea(e.getX(),e.getY())){
                    //Toast.makeText(puntero,"Tocaste icono zoom in",Toast.LENGTH_SHORT).show()
                    mapa.moverPin(0f,-100f)
                    invalidate()

                }
                if(rightArrow2.estaEnArea(e.getX(),e.getY())){
                    //Toast.makeText(puntero,"Tocaste icono zoom out",Toast.LENGTH_SHORT).show()
                    mapa.moverPin(100f,0f)
                    invalidate()
                }
                if(downArrow2.estaEnArea(e.getX(),e.getY())){
                    //Toast.makeText(puntero,"Tocaste icono zoom in",Toast.LENGTH_SHORT).show()
                    mapa.moverPin(0f,100f)
                    invalidate()

                }
                if(leftArrow2.estaEnArea(e.getX(),e.getY())){
                    //Toast.makeText(puntero,"Tocaste icono zoom out",Toast.LENGTH_SHORT).show()
                    mapa.moverPin(-100f,0f)
                    invalidate()
                }
            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {

            }

        }
        return true
    }


    fun getData(){
        try {
            // Request location updates

            locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 0f, locationListener)
        }
        catch(ex: SecurityException) {
            Toast.makeText(puntero, "Security Exception, no location available "+ex,Toast.LENGTH_SHORT).show()

        }
    }


    // Define a listener that responds to location updates
    val locationListener = object : LocationListener {



        override fun onLocationChanged(location: Location) {
            //Toast.makeText( this@MainActivity,"getData",Toast.LENGTH_SHORT).show()
            coorX = ((location.longitude)+104.47)*1000
            coorY = ((location.latitude)-21.86)*1000
            Toast.makeText(puntero,"" + coorX + ":" + coorY,Toast.LENGTH_SHORT).show()

            mapa?.moverPin(0f,-10f)
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {
            Toast.makeText(puntero,"proveedor",Toast.LENGTH_SHORT)
        }

        override fun onProviderEnabled(provider: String) {
            Toast.makeText(puntero,"proveedor",Toast.LENGTH_SHORT)
        }

        override fun onProviderDisabled(provider: String) {
            Toast.makeText(puntero,"proveedor",Toast.LENGTH_SHORT)

        }
    }

}

