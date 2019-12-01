package mx.edu.ittepic.tpdm_u4_u5_practica2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.widget.Toast

class Rectangulo(l:Lienzo, X1:Float, Y1:Float,X2:Float,Y2:Float,color: Int,cadena:String,p:MainActivity) {
    var x1 = X1
    var x2 = X2
    var y1 = Y1
    var y2 = Y2
    var cad = cadena
    var dx = 0f
    var dx2 = 0f
    var dy = 0f
    var dy2 = 0f
    var puntero = p

    var activity = MainActivity()

    var p = Paint()
    var color = color

    fun pRect(c: Canvas){
        p.color = color
        c.drawRect(x1,y1,x2,y2,p)

        p.color = Color.BLUE
        p.textSize = 20f
        //canvas tiene los metodos de dibujo, pero estilizado tipo paint
        c.drawText(cad,x1+5,y1+20,p)

    }

    fun estaEnArea(toquex:Float,toquey:Float):Boolean{
        if(toquex >= x1 && toquex <= x2){
            if(toquey >= y1 && toquey <= y2){
                return true
            }
        }

        return false
    }

    fun mover(toquex:Float,toquey:Float){
        dx = toquex-x1
        dx2 = x2-toquex
        dy = toquey-y1
        dy2 = y2-toquey


        x1 = toquex-x1
        x2 = toquex+dx2
        y1 = toquey-dy
        y2 = toquey+dy2
        Toast.makeText(puntero,"--> $x1, --> $x2, --> $y1, --> $y2",Toast.LENGTH_SHORT).show()
    }
}