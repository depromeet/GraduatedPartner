package com.dmp.graduatedpartner.presentation.signin.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.viewpager.widget.PagerAdapter
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.model.GradRequ
import kotlinx.android.synthetic.main.item_signin1.view.*
import kotlinx.android.synthetic.main.item_signin2.view.*

class SignInViewPagerAdapter(private val context: Context) : PagerAdapter() {
    private val views = mutableMapOf<Int, View>()
    private val graduateViews = ArrayList<View>()
    private val graduateRadioViews = ArrayList<View>()

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
                        spinner_sigin1_school.onItemSelectedListener = object : OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                spinner_sigin1_current_grade.adapter =
                                        CurrentGradeAdapter(context, parent?.selectedItem as Int)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                            }
                        }
                    }

                    1 -> {
                        linear_signin2_require_list.addView(addGraduateView(container))
                    }

                    2 -> {

                    }
                }
            }

    //fixme : findviewById를 너무 남발함...
    private fun addGraduateView(container: ViewGroup): View {
        graduateViews.add(
                LayoutInflater.from(context).inflate(
                        R.layout.item_signin2_graduate_input,
                        container,
                        false
                ).let { parentView ->
                    val index = graduateViews.size
                    parentView.findViewById<Spinner>(R.id.spinner_signin2_type).apply {
                        val graduateSpinnerAdapter = GraduateSpinnerAdapter(context)
                        adapter = graduateSpinnerAdapter
                        setSelection(4)
                        onItemSelectedListener = object : OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                if (graduateSpinnerAdapter.getAndSetPreviousSelectedItem(position) == 4 && position != 4) {
                                    views[1]?.findViewById<LinearLayout>(R.id.linear_signin2_require_list)
                                            ?.addView(addGraduateView(container))
                                    parentView.findViewById<EditText>(R.id.edittext_signin2_content).isEnabled = true
                                    views[2]?.findViewById<LinearLayout>(R.id.linear_signin3_require_list)
                                            ?.addView(addGraduateRadioView(container))
                                }
                                if (graduateSpinnerAdapter.previousSelectedItem != 4 && position != 4) {
                                    graduateRadioViews[index].findViewById<TextView>(R.id.edittext_signin3_type).text =
                                            selectedItem as String
                                }
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {}
                        }
                    }

                    parentView.findViewById<EditText>(R.id.edittext_signin2_content)
                            .addTextChangedListener(object : TextWatcher {
                                override fun afterTextChanged(s: Editable?) {

                                }

                                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                                }

                                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                                    graduateRadioViews[index].findViewById<TextView>(R.id.edittext_signin3_content).text =
                                            s.toString()
                                }
                            })

                    parentView
                }
        )
        return graduateViews.last()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun addGraduateRadioView(container: ViewGroup): View {
        graduateRadioViews.add(
                LayoutInflater.from(context).inflate(
                        R.layout.item_signin3_graduate_select,
                        container,
                        false
                ).apply {

                }
        )
        return graduateRadioViews.last()
    }

    fun getGraduateData(): List<GradRequ> {
        val dataList = arrayListOf<GradRequ>()
        for (graduateRadioView in graduateRadioViews) {
            val isComplet = graduateRadioView.findViewById<RadioButton>(R.id.radio_signin3_select).isChecked
            val graduateType = graduateRadioView.findViewById<TextView>(R.id.edittext_signin3_type).text.toString()
            val graduateTitle = graduateRadioView.findViewById<TextView>(R.id.edittext_signin3_content).text.toString()
            dataList.add(GradRequ(graduateType, graduateTitle, isComplet))
        }
        return dataList
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