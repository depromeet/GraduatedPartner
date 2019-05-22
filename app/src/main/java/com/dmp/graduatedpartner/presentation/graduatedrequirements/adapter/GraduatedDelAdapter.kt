package com.dmp.graduatedpartner.presentation.graduatedrequirements.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.model.GradRequ
import com.dmp.graduatedpartner.presentation.graduatedrequirements.GradRequViewHolder

class GraduatedDelAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var array: MutableList<Item> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        Item.Incomplete.VIEW_TYPE -> GradRequViewHolder(parent)
        Item.Complete.VIEW_TYPE -> GradRequViewHolder(parent)
        else -> GradRequViewHolder(parent)
    }

    override fun getItemCount() = array.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when (holder) {
        is GradRequViewHolder -> holder.onBind(array[position])
        else -> {
        }
    }

    override fun getItemViewType(position: Int): Int {
        return array[position].viewType
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


//    data class Item(val viewType: Int) {
//        data class Incomplete(
//            val data: GradRequ
//        ) {
//            companion object {
//                var viewType = 0
//                fun instance(data: GradRequ, viewType: Int): Incomplete {
//                    this.viewType = viewType
//                    Item(viewType)
//                    return Incomplete(data)
//                }
//            }
//        }
//
//        data class CompleteTitle(
//            val viewType: Int
//        )
//
//        data class Complete(
//            val data: GradRequ
//        ) {
//            companion object {
//                var viewType = 0
//                fun instance(data: GradRequ, viewType: Int): Incomplete {
//                    this.viewType = viewType
//                    Item(viewType)
//                    return Incomplete(data)
//                }
//            }
//        }
//    }
}