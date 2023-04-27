package com.example.carepets.mainfunction.medicalbook.overview.weight

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carepets.R
import com.example.carepets.database.PetHeight
import com.example.carepets.database.PetWeight
import com.example.carepets.mainfunction.medicalbook.overview.height.HeightDiagramActivity

class HeightListAdapter(var hlist: List<PetHeight>) : RecyclerView.Adapter<HeightListAdapter.ViewHolder>(){

    lateinit var binding: HeightDiagramActivity

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemWeight: TextView = itemView.findViewById(R.id.tv_weight_data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.line_weight_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = hlist[position]
        holder.itemWeight.text = "${item.heightDate} - ${item.heightTime} - ${item.heightResult} cm"
    }
}