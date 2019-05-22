package com.dmp.graduatedpartner.utils

import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun Editable?.emptyToNull(): Editable? {
    return if (this.toString() == "") {
        null
    } else {
        this
    }
}

fun ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean = true): View {
    return LayoutInflater.from(context).inflate(resource, this, attachToRoot)!!
}