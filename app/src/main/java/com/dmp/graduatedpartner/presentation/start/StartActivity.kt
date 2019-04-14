package com.dmp.graduatedpartner.presentation.start

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import com.dmp.graduatedpartner.databinding.ActivityStartBinding
import org.koin.android.viewmodel.ext.android.viewModel

class StartActivity : BaseActivity() {
    private val viewmodel: StartViewModel by viewModel()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityStartBinding>(this, R.layout.activity_start)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewmodel
    }
}
