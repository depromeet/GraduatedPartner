package com.dmp.graduatedpartner.model

data class Graduate(val type: Type?, val title: String?, val isComplete: Boolean = false) {
    enum class Type {
        CULTURE, CERTIFICATE, LANGUAGE, ETC
    }
}