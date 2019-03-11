/*
package myapp.com.cityin.adapter
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_activity.view.*
import myapp.com.cityin.Activity
import myapp.com.cityin.R

class ActivityAdapter(val activites: List<Activity>, val itemClickListener: View.OnClickListener) : RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.card_view) as CardView
        val imgView: ImageView = cardView.findViewById(R.id.img_item) as ImageView
        val titleView: TextView = cardView.findViewById(R.id.title) as TextView
        val priceView: TextView = cardView.findViewById(R.id.price_activity) as TextView
        val avisView: TextView = cardView.findViewById(R.id.note_activity) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val viewItem: View = LayoutInflater.from(parent.context).inflate(R.layout.item_activity,parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        val activity: Activity = activites[1]
        holder.cardView.setOnClickListener(itemClickListener)
        holder.cardView.tag = p1
        holder.imgView.image = ativity.image
        holder.titleView.text = activity.title
        holder.priceView.text = activity.text
        holder.avisView.text = activity.text
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
*/