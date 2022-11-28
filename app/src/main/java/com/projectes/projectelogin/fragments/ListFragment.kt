package com.projectes.projectelogin.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.projectes.projectelogin.Clase
import com.projectes.projectelogin.MainActivity
import com.projectes.projectelogin.R
import com.projectes.projectelogin.Recycler.RecyclerViewAdapter
import com.projectes.projectelogin.db.DBHelper

class ListFragment(dbHelper: DBHelper) : Fragment() {
    var dbHelper =dbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v: View = inflater.inflate(R.layout.fragment_list, container, false)

        var llistat: MutableList<Clase> = dbHelper.readClases()

        var mRecyclerView: RecyclerView = v.findViewById(R.id.recyclerView);
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        val mAdapter = RecyclerViewAdapter(llistat, context);

        mRecyclerView.adapter = mAdapter
        mRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        var btnDelete: Button = v.findViewById(R.id.btn_eliminate_all)

        val builder = AlertDialog.Builder(context)
        builder.setMessage("Seguro que quieres eliminarlo todo?")
            .setPositiveButton("Si",
                DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(context, "Contenido eliminado", Toast.LENGTH_SHORT).show()
                    dbHelper.deleteAll()
                    // User accepted the dialog
                })
            .setNegativeButton("No",
                DialogInterface.OnClickListener { dialog, id ->
                    // User cancelled the dialog
                })
        btnDelete.setOnClickListener {
            builder.create().show()
        }


        return v;
    }
    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }

}
