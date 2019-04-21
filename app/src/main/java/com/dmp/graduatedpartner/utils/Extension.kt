package com.dmp.graduatedpartner.utils

import android.text.Editable

fun Editable?.emptyToNull(): Editable? {
    return if (this.toString() == "") {
        null
    } else {
        this
    }
}