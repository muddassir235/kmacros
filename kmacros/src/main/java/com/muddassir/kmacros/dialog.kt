package com.muddassir.kmacros

import android.app.Dialog
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Build
import android.util.DisplayMetrics
import androidx.annotation.RequiresApi

/**
 * setWhiteNavigationBar - set the color of the the Navigation bar
 *
 * @param dialog The dialog for which the navigation bar color is being adjusted
 * @param color  The color to set the navigation bar to.
 */
@RequiresApi(api = Build.VERSION_CODES.M)
fun Dialog.setNavigationBarColor(color:Int) {
    window?.let {
        val metrics = DisplayMetrics()
        it.windowManager.defaultDisplay.getMetrics(metrics)

        val dimDrawable = GradientDrawable()
        val navigationBarDrawable = GradientDrawable()

        navigationBarDrawable.shape = GradientDrawable.RECTANGLE
        navigationBarDrawable.setColor(color)
        val layers =
            arrayOf<Drawable>(dimDrawable, navigationBarDrawable)

        val windowBackground = LayerDrawable(layers)
        windowBackground.setLayerInsetTop(1, metrics.heightPixels)
        it.setBackgroundDrawable(windowBackground)
    }
}