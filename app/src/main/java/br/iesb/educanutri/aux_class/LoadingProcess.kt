package br.iesb.educanutri.aux_class

import android.graphics.drawable.AnimationDrawable
import android.view.View
import android.widget.Button
import android.widget.ImageView

class LoadingProcess(private val loading: ImageView, private val button: Button?) {
    private var animation: AnimationDrawable

    // Class begins taking loading image visibility off and setting it's drawable
    init {
        loading.visibility = View.GONE
        animation = loading.drawable as AnimationDrawable
    }

    // Function hide button, show animation and start it
    fun startLoading() {
        // Show and start animation
        loading.visibility = View.VISIBLE
        button?.visibility = View.GONE

        animation.start()
    }

    // Function to hide animation, stop it and show button again
    fun stopLoading() {
        button?.visibility = View.VISIBLE
        loading.visibility = View.GONE

        animation.stop()
    }
}