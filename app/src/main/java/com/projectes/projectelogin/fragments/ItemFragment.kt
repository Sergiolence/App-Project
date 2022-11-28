package com.projectes.projectelogin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projectes.projectelogin.R
import com.projectes.projectelogin.db.DBHelper
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projectes.projectelogin.Clase
import com.projectes.projectelogin.MainActivity
import com.projectes.projectelogin.Recycler.RecyclerViewAdapter

class ItemFragment(clase: Clase): Fragment() {
    var clase = clase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v: View = inflater.inflate(R.layout.item_fragment, container, false)
        val titol: TextView = v.findViewById(R.id.item_titol)
        titol.setText(clase.titol)
        val subtitol:TextView = v.findViewById(R.id.item_subtitol)
        subtitol.setText(clase.subtitol)
        val descripcio:TextView = v.findViewById(R.id.item_descripcio)
        descripcio.setText(clase.descripcio)
        return v
    }
}