package myapp.com.cityin.fragment.wish_list_fragment

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_wish_list_fragment_folder_activities.*
import myapp.com.cityin.R
import myapp.com.cityin.network.ActivitiesService

class DetailsActivitiesFragment : androidx.fragment.app.Fragment() {

    val args: DetailsActivitiesFragmentArgs by navArgs()
    lateinit var activityId: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details_activities, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val imageActivity: ImageView = view!!.findViewById(R.id.imageActivity)
        val nameText: TextView = view!!.findViewById(R.id.nameActivity)
        val locationText: TextView = view!!.findViewById(R.id.textTarget)
        val durationText: TextView = view!!.findViewById(R.id.textTimer)
        val stuffText: TextView = view!!.findViewById(R.id.textStuff)
        val languageText: TextView = view!!.findViewById(R.id.textLanugage)
        val descriptionText: TextView = view!!.findViewById(R.id.descriptionActivity)

        activityId = args.activityId

        ActivitiesService.getDetailsActivitiesByTravelBand(activityId, {
              activities -> activities
              nameText.text = activities.office.name.toString()
        }, {
            Log.i("test","test")
        })

    }
}
