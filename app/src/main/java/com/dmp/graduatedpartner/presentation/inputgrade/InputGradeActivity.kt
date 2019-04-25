package com.dmp.graduatedpartner.presentation.inputgrade

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivityInputGradeBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import com.dmp.graduatedpartner.presentation.inputgrade.adapter.InputGradeViewPagerAdapter
import kotlinx.android.synthetic.main.activity_input_grade.*
import org.koin.android.viewmodel.ext.android.viewModel

class InputGradeActivity : BaseActivity() {
    private val viewModel: InputGradeViewModel by viewModel()

    private val binding by lazy{
        DataBindingUtil.setContentView<ActivityInputGradeBinding>(this, R.layout.activity_input_grade)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        val viewPagerAdapter = InputGradeViewPagerAdapter(this@InputGradeActivity, supportFragmentManager)
        grade_viewpager.adapter = viewPagerAdapter
        grade_viewpager.offscreenPageLimit = 8

        semaster_tab.setViewPager(grade_viewpager)

    }
}
