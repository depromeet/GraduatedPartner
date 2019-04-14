package com.dmp.graduatedpartner.presentation.bindingadapter

import android.view.View
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods

@BindingMethods(
    BindingMethod(type = View::class, attribute = "enabled", method = "setEnabled")
)
object AndroidBindingAdapter {
}