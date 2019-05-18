//package com.dmp.graduatedpartner.presentation.graduatedrequirements.adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.dmp.graduatedpartner.R
//import com.dmp.graduatedpartner.databinding.ItmeGraduatedRequirementsIncompleteBinding
//import com.dmp.graduatedpartner.model.Graduate
//import com.dmp.graduatedpartner.presentation.graduatedrequirements.GradRequViewHolder
//
//class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    var array : MutableList<Item> = mutableListOf()
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when(viewType){
//        Item.Incomplete.viewType -> GradRequViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_graduated_requirements_incomplete,parent))
//        Item.Complete.viewType -> GradRequViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_graduated_requirements_incomplete,parent))
//        else -> GradRequViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_graduated_requirements_incomplete,parent))
//    }
//
//    override fun getItemCount() = array.size
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when(holder){
//        is GradRequViewHolder -> holder.onBind(array[position])
//        else -> {}
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return array[position].viewType
//    }
//
//    data class Item(val viewType: Int){
//        data class Incomplete(
//            val data:Graduate
//        ){
//            companion object {
//                var viewType = 0
//                fun instance(data:Graduate, viewType: Int):Incomplete {
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
//            val data:Graduate
//        ){
//            companion object {
//                var viewType = 0
//                fun instance(data:Graduate, viewType: Int):Incomplete {
//                    this.viewType = viewType
//                    Item(viewType)
//                    return Incomplete(data)
//                }
//            }
//        }
//    }
//}