package mx.edu.ittepic.tpdm_u4_u5_practica2

import android.graphics.*
import android.widget.Toast

class Mapa(l:Lienzo,posx:Float,posy:Float,escalaX:Int,escalaY:Int,id_img:Int,p:MainActivity) {
    var lienzo = l
    var puntero = p

    var x = posx
    var y = posy
    var x2 = 0f
    var y2 = 0f
    var toquex2 = 0f
    var toquey2 = 0f

    var pinX = 300f
    var pinY = 800f


    var sx = escalaX
    var sy = escalaY

    var imagen = BitmapFactory.decodeResource(lienzo.resources,id_img)
    var pin = BitmapFactory.decodeResource(lienzo.resources,R.drawable.pin)
    var mapaEscala: Bitmap?= null
    var pinEscala: Bitmap?= null

    var p = Paint()



    fun paintMapa(c: Canvas){
        mapaEscala = Bitmap.createScaledBitmap(imagen,sx,sy,false)
        pinEscala = Bitmap.createScaledBitmap(pin,sx/35,(sy/35)-20,false)
        c.drawBitmap(mapaEscala!!,x,y,Paint())
        c.drawBitmap(pinEscala!!,x+pinX,y+pinY,Paint())

    }

    fun estaEnArea(toquex:Float,toquey:Float):Boolean{
        x2 = x+mapaEscala!!.width
        y2 = y+mapaEscala!!.height
        if(toquex >= x && toquex <= x2){
            if(toquey >= y && toquey <= y2){
                return true
            }
        }

        return false
    }

    fun mover(toquex:Float,toquey:Float){
        x += toquex
        y += toquey
        //Toast.makeText(puntero,"--> $x1, --> $x2, --> $y1, --> $y2", Toast.LENGTH_SHORT).show()
    }

    fun moverPin(longitud:Float,latitud:Float){
        pinX = pinX+longitud
        pinY = pinY+latitud
    }

    fun zoomIn(){
        sx += 200
        sy += 200
        pinX += 100
        pinY += 200
    }

    fun zoomOut(){
        sx -= 200
        sy -= 200
        pinX -= 100
        pinY -= 200
    }

}