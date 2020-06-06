package com.dmp.graduatedpartner.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.dmp.graduatedpartner.R
import kotlinx.android.synthetic.main.view_grade_point_edit.view.*


class GradePointEditTextView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_grade_point_edit, this, true)
        setOnClickListener {
            grade_point_edit.requestFocus()
        }
    }

}