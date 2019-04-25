package com.dmp.graduatedpartner.presentation.inputgrade.adapter

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.dmp.graduatedpartner.presentation.inputgrade.fragment.InputGradeFragment
import com.dmp.graduatedpartner.presentation.inputgrade.fragment.InputGradeFragment2

class InputGradeViewPagerAdapter(private val context: Context, fm:FragmentManager) : FragmentStatePagerAdapter(fm){

    val pageTitle =
        arrayOf("1학년 1학기", "1학년 2학기", "2학년 1학기", "2학년 2학기", "3학년 1학기", "3학년 2학기", "4학년 1학기", "4학년 2학기")

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return InputGradeFragment()
            1 -> return InputGradeFragment2()
            2 -> return InputGradeFragment2()
            3 -> return InputGradeFragment2()
            4 -> return InputGradeFragment2()
            5 -> return InputGradeFragment2()
            6 -> return InputGradeFragment2()
            7 -> return InputGradeFragment2()
        }
        return null
    }

    override fun getCount(): Int = 8

    override fun getPageTitle(position: Int): CharSequence? {
        return pageTitle[position]
    }
}