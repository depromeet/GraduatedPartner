package com.dmp.graduatedpartner.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.pm.ActivityInfo

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}