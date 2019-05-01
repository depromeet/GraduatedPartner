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
    private val helper = ThemedSpinnerAdapter.Helper(context)

    override fun getCount() = 5

    override fun getItem(position: Int) = position + 2

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: TextView = (convertView ?: LayoutInflater.from(context).inflate(
            R.layout.item_signin_type,
            parent,
            false
        )) as TextView
        view.text = "${position + 2}년제"
        return view
    }

    override fun getDropDownViewTheme(): Resources.Theme? = helper.dropDownViewTheme

    override fun setDropDownViewTheme(theme: Resources.Theme?) {
        helper.dropDownViewTheme = theme
    }
}