package com.dmp.graduatedpartner.presentation.score

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivityScoreBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ScoreActivity : BaseActivity() {
    private val viewModel: ScoreViewModel by viewModel()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityScoreBinding>(this, R.layout.activity_score)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}