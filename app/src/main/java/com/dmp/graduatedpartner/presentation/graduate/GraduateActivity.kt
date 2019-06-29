package com.dmp.graduatedpartner.presentation.graduate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivityGraduateBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class GraduateActivity : BaseActivity() {
    private val viewModel: GraduateViewModel by viewModel()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityGraduateBinding>(this, R.layout.activity_graduate)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }

    companion object{
        fun newIntent(context: Context) = Intent(context, GraduateActivity::class.java)
    }
}