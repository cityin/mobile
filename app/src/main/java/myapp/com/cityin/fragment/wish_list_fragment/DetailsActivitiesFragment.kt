package myapp.com.cityin.fragment.wish_list_fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_activities.*
import myapp.com.cityin.R
import myapp.com.cityin.fragment.wish_list_fragment.set_Time_Fragment.DatePickerFragment
import myapp.com.cityin.fragment.wish_list_fragment.set_Time_Fragment.TimePickerFragment
import myapp.com.cityin.network.ActivitiesService
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class DetailsActivitiesFragment : androidx.fragment.app.Fragment(), OnMapReadyCallback {

    val args: DetailsActivitiesFragmentArgs by navArgs()
    lateinit var activityId: String
    private lateinit var mMap: GoogleMap

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details_activities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Bind data
        val imageActivity: ImageView = view!!.findViewById(R.id.imageActivity)
        val nameText: TextView = view!!.findViewById(R.id.nameActivity)
        val locationText: TextView = view!!.findViewById(R.id.textTarget)
        val durationText: TextView = view!!.findViewById(R.id.textTimer)
        val stuffText: TextView = view!!.findViewById(R.id.textStuff)
        val languageText: TextView = view!!.findViewById(R.id.textLanugage)
        val descriptionText: TextView = view!!.findViewById(R.id.descriptionActivity)
        val titleIconText: TextView = view!!.findViewById(R.id.titleIcon)

        activityId = args.activityId

        ActivitiesService.getDetailsActivitiesByTravelBand(activityId, {
              activities -> activities

              Picasso.get().load(activities.pictures[0]).into(imageActivity)
              nameText.text = activities.name.toString()
              locationText.text = "${activities.location.street.toString()}, ${activities.location.postalCode.toString()} ${activities.location.city.toString()}"
              durationText.text = "${activities.duration.toString()} heure"
              languageText.text = "${activities.language.toString()}"
              titleIconText.text = "En savoir plus sur \"${activities.office.name.toString()}\""
              descriptionText.text = activities.office.about.toString()

        }, {
            Log.i("test","test")
        })

        //Call TimePickerDialog

        btn1.setOnClickListener {
            DatePickerFragment().show(fragmentManager, "datePicker")
        }

        btn2.setOnClickListener {
            TimePickerFragment().show(fragmentManager, "timePicker")
        }
    }

}
