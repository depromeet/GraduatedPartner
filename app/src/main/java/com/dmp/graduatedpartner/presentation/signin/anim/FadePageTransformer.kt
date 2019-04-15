package com.dmp.graduatedpartner.presentation.signin.anim

import android.view.View
import androidx.viewpager.widget.ViewPager

class FadePageTransformer : ViewPager.PageTransformer {
    override fun transformPage(view: View, position: Float) {
        view.translationX = view.width * -position
        if (position <= -1.0F || position >= 1.0F) {
            view.alpha = 0.0F
        } else if (position == 0.0F) {
            view.alpha = 1.0F
        } else {
            view.alpha = 1.0F - Math.abs(position)
        }
    }
}
