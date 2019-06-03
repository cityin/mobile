package myapp.com.cityin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_activity.view.*
import myapp.com.cityin.R
import myapp.com.cityin.network.response.Activity

class ActivityHighlightedAdapter(val activities: Array<Activity>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder  {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellFlow = layoutInflater.inflate(R.layout.item_activity, parent, false)

        return ViewHolder(cellFlow)
    }

    override fun getItemCount(): Int {
        return activities.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = activities.get(position)

        holder.view.activityNameTextView.text = activity.name
        holder.view.activityMarkRateTextView.text = activity.mark.toString()
        holder.view.activityRatingBar.rating = activity.mark.toFloat()
        holder.view.activityPriceTextView.text = "${activity.price.toString()}€ par personnes"
        holder.view.activityVotesTextView.text = activity.nbVotes.toString()

        val cardPicture = holder.view.activityImageView

        Picasso.get().load(activity.pictures[0]).into(cardPicture)
    }
}

class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {}