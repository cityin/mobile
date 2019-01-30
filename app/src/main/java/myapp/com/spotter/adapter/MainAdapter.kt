package myapp.com.spotter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_layout.view.*
import myapp.com.spotter.R
import myapp.com.spotter.network.response.Activity
import myapp.com.spotter.network.response.ResultActivities

class MainAdapter(val activities: List<Activity>): RecyclerView.Adapter<CustomViewHolder>() {
    
    // return numbers of items
    override fun getItemCount(): Int {
        return activities.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // How to create a view

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellFlow = layoutInflater.inflate(R.layout.card_layout, parent, false)

        return CustomViewHolder(cellFlow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val activity = activities.get(position)

        holder.itemView.cardTitle.text = activity.name
        holder.itemView.cardDate.text = "12 janvier 2018"
    }


}

class CustomViewHolder(v: View): RecyclerView.ViewHolder(v) {

}