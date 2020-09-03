package com.muddassir.kmacros

import android.view.View
import android.widget.TextView
import kotlin.math.*

/**
 * Mutable height for views.
 *
 * @get - get the current height of the view from its layoutParams.
 * @set - sets the given height of the view using its layoutParams.
 */
var View.mutableHeight: Int
    get() {
        return this.layoutParams.height
    }
    set(value) {
        val layoutParams = this.layoutParams
        layoutParams.height = value
        this.layoutParams = layoutParams
    }

/**
 * Mutable width for views.
 *
 * @get - get the current width of the view from its layoutParams.
 * @set - sets the given width of the view using its layoutParams.
 */
var View.mutableWidth: Int
    get() {
        return this.layoutParams.width
    }
    set(value) {
        val layoutParams = this.layoutParams
        layoutParams.width = value
        this.layoutParams = layoutParams
    }


/**
 * Set the minimum width of a TextView easily.
 *
 * @get - get the current minimum width of the TextView.
 * @set - sets the given minimum width of the TextView.
 */
var TextView.minW: Int
    get() {
        return max(this.minimumWidth, this.minWidth)
    }
    set(value) {
        this.minimumHeight = value
        this.minHeight = value
    }

/**
 * Set the minimum height of a TextView easily.
 *
 * @get - get the current minimum height of the TextView.
 * @set - sets the given minimum height of the TextView.
 */
var TextView.minH: Int
    get() {
        return max(this.minimumHeight, this.minHeight)
    }
    set(value) {
        this.minimumHeight = value
        this.minHeight = value
    }