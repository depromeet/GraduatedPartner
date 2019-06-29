package com.dmp.graduatedpartner.presentation.grade

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivityGradeBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_grade.*
import org.koin.android.viewmodel.ext.android.viewModel

class GradeActivity : BaseActivity() {
    private val viewModel: GradeViewModel by viewModel()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityGradeBinding>(this, R.layout.activity_grade)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        btn_grade_save.setOnClickListener {
            viewModel.saveGrade(
                et_grade_major_current.text.toString().toInt(),
                et_grade_major_total.text.toString().toInt(),
                et_grade_culture_current.text.toString().toInt(),
                et_grade_culture_total.text.toString().toInt(),
                et_grade_etc_current.text.toString().toInt(),
                et_grade_etc_total.text.toString().toInt()
            )
            finish()
        }

        toolbar_update_grade.setNavigationOnClickListener {
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, GradeActivity::class.java)
    }
}