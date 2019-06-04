package myapp.com.cityin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_spotters.view.*
import kotlinx.android.synthetic.main.spotter_auto_complete.view.*
import myapp.com.cityin.R
import myapp.com.cityin.network.response.Spotters
import okhttp3.internal.notifyAll


class SpotterAddAdapter(val spotters: Array<Spotters>): RecyclerView.Adapter<CustomAddSpotterViewHolder>() {

    // Return numbers of items
    override fun getItemCount(): Int {
        return spotters.count()
    }

    // How to create a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAddSpotterViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellFlow = layoutInflater.inflate(R.layout.item_spotters, parent, false)

        return CustomAddSpotterViewHolder(cellFlow)
    }

    // How to bind the data into the view
    override fun onBindViewHolder(holder: CustomAddSpotterViewHolder, position: Int) {
        val spotter = spotters.get(position)
        val cardPicture = holder.view.imageSpotter

        Picasso.get().load(spotter.thumbnailUrl).into(cardPicture)
        holder.view.name_spotter.text = spotter.username.toString()
    }
}

class CustomAddSpotterViewHolder(val view: View): RecyclerView.ViewHolder(view) {}