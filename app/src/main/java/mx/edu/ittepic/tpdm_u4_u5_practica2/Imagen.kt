package mx.edu.ittepic.tpdm_u4_u5_practica2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Imagen(l:Lienzo,posx:Float,posy:Float,escalaX:Int,escalaY:Int,id_img:Int) {
    var x = posx
    var y = posy

    var sx = escalaX
    var sy = escalaY
    var imagen = BitmapFactory.decodeResource(l.resources,id_img)
    var mapaEscala:Bitmap ?= null

    fun pintar(c: Canvas){
        mapaEscala = Bitmap.createScaledBitmap(imagen,sx,sy,false)
        c.drawBitmap(mapaEscala!!,x,y,Paint())
    }

    fun estaEnArea(toquex:Float,toquey:Float):Boolean{
        var x2 = x+mapaEscala!!.width
        var y2 = y+mapaEscala!!.height

        if(toquex >= x && toquex <= x2){
            if(toquey >= y && toquey <= y2){
                return true
            }
        }

        return false
    }

    fun mover(toquex:Float,toquey:Float){
        x = toquex-mapaEscala!!.width/2
        y = toquey-mapaEscala!!.height/2
    }

    fun zoomIn(){
        sx += 200
        sy += 200
    }

    fun zoomOut(){
        sx -= 200
        sy -= 200
    }
}