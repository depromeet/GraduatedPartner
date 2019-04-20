package com.dmp.graduatedpartner.presentation.signin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivitySigninBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import com.dmp.graduatedpartner.presentation.signin.adapter.SignInViewPagerAdapter
import com.dmp.graduatedpartner.presentation.start.StartActivity
import kotlinx.android.synthetic.main.activity_signin.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SignInActivity : BaseActivity() {
    private val viewModel: SignInViewModel by viewModel()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivitySigninBinding>(this, R.layout.activity_signin)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        bindView()
    }

    private fun bindView() {
        viewpager_signin.adapter = SignInViewPagerAdapter(this@SignInActivity)
        viewpager_signin.offscreenPageLimit = viewpager_signin.adapter?.count ?: 0
        //viewPagerAdapter.getView(0)?.findViewById<TextView>(R.id.text_signin1_title)?.setText("아아")
    }

    fun onPressBackButton(view: View) {
        val nextIntent = Intent(
            this@SignInActivity,
            StartActivity::class.java
        ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(nextIntent)
    }
}