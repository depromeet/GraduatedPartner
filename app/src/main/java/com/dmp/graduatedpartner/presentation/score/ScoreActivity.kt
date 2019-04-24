package com.dmp.graduatedpartner.presentation.score

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivityScoreBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import com.dmp.graduatedpartner.presentation.editgrade.EditGradeActivity
import com.dmp.graduatedpartner.presentation.start.StartActivity
import kotlinx.android.synthetic.main.activity_score.*
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

        btn_score_edit1.setOnClickListener {
            startActivityForResult(
                Intent(
                    this@ScoreActivity,
                    EditGradeActivity::class.java
                ), EDIT_GRADE_INTENT
            )
        }
        viewModel.getUserInfoTwice()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.getUserInfoTwice()
    }

    companion object {
        const val EDIT_GRADE_INTENT = 1
    }
}