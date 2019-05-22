package com.dmp.graduatedpartner.presentation.graduatedrequirements

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.const.GRADUATE_LIST_KEY
import com.dmp.graduatedpartner.databinding.ActivityGraduatedRequirementsBinding
import com.dmp.graduatedpartner.datasource.local.GraduateListDataSource
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import com.dmp.graduatedpartner.presentation.graduatedrequirements.adapter.GraduatedAddAdapter
import com.dmp.graduatedpartner.repository.GraduateListRepository
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_graduated_requirements.*
import org.koin.android.viewmodel.ext.android.viewModel

class GraduatedRequirementsActivity : BaseActivity() {

    private val viewModel: GraduatedRequirementsViewModel by viewModel()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityGraduatedRequirementsBinding>(
                this,
                R.layout.activity_graduated_requirements
        )
    }

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        val adapter = GraduatedAddAdapter().apply {
            graduated_recycler.adapter = this
        }

        disposable = GraduateListRepository(GraduateListDataSource()).get(GRADUATE_LIST_KEY).subscribe({
            adapter.setData(it)
        }, {
            it.printStackTrace()
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }

}