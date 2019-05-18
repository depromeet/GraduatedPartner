//package com.dmp.graduatedpartner.presentation.graduatedrequirements
//
//import android.os.Bundle
//import androidx.databinding.DataBindingUtil
//import com.dmp.graduatedpartner.R
//import com.dmp.graduatedpartner.databinding.ActivityGraduatedRequirementsBinding
//import com.dmp.graduatedpartner.presentation.base.BaseActivity
//import org.koin.android.viewmodel.ext.android.viewModel
//
//class GraduatedRequirementsActivity : BaseActivity() {
//
//    private val viewModel: GraduatedRequirementsViewModel by viewModel()
//
//    private val binding by lazy{
//        DataBindingUtil.setContentView<ActivityGraduatedRequirementsBinding>(this, R.layout.activity_graduated_requirements)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding.vm = viewModel
//        binding.lifecycleOwner = this
//    }
//
//}