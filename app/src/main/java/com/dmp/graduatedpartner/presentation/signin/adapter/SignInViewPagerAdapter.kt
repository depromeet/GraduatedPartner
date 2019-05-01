package com.dmp.graduatedpartner.presentation.signin.adapter

import android.content.Context
import android.content.res.Resources
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.widget.ThemedSpinnerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.model.Graduate
import kotlinx.android.synthetic.main.item_signin_form1.view.*
import kotlinx.android.synthetic.main.item_signin_form2.view.*

class SignInViewPagerAdapter(private val context: Context) : PagerAdapter() {
    private val views = mutableMapOf<Int, View>()
    private val graduateViews = ArrayList<View>()
    private val graduateRadioViews = ArrayList<View>()

    fun getView(position: Int) = views[position]

    fun getGraduateList(): List<Graduate> {
        val graduateList = ArrayList<Graduate>()
        for (view in graduateRadioViews) {
            graduateList.add(
                Graduate(
                    when (view.findViewById<TextView>(R.id.edittext_signin3_type).text.toString()) {
                        "교양필수" -> {
                            Graduate.Type.CULTURE
                        }
                        "자격증" -> {
                            Graduate.Type.CERTIFICATE
                        }
                        "어학점수" -> {
                            Graduate.Type.LANGUAGE
                        }
                        else -> {
                            Graduate.Type.ETC
                        }
                    },
                    view.findViewById<TextView>(R.id.edittext_signin3_content).text.toString(),
                    view.findViewById<CheckBox>(R.id.radio_signin3_select).isChecked
                )
            )
        }
        return graduateList
    }

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
            }
        }

    private fun addGraduateView(container: ViewGroup): View {
        graduateViews.add(
            LayoutInflater.from(context).inflate(
                R.layout.item_signin_graduate_input_form,
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

    private fun addGraduateRadioView(container: ViewGroup): View {
        graduateRadioViews.add(
            LayoutInflater.from(context).inflate(
                R.layout.item_signin_graduate_select_form,
                container,
                false
            ).apply {

            }
        )
        return graduateRadioViews.last()
    }

    override fun destroyItem(container: ViewGroup, position: Int, viewItem: Any) {
        views.remove(position)
        container.removeView(viewItem as View)
    }

    class GraduateSpinnerAdapter(private val context: Context) : BaseAdapter(), ThemedSpinnerAdapter {
        private val helper = ThemedSpinnerAdapter.Helper(context)
        private val itemList = listOf("교양필수", "자격증", "어학점수", "기타", "")
        var previousSelectedItem = 4

        fun getAndSetPreviousSelectedItem(nowItem: Int): Int {
            val result = previousSelectedItem
            previousSelectedItem = nowItem
            return result
        }

        override fun getCount() = 4

        override fun getItem(position: Int) = itemList[position]

        override fun getItemId(position: Int) = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view: TextView = (convertView ?: LayoutInflater.from(context).inflate(
                R.layout.item_signin_type,
                parent,
                false
            )) as TextView
            view.text = itemList[position]
            view.hint = "선택"
            return view
        }

        override fun getDropDownViewTheme(): Resources.Theme? = helper.dropDownViewTheme

        override fun setDropDownViewTheme(theme: Resources.Theme?) {
            helper.dropDownViewTheme = theme
        }
    }

    companion object {
        val signInGuideList = listOf(
            R.layout.item_signin_form1,
            R.layout.item_signin_form2,
            R.layout.item_signin_form3
        )
    }
}