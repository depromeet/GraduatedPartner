package com.dmp.graduatedpartner.presentation.signin.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.widget.ThemedSpinnerAdapter
import com.dmp.graduatedpartner.R

class CollegeTypeAdapter(private val context: Context) : BaseAdapter(), ThemedSpinnerAdapter {
    private val items = listOf(CollegeKind.TWO, CollegeKind.THREE, CollegeKind.FOUR, CollegeKind.FIVE, CollegeKind.SIX)
    private val helper = ThemedSpinnerAdapter.Helper(context)

    override fun getCount() = items.size

    override fun getItem(position: Int) = items[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: TextView = (convertView ?: LayoutInflater.from(context).inflate(
            R.layout.item_spinner,
            parent,
            false
        )) as TextView
        view.text = enumToString(items[position])
        return view
    }

    override fun getDropDownViewTheme(): Resources.Theme? = helper.dropDownViewTheme

    override fun setDropDownViewTheme(theme: Resources.Theme?) {
        helper.dropDownViewTheme = theme
    }
    //fixme
    private fun enumToString(collegeKind: CollegeKind) = when (collegeKind) {
        CollegeKind.TWO -> "2년제"
        CollegeKind.THREE -> "3년제"
        CollegeKind.FOUR -> "4년제"
        CollegeKind.FIVE -> "5년제"
        CollegeKind.SIX -> "6년제"
    }

    enum class CollegeKind {
        TWO, THREE, FOUR, FIVE, SIX
    }
}