package myapp.com.cityin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_votes_spotter.view.*
import myapp.com.cityin.R
import myapp.com.cityin.network.response.Spotters

class SpotterVotesAdapter(val spotters: MutableList<Spotters>): RecyclerView.Adapter<CustomSpotterVotesAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomSpotterVotesAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellFlow = layoutInflater.inflate(R.layout.item_votes_spotter, parent, false)

        return CustomSpotterVotesAdapterViewHolder(cellFlow)
    }

    override fun getItemCount(): Int {
        return spotters.count()
    }

    override fun onBindViewHolder(holder: CustomSpotterVotesAdapterViewHolder, position: Int) {
        val spotter = spotters.get(position)

        val cardPicture = holder.itemView.spotterAvatar
        val icon = holder.itemView.spotterVoteIcon
        val backgroundIcon = holder.itemView.spotterVoteBackground

        if (spotter.like) {
            icon.setImageResource(R.drawable.ic_check_white_24dp)
            backgroundIcon.setBackgroundColor(Color.parseColor("#42b72a"))
        } else {
            icon.setImageResource(R.drawable.ic_clear_white_24dp)
            backgroundIcon.setBackgroundColor(Color.parseColor("#f53535"))
        }

        Picasso.get().load(spotter.thumbnailUrl).into(cardPicture)
    }

}

class CustomSpotterVotesAdapterViewHolder(view: View): RecyclerView.ViewHolder(view) {}