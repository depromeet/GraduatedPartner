package com.dmp.graduatedpartner.presentation.start

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import com.dmp.graduatedpartner.databinding.ActivityStartBinding
import com.dmp.graduatedpartner.presentation.score.ScoreActivity
import com.dmp.graduatedpartner.presentation.signin.SignInActivity
import org.koin.android.viewmodel.ext.android.viewModel

class StartActivity : BaseActivity() {
    private val viewModel: StartViewModel by viewModel()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityStartBinding>(this, R.layout.activity_start)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
    }

    fun onClickStartButton(view: View) {
        val nextIntent = Intent(
            this@StartActivity,
            if (viewModel.existedUser) {
                ScoreActivity::class.java
            } else {
                SignInActivity::class.java
            }
        ).addFlags(FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK)
        startActivity(nextIntent)
    }
}
