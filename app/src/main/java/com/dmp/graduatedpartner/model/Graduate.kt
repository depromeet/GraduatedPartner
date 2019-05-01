package com.dmp.graduatedpartner.model

data class Graduate(val type: Type? = null, val title: String? = null, val isComplete: Boolean = false) {
    enum class Type {
        CULTURE, CERTIFICATE, LANGUAGE, ETC
    }
}