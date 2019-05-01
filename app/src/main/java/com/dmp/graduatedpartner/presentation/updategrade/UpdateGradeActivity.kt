package com.dmp.graduatedpartner.presentation.updategrade

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivityUpdateGradeBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_update_grade.*
import org.koin.android.viewmodel.ext.android.viewModel

class UpdateGradeActivity : BaseActivity() {
    private val viewModel: UpdateGradeViewModel by viewModel()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityUpdateGradeBinding>(this, R.layout.activity_update_grade)
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

        text_editgrade_back.setOnClickListener {
            finish()
        }
    }
}