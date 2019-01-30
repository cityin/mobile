package myapp.com.spotter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_layout.view.*
import myapp.com.spotter.R
import myapp.com.spotter.network.response.Activity

class MainAdapter(val activities: List<Activity>): RecyclerView.Adapter<CustomViewHolder>() {
    
    // Return numbers of items
    override fun getItemCount(): Int {
        return activities.count()
    }

    // How to create a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellFlow = layoutInflater.inflate(R.layout.card_layout, parent, false)

        return CustomViewHolder(cellFlow)

    }

    // How to bind the data into the view
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val activity = activities.get(position)

        holder.itemView.cardTitle.text = activity.name
        holder.itemView.cardDate.text = "12 janvier 2018"

        // Use Picasso to set the image url into the cardView
        val cardPicture = holder.itemView.cardImageView

        Picasso.get().load("https://picsum.photos/500/300/?random").into(cardPicture)
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {}