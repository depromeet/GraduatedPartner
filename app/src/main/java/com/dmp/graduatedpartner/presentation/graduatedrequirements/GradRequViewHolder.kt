package com.dmp.graduatedpartner.presentation.graduatedrequirements

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.presentation.graduatedrequirements.adapter.GraduatedAddAdapter
import com.dmp.graduatedpartner.utils.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_graduated_requirements_incomplete.*

class GradRequViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    constructor(parent: ViewGroup) : this(
        parent.inflate(R.layout.item_graduated_requirements_incomplete, false)
    )

    fun onBind(data: Any) {
        val context = itemView.context
        if (data is GraduatedAddAdapter.Item.Complete) {
            item_gr_sub_txt.text = data.data.type
            item_gr_main_txt.text = data.data.title
            item_gr_left_bg.setBackgroundColor(context.resources.getColor(R.color.color_14b7ff))
        }else if (data is GraduatedAddAdapter.Item.Incomplete){
            item_gr_sub_txt.text = data.data.type
            item_gr_main_txt.text = data.data.title
            item_gr_left_bg.setBackgroundColor(context.resources.getColor(R.color.color_fcde30))
        }
    }

}