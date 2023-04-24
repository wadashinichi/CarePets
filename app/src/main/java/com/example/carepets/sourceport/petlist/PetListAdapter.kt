package com.example.carepets.sourceport.petlist

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivities
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.carepets.R
import com.example.carepets.database.Pet
import com.example.carepets.databinding.ActivityAddPetBinding
import com.example.carepets.databinding.ActivityListPetBinding
import com.example.carepets.mainfunction.TrackerActivity

class PetListAdapter(var plist: List<Pet>, var context: Context) : RecyclerView.Adapter<PetListAdapter.ViewHolder>() {

    private lateinit var binding: ActivityListPetBinding

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.pet_image)
        val name: TextView = itemView.findViewById(R.id.pet_name)
        val species: TextView = itemView.findViewById(R.id.pet_species)
        val layoutItem: ConstraintLayout = itemView.findViewById(R.id.line_pet)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.line_pet_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (plist != null) {
            return plist.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = plist[position]
        holder.name.text = item.name
        holder.species.text = item.species + " - " + item.birth

        // image
        holder.img.setImageURI(convertToUri(item.img))

        var id: Int? = plist[position].id
        holder.layoutItem.setOnClickListener {
            sendData(id, context)
        }
    }
    private fun sendData(id: Int?, context: Context) {
        val i: Intent = Intent(context, TrackerActivity::class.java)
        i.putExtra("petId", id)
        startActivity(context, i, null)
    }
    private fun convertToUri(str: String): Uri {
        var uri: Uri = str.toUri()
        return uri
    }
}