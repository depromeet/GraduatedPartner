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

class GraduateSpinnerAdapter(private val context: Context) : BaseAdapter(), ThemedSpinnerAdapter {
    private val helper = ThemedSpinnerAdapter.Helper(context)
    private val itemList = context.resources.getStringArray(R.array.graduated_subject_type)
    var previousSelectedItem = 4

    fun getAndSetPreviousSelectedItem(nowItem: Int): Int {
        val result = previousSelectedItem
        previousSelectedItem = nowItem
        return result
    }

    override fun getCount() = 4

    override fun getItem(position: Int) = itemList[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: TextView = (convertView ?: LayoutInflater.from(context).inflate(
                R.layout.item_spinner,
                parent,
                false
        )) as TextView
        view.text = itemList[position]
        view.hint = "선택"
        return view
    }

    override fun getDropDownViewTheme(): Resources.Theme? = helper.dropDownViewTheme

    override fun setDropDownViewTheme(theme: Resources.Theme?) {
        helper.dropDownViewTheme = theme
    }
}