package com.dmp.graduatedpartner.presentation.signin

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivitySigninBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import com.dmp.graduatedpartner.presentation.signin.anim.FadePageTransformer
import kotlinx.android.synthetic.main.activity_signin.*
import org.koin.android.viewmodel.ext.android.viewModel

class SignInActivity : BaseActivity() {
    private val viewModel: SignInViewModel by viewModel()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivitySigninBinding>(this, R.layout.activity_signin)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initViewPager()
    }

    private fun initViewPager(){
        updateUI(0)
        viewpager_signin.offscreenPageLimit = 3
        viewpager_signin.setPageTransformer(false, FadePageTransformer())
        viewpager_signin.adapter = SignInViewPagerAdapter()
        viewpager_signin.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int) {
                updateUI(position)
                super.onPageSelected(position)
            }
        })
    }

    private fun updateUI(position: Int){

    }
}