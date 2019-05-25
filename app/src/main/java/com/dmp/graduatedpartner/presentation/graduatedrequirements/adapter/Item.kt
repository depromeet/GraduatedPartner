package com.dmp.graduatedpartner.presentation.graduatedrequirements.adapter

import com.dmp.graduatedpartner.model.GradRequ

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