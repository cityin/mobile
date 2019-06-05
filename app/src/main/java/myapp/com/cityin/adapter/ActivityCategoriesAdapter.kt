package myapp.com.cityin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_category.view.*
import myapp.com.cityin.R
import myapp.com.cityin.network.response.Category

class ActivityCategoriesAdapter(val categories: Array<Category>): RecyclerView.Adapter<ActivityCategoriesAdapter.ViewHolder>(){

    var listener: CategoryListener? = null

    interface CategoryListener {
        fun clicked(category: Category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellFlow = layoutInflater.inflate(R.layout.item_category, parent, false)

        return ViewHolder(cellFlow)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories.get(position)
        val picture = holder.view.travel_band_image_view

        holder.view.travel_band_title.text = category.name

        holder.view.setOnClickListener {
            listener?.clicked(category)
        }

        Picasso.get().load(category.thumbnailUrl).into(picture)
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {}


}