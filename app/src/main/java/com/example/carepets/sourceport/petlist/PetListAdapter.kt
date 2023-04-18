package com.example.carepets.sourceport.petlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carepets.R
import com.example.carepets.database.Pet
import com.example.carepets.databinding.ActivityAddPetBinding
import com.example.carepets.databinding.ActivityListPetBinding

class PetListAdapter(var plist: List<Pet>) : RecyclerView.Adapter<PetListAdapter.ViewHolder>() {

    private lateinit var binding: ActivityListPetBinding

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.pet_image)
        val name: TextView = itemView.findViewById(R.id.pet_name)
        val species: TextView = itemView.findViewById(R.id.pet_species)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.line_pet_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return plist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = plist[position]
//        holder.img.setImageResource(item.img)
        holder.name.text = item.name
        holder.species.text = item.species
    }
}