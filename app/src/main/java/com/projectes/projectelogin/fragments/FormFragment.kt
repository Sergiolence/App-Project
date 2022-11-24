package com.projectes.projectelogin.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.projectes.projectelogin.Clase
import com.projectes.projectelogin.MainActivity
import com.projectes.projectelogin.R
import com.projectes.projectelogin.db.DBHelper

class FormFragment(dbHelper: DBHelper) : Fragment() {
    var dbHelper = dbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View =  inflater.inflate(R.layout.fragment_form, container, false);

        var txtTitol: EditText = view.findViewById(R.id.titol_form)
        var txtSubtitol: EditText = view.findViewById(R.id.subtitol_form)
        var txtDescripcio: EditText = view.findViewById(R.id.descripcio_form)
        var btnDescripcio: Button = view.findViewById(R.id.button_form)

        btnDescripcio.setOnClickListener {
            dbHelper.insertLlibre(Clase(txtTitol.text.toString(), txtSubtitol.text.toString(), txtDescripcio.text.toString()));
        }

        return view;

    }
    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }
}