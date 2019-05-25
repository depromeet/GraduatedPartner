package com.dmp.graduatedpartner.presentation.graduatedrequirements.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmp.graduatedpartner.model.GraduateList

class GraduatedAddAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var array: MutableList<Item> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        Item.Incomplete.VIEW_TYPE, Item.Complete.VIEW_TYPE -> GradRequViewHolder(parent)
        else -> GradTitleViewHolder(parent)
    }

    override fun getItemCount() = array.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when (holder) {
        is GradRequViewHolder -> holder.onBind(array[position])
        else -> {}
    }

    override fun getItemViewType(position: Int): Int {
        return array[position].viewType
    }


    fun setData(graduateList: GraduateList){
        array.apply {
            clear()
            val incompetents = graduateList.list.filter { !it.isComplete }.map {
                Item.Incomplete(it)
            }
            val completes = graduateList.list.filter { it.isComplete }.map {
                Item.Complete(it)
            }
            addAll(incompetents)
            if (completes.isNotEmpty()) {
                add(Item.CompleteTitle())
                addAll(completes)
            }
        }
        notifyDataSetChanged()
    }
}