package com.dmp.graduatedpartner.presentation.signin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.viewpager.widget.PagerAdapter
import com.dmp.graduatedpartner.R
import kotlinx.android.synthetic.main.item_signin1.view.*

class SignInViewPagerAdapter(private val context: Context) : PagerAdapter() {
    private val views = mutableMapOf<Int, View>()

    fun getView(position: Int) = views[position]

    override fun isViewFromObject(view: View, viewItem: Any): Boolean = (view == viewItem)

    override fun getCount() = signInGuideList.size

    override fun getItemPosition(viewItem: Any): Int = POSITION_NONE

    override fun instantiateItem(container: ViewGroup, position: Int): View =
        LayoutInflater.from(context).inflate(signInGuideList[position], container, false).apply {
            views[position] = this
            container.addView(this)
            when (position) {
                0 -> {
                    spinner_sigin1_school.adapter = CollegeTypeAdapter(context)
                    spinner_sigin1_school.onItemSelectedListener = object : OnItemSelectedListener{
                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                            spinner_sigin1_current_grade.adapter = CurrentGradeAdapter(context, parent?.selectedItem as Int)
                            spinner_sigin1_total_grade.adapter = TotalGradeAdapter(context, parent?.selectedItem as Int)
                        }

                        override fun onNothingSelected(parent: AdapterView<*>?) {

                        }
                    }
                }
            }
        }

    override fun destroyItem(container: ViewGroup, position: Int, viewItem: Any) {
        views.remove(position)
        container.removeView(viewItem as View)
    }

    companion object {
        val signInGuideList = listOf(
            R.layout.item_signin1,
            R.layout.item_signin2,
            R.layout.item_signin3
        )
    }
}