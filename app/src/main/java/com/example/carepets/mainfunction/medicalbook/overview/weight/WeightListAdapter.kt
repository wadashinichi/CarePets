package com.example.carepets.mainfunction.medicalbook.overview.weight

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carepets.R
import com.example.carepets.database.PetWeight

class WeightListAdapter(var wlist: List<PetWeight>) : RecyclerView.Adapter<WeightListAdapter.ViewHolder>(){

    lateinit var binding: WeightDiagramActivity

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemWeight: TextView = itemView.findViewById(R.id.tv_weight_data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.line_weight_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return wlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var item = wlist[position]
        holder.itemWeight.text = "${item.weightDate} - ${item.weightTime} - ${item.weightResult}kg"
    }
}