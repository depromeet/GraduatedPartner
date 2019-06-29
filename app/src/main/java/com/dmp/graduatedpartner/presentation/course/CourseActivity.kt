package com.dmp.graduatedpartner.presentation.course

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivityCourseBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class CourseActivity : BaseActivity() {
    private val viewModel: CourseViewModel by viewModel()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityCourseBinding>(this, R.layout.activity_course)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this
    }

    companion object{
        fun newIntent(context: Context) = Intent(context, CourseActivity::class.java)
    }
}