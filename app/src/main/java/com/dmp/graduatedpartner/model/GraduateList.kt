package com.dmp.graduatedpartner.model

class GraduateList(val list: List<Graduate>){
    data class Graduate(val type: Type?, val title: String?, val isComplete: Boolean = false){
        enum class Type{
            CULTURE, CERTIFICATE, LANGUAGE, ETC
        }
    }
}