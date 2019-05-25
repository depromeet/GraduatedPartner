package com.dmp.graduatedpartner.presentation.graduatedrequirements.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.utils.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_graduated_requirements_choice.*

class GradRequChoiceViewHolder(override val containerView: View, val callback: GraduatedDelAdapter.ContentCallback) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    constructor(parent: ViewGroup, callback: GraduatedDelAdapter.ContentCallback) : this(
            parent.inflate(R.layout.item_graduated_requirements_choice, false), callback
    )

    fun onBind(data: Any) {
        val context = itemView.context
        if (data is Item.Complete) {
            item_gr_sub_txt.text = data.data.type
            item_gr_main_txt.text = data.data.title
            item_gr_choice_bg.setBackgroundColor(context.resources.getColor(R.color.color_14b7ff))
        } else if (data is Item.Incomplete) {
            item_gr_sub_txt.text = data.data.type
            item_gr_main_txt.text = data.data.title
            item_gr_choice_bg.setBackgroundColor(context.resources.getColor(R.color.color_fcde30))
        }
        item_gr_choice_bg.setOnClickListener {
            item_gr_choice.isChecked = !item_gr_choice.isChecked
        }
        item_gr_choice.setOnCheckedChangeListener { _, isChecked ->
            callback.choiceItem(data,isChecked)
        }
    }

}