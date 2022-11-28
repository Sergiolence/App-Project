package com.projectes.projectelogin.Recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.projectes.projectelogin.Clase
import com.projectes.projectelogin.R
import com.projectes.projectelogin.fragments.ItemFragment

class RecyclerViewAdapter(llistat: MutableList<Clase>, context: Context?): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var llistat: MutableList<Clase> = llistat;
    var context: Context? = context;

    //Es l'element que es repeteix en el list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }
    //Es on es posa la informació dels elements del list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ItemFragment(llistat.get(position))).commit();
            }
        })

        holder.txtTitol.setText(llistat.get(position).getTitol());
        holder.txtSubtitol.setText(llistat.get(position).getSubtitol());
        holder.txtDescripcio.setText(llistat.get(position).getDescripcio());

    }
    //Retorna la quantitat d'elements en l'array
    override fun getItemCount(): Int {
        return llistat.size;
    }
    //Retorna la vista procesada de item_list.xml
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtTitol: TextView = view.findViewById(R.id.itemTitol);
        val txtSubtitol: TextView = view.findViewById(R.id.itemSubtitol);
        val txtDescripcio: TextView = view.findViewById(R.id.itemDescripcio);
        val btnEliminar: Button = view.findViewById(R.id.itemButton)

    }
}
