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
        val picture = holder.view.activity_category_image_view

        holder.view.activity_category_text_view.text = category.name

        Picasso.get().load(category.thumbnailUrl).into(picture)
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {}


}