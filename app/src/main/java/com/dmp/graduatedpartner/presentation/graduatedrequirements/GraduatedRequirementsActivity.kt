package com.dmp.graduatedpartner.presentation.graduatedrequirements

import android.os.Bundle
import androidx.core.view.isVisible
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.const.GRADUATE_LIST_KEY
import com.dmp.graduatedpartner.datasource.local.GraduateListDataSource
import com.dmp.graduatedpartner.model.GradRequ
import com.dmp.graduatedpartner.model.GraduateList
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import com.dmp.graduatedpartner.presentation.graduatedrequirements.adapter.GraduatedAddAdapter
import com.dmp.graduatedpartner.presentation.graduatedrequirements.adapter.GraduatedDelAdapter
import com.dmp.graduatedpartner.repository.GraduateListRepository
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_graduated_requirements.*

class GraduatedRequirementsActivity : BaseActivity() {

    companion object {
        private const val MODE_ADD = 0
        private const val MODE_DEL = 1
    }

    private var disposable: Disposable? = null
    private lateinit var graduateList: GraduateList
    private val addAdapter by lazy { GraduatedAddAdapter() }
    private val delAdapter by lazy { GraduatedDelAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graduated_requirements)
        initView()
    }

    private fun initView() {
        changeMode(MODE_ADD)
        graduated_add_btn.setOnClickListener {
            if (!it.isSelected) {
                changeMode(MODE_ADD)
            }
            GraduatedRequirementsAddDialog().apply {
                callback = object : GraduatedRequirementsAddDialog.Callback {
                    override fun returnGraduated(data: GradRequ) {
                        addGraduate(data)
                        getGraduateList(MODE_ADD)
                    }
                }
                show(supportFragmentManager, "addDialog")
            }
        }
        graduated_delete_btn.setOnClickListener {
            if (!it.isSelected) {
                changeMode(MODE_DEL)
            }
        }
        graduated_item_delete_btn.setOnClickListener {
            deleteGraduate(delAdapter.getDeleteContents())
            getGraduateList(MODE_DEL)
        }
        graduated_back_space.setOnClickListener {
            finish()
        }
    }

    private fun changeMode(mode: Int) {
        if (mode == MODE_ADD) {
            graduated_recycler.adapter = addAdapter
            graduated_add_btn.isSelected = true
            graduated_delete_btn.isSelected = false
            graduated_item_delete_btn.isVisible = false
        } else if (mode == MODE_DEL) {
            graduated_recycler.adapter = delAdapter
            graduated_add_btn.isSelected = false
            graduated_delete_btn.isSelected = true
            graduated_item_delete_btn.isVisible = true
        }
        getGraduateList(mode)
    }

    private fun deleteGraduate(deleteContents: List<Int>) {
        val deleteList = graduateList.list.toMutableList()
        deleteContents.forEach {
            deleteList.removeAt(it)
        }
        GraduateListRepository(GraduateListDataSource()).put(GRADUATE_LIST_KEY, GraduateList(deleteList.toList()))
    }

    private fun addGraduate(data: GradRequ) {
        val deleteList = graduateList.list.toMutableList()
        deleteList.add(data)
        GraduateListRepository(GraduateListDataSource()).put(GRADUATE_LIST_KEY, GraduateList(deleteList.toList()))
    }

    private fun getGraduateList(mode: Int) {
        disposable = GraduateListRepository(GraduateListDataSource()).get(GRADUATE_LIST_KEY).subscribe({
            graduateList = it
            if (mode == MODE_ADD) {
                addAdapter.setData(it)
            } else if (mode == MODE_DEL) {
                delAdapter.setData(it)
            }
        }, {
            it.printStackTrace()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }

}