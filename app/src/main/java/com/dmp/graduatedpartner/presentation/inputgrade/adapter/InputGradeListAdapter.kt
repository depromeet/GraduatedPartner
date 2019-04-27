package com.dmp.graduatedpartner.presentation.inputgrade.adapter

import android.content.Context
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.dmp.graduatedpartner.R
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatSpinner
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.dmp.graduatedpartner.model.UserGrade
import kotlinx.android.synthetic.main.item_input_grade.view.*

class InputGradeListAdapter(val context : Context, val list : ArrayList<UserGrade>) : RecyclerView.Adapter<InputGradeListAdapter.GradeViewHolder>() {

    private val mTypeSpinnerAdapter
            = ArrayAdapter.createFromResource(context,R.array.subject_type,R.layout.input_grade_custom_spinner)
    private val mGradeSpinnerAdpater
            = ArrayAdapter.createFromResource(context,R.array.grade,R.layout.input_grade_custom_spinner)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GradeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: GradeViewHolder, position: Int) {
        val userGrade: UserGrade = list[position]

        mTypeSpinnerAdapter.setDropDownViewResource(R.layout.input_grade_custom_spinner)
        mGradeSpinnerAdpater.setDropDownViewResource(R.layout.input_grade_custom_spinner)

        holder.mType?.setAdapter(mTypeSpinnerAdapter)
        holder.mGrade?.setAdapter(mGradeSpinnerAdpater)
        holder.bind(userGrade)
    }

    override fun getItemCount(): Int = list.size

    class GradeViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_input_grade, parent, false)) {
        var mType: Spinner? = null
        var mSubject: EditText? = null
        var mGrade: Spinner? = null
        var mScore: EditText? = null

        init {
            mType = itemView.findViewById(R.id.spinner_type)
            mSubject = itemView.findViewById(R.id.edit_subject)
            mGrade = itemView.findViewById(R.id.spinner_grade)
            mScore = itemView.findViewById(R.id.edit_score)

            //spinner
            mType?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {}

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    Log.d("@@@type", ""+ parent?.selectedItem.toString())
                    mType?.setSelection(position)
                }
            }

            mGrade?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {}

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    Log.d("@@@grade", ""+ parent?.selectedItem.toString())
                    mGrade?.setSelection(position)
                }
            }
        }

        fun bind(userGrade: UserGrade) {
            mType?.setSelection(userGrade.type!!)
            mSubject?.setText(userGrade.subject)
            mGrade?.setSelection(userGrade.grade!!)
            mScore?.setText(userGrade.score.toString())
        }
    }

}