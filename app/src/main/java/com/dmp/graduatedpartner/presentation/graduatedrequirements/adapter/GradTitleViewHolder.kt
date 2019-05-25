package com.dmp.graduatedpartner.presentation.graduatedrequirements.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.presentation.graduatedrequirements.adapter.GraduatedAddAdapter
import com.dmp.graduatedpartner.utils.inflate
import kotlinx.android.extensions.LayoutContainer

class GradTitleViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    constructor(parent: ViewGroup) : this(
        parent.inflate(R.layout.item_graduated_requirements_title, false)
    )
}