package com.muddassir.kmacros

import android.view.View

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