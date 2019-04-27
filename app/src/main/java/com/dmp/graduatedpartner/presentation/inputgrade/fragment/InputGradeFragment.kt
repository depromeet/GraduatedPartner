package com.dmp.graduatedpartner.presentation.inputgrade.fragment

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.dmp.graduatedpartner.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmp.graduatedpartner.Application.Companion.appContext
import com.dmp.graduatedpartner.model.UserGrade
import com.dmp.graduatedpartner.presentation.inputgrade.adapter.InputGradeListAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_input_grade.*
import androidx.core.view.ViewCompat.setNestedScrollingEnabled
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView



class InputGradeFragment : Fragment(){

    private lateinit var adapter : InputGradeListAdapter
    var userGradeList = ArrayList<UserGrade>()
    var listFlag = 0
    var isFirst = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_input_grade, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        loadData()

        //init
        if(listFlag == 0 && isFirst == 0){
            listFlag = 1
            isFirst = 1
            userGradeList.add(UserGrade(0,null,0,4.5))
            userGradeList.add(UserGrade(0,null,0,4.5))
            userGradeList.add(UserGrade(0,null,0,4.5))
            userGradeList.add(UserGrade(0,null,0,4.5))
        }

        grade_recyclerview.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(false)
            isNestedScrollingEnabled = false
            grade_recyclerview.layoutManager = layoutManager
            adapter = InputGradeListAdapter(context, userGradeList)
            Log.d("@@@@firstSize", ""+ userGradeList.size)
        }

        add_grade_btn.setOnClickListener{
            userGradeList.add(UserGrade(0,null,0,4.5))
            Log.d("@@@@laterSize", ""+ userGradeList.size)


            refreshFragment()
        }
    }

    //SharedPreference
    fun saveData(userGradeList : ArrayList<UserGrade>) {
        var sharedPreferences = appContext?.getSharedPreferences("gradelist",MODE_PRIVATE)
        var editor : SharedPreferences.Editor = sharedPreferences!!.edit()
        var gson = Gson()
        var json = gson.toJson(userGradeList)
        editor.putString("user grade list", json)
        editor.apply()
    }

    fun loadData() {
        var sharedPreferences = appContext?.getSharedPreferences("gradelist",MODE_PRIVATE)
        var gson = Gson()
        var json = sharedPreferences?.getString("user grade list", null)

        if(json == null)
            listFlag = 0
        else{
            userGradeList = gson.fromJson(json,null)
            listFlag = 1
        }
    }

    fun refreshFragment(){
        var frg: FragmentTransaction? = null
        frg = fragmentManager?.beginTransaction()
        frg?.detach(this)?.attach(this)?.commit()
    }

    companion object {
        fun newInstance(): InputGradeFragment = InputGradeFragment()
    }

}