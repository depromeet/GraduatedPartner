package com.dmp.graduatedpartner.presentation.graduatedrequirements.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmp.graduatedpartner.model.GradRequ
import com.dmp.graduatedpartner.model.GraduateList
import com.dmp.graduatedpartner.presentation.graduatedrequirements.GradRequViewHolder
import com.dmp.graduatedpartner.presentation.graduatedrequirements.GradTitleViewHolder

class GraduatedAddAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var array: MutableList<Item> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        Item.Incomplete.VIEW_TYPE -> GradRequViewHolder(parent)
        Item.Complete.VIEW_TYPE -> GradRequViewHolder(parent)
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
            add(Item.CompleteTitle())
            addAll(completes)
        }
        notifyDataSetChanged()
    }

    sealed class Item(val viewType: Int) {
        companion object {
            private var incrementalViewType = 1
                get() = field++
        }

        data class Incomplete(
            val data: GradRequ
        ) : Item(VIEW_TYPE) {
            companion object {
                val VIEW_TYPE = incrementalViewType
            }
        }

        class CompleteTitle : Item(VIEW_TYPE) {
            companion object {
                val VIEW_TYPE = incrementalViewType
            }
        }

        data class Complete(
            val data: GradRequ
        ) : Item(VIEW_TYPE) {
            companion object {
                val VIEW_TYPE = incrementalViewType
            }
        }

    }
}