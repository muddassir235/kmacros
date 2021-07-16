package com.muddassir.kmacros

import android.content.res.Resources
import android.os.Parcelable
import android.util.Base64
import java.io.*


/**
 * dp - convert pixels into dps
 *
 * @return display pixels float
 */
val Int.dp: Float
    get() = (this / Resources.getSystem().displayMetrics.density)

/**
 * arabicNumber - Convert an Int to an arabic number which has arabic notation of digits e.g. ١,٢,٣
 *
 * @return The Int as an arabic number.
 */

val Int.arabicNumber: String
    get() {
        val mapping = mapOf('0' to '٠', '1' to '١', '2' to '٢', '3' to '٣', '4' to '٤',
            '5' to '٥', '6' to '٦', '7' to '٧', '8' to '٨', '9' to '٩')

        var numberString = ""; toString().forEach { numberString+=mapping[it] }
        return numberString
    }

/**
 * px - convert display pixels into pixels
 *
 * @return number of pixels Int
 */
val Float.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

/**
 * Time in milliseconds to time string
 * - If time in ms is >= 4,140,000 ms the string would have the format HH:MM:SS
 * - If time in ms is < 4,140,000 ms the string would have the format MM:SS
 *
 * @return Time string
 */
val Long.time: String
    get() {
        if(this < 0) return "00:00"

        val hours     = this / (1000*60*60)
        var remainder = this % (1000*60*60)
        val minutes   = remainder / (1000*60)
        remainder %= (1000 * 60)
        val seconds   = remainder / 1000

        var time = ""

        if(hours != 0L) {
            time += String.format("%02d", hours)
        }
        time = time + (if (time == "") "" else ":") + String.format("%02d", minutes)
        time = time + ":" + String.format("%02d", seconds)

        return time
    }