package com.dmp.graduatedpartner.presentation.editgrade

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivityEditGradeBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_edit_grade.*
import org.koin.android.viewmodel.ext.android.viewModel

class EditGradeActivity : BaseActivity() {
    private val viewModel: EditGradeViewModel by viewModel()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityEditGradeBinding>(this, R.layout.activity_edit_grade)
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

        btn_back.setOnClickListener {
            finish()
        }
    }
}