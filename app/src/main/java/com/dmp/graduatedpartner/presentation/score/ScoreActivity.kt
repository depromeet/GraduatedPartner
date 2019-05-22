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
import com.dmp.graduatedpartner.presentation.editgrade.EditGradeActivity
import com.dmp.graduatedpartner.presentation.graduatedrequirements.GraduatedRequirementsActivity
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

        tv_score_graduate_detail_title.setOnClickListener {
            startActivity(Intent(
                    this@ScoreActivity,
                    GraduatedRequirementsActivity::class.java
            ))
        }

        viewModel.getUserInfoTwice()

        val guideDialog = Dialog(this)
        guideDialog.setContentView(R.layout.dialog_score_guide)
        guideDialog.findViewById<TextView>(R.id.tv_score_guide_btn).setOnClickListener {
            guideDialog.dismiss()
        }
        guideDialog.create()
        guideDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        guideDialog.window?.attributes?.width = WindowManager.LayoutParams.MATCH_PARENT
        guideDialog.window?.attributes?.height = WindowManager.LayoutParams.MATCH_PARENT
        guideDialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.getUserInfoTwice()
    }

    companion object {
        const val EDIT_GRADE_INTENT = 1
    }
}