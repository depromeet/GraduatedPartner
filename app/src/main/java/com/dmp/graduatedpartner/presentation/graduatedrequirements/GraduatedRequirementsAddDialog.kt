package com.dmp.graduatedpartner.presentation.graduatedrequirements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.model.GradRequ
import com.dmp.graduatedpartner.presentation.signin.adapter.GraduateSpinnerAdapter
import kotlinx.android.synthetic.main.dialog_graduated_add.*

class GraduatedRequirementsAddDialog : DialogFragment() {


    interface Callback {
        fun returnGraduated(data: GradRequ)
    }

    var callback: Callback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.Translucent)
        
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.dialog_graduated_add, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        graduated_add_spinner.apply {
            val graduateSpinnerAdapter = GraduateSpinnerAdapter(context)
            adapter = graduateSpinnerAdapter
        }
        graduated_add_btn.setOnClickListener {
            callback?.returnGraduated(
                GradRequ(
                    graduated_add_spinner.selectedItem.toString(),
                    graduated_add_edit.text.toString()
                )
            )
            dismiss()
        }
    }
}