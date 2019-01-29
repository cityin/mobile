package myapp.com.spotter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_layout.view.*

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    val activities = listOf("Coucou", "Au revoir", "Bye", "Manger", "Woa", "Boum")

    // return numbers of items
    override fun getItemCount(): Int {
        return activities.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // How to create a view

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellFlow = layoutInflater.inflate(R.layout.card_layout, parent, false)

        return CustomViewHolder(cellFlow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val activity = activities.get(position)

        holder.itemView.cardTitle.text = activity
        holder.itemView.cardDate.text = "12 janvier 2018"
    }


}

class CustomViewHolder(v: View): RecyclerView.ViewHolder(v) {

}