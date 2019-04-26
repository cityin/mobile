package myapp.com.cityin.fragment.wish_list_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import myapp.com.cityin.R


class DetailsActivitiesFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_activities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val imageActivity: ImageView = view.findViewById(R.id.imageActivity)
        val nameText: TextView = view.findViewById(R.id.nameActivity)
        val locationText: TextView = view.findViewById(R.id.textTarget)
        val durationText: TextView = view.findViewById(R.id.textTimer)
        val stuffText: TextView = view.findViewById(R.id.textStuff)
        val languageText: TextView = view.findViewById(R.id.textLanugage)
        val descriptionText: TextView = view.findViewById(R.id.descriptionActivity)


    }

}