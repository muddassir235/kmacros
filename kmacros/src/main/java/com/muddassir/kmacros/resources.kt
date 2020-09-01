package com.muddassir.kmacros

import android.content.res.Resources

/* The height of the device screen */
val screenHeight: Int
    get() = (Resources.getSystem().displayMetrics.heightPixels)

/* The width of the device screen */
val screenWidth: Int
    get() = (Resources.getSystem().displayMetrics.widthPixels)
