package com.dmp.graduatedpartner.presentation.signin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.dmp.graduatedpartner.R

class SignInViewPagerAdapter(private val context: Context) : PagerAdapter() {
    override fun isViewFromObject(view: View, viewItem: Any): Boolean = (view == viewItem)

    override fun getCount() = signInGuideList.size

    override fun getItemPosition(viewItem: Any): Int = POSITION_NONE

    override fun instantiateItem(container: ViewGroup, position: Int): View =
        LayoutInflater.from(context).inflate(signInGuideList[position], container, false).apply {
            container.addView(this)
        }

    override fun destroyItem(container: ViewGroup, position: Int, viewItem: Any) {
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