package com.dmp.graduatedpartner.presentation.score

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivityScoreBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import com.dmp.graduatedpartner.presentation.updategrade.UpdateGradeActivity
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
        bindView()
    }

    private fun bindView() {
        btn_score_edit1.setOnClickListener {
            startActivityForResult(
                Intent(
                    this@ScoreActivity,
                    UpdateGradeActivity::class.java
                ), EDIT_GRADE_INTENT
            )
        }
        viewModel.getUserInfoTwice()

        Dialog(this).apply{
            setContentView(R.layout.dialog_score_guide)
            findViewById<TextView>(R.id.tv_score_guide_btn).setOnClickListener {
                dismiss()
            }
            create()
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.attributes?.width = WindowManager.LayoutParams.MATCH_PARENT
            show()
        }

        viewModel.getSingleGraduateList().subscribeIgnoreError { graduateList ->
            for(graduate in graduateList){

            }
        }.bind()

        btn_score_new_semester.setOnClickListener {
            Dialog(this).apply {
                setContentView(R.layout.dialog_new_semester)
                create()
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                window?.attributes?.width = WindowManager.LayoutParams.MATCH_PARENT
                show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.getUserInfoTwice()
    }

    companion object {
        const val EDIT_GRADE_INTENT = 1
    }
}