package com.dmp.graduatedpartner.model

data class Graduate(val score: Score?) {
    enum class Score {
        APLUS, A, BPLUS, B, CPLUS, C, DPLUS, D, F
    }
}