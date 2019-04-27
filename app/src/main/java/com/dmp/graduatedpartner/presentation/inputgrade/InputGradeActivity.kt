package com.dmp.graduatedpartner.presentation.inputgrade

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivityInputGradeBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import com.dmp.graduatedpartner.presentation.inputgrade.adapter.InputGradeViewPagerAdapter
import com.dmp.graduatedpartner.presentation.score.ScoreActivity
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

        input_grade_backbutton.setOnClickListener{
            val nextIntent = Intent(this, ScoreActivity::class.java)
            startActivity(nextIntent)
            finish()
        }

        all_grade_save_btn.setOnClickListener{
            Toast.makeText(this, "아직 저장이 안되요ㅠㅠ", Toast.LENGTH_SHORT).show()
        }

    }
}
