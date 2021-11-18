package com.example.teht2


import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    var xSet = 500f
    var ySet = 500f


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle(xSet,ySet,50f, Paint())
    }

    fun moveBall(x1:Float, y1:Float) {
        xSet= 500 + x1 * 50
        ySet= 500 + y1 * 50
        invalidate()
    }
}