package myapp.com.cityin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_activity.view.*
import myapp.com.cityin.R
import myapp.com.cityin.fragment.SearchFragmentDirections
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
        holder.view.priceActivityTextView.text = "${activity.price}€/pers"

        val activityId: String
        activityId = activity.activityId
        val travelBandId: String
        travelBandId = ""

        val cardPicture = holder.view.activityImageView

        Picasso.get().load(activity.pictures[0]).into(cardPicture)

        val action = SearchFragmentDirections.actionSearchFragmentToDetailsActivitiesFragment3(activityId,travelBandId)

        holder.view.setOnClickListener {
            it.findNavController().navigate(action)
        }


    }
}

class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {}