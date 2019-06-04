package myapp.com.cityin.fragment.wish_list_fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.borjabravo.readmoretextview.ReadMoreTextView
import com.google.android.gms.maps.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_activities.*
import myapp.com.cityin.R
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import myapp.com.cityin.network.ActivitiesService.Companion.getDetailsActivitiesByTravelBand
import java.lang.StringBuilder

class DetailsActivitiesFragment : androidx.fragment.app.Fragment(),OnMapReadyCallback {

    val args: DetailsActivitiesFragmentArgs by navArgs()
    lateinit var activityId: String
    lateinit var travelBandId: String
    private lateinit var mMap: GoogleMap
    lateinit var langue: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var context = context
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
        val languageText: TextView = view!!.findViewById(R.id.textLanugage)
        val iconActivity: ImageView = view!!.findViewById(R.id.iconActivity)
        val enSavoirPlus: ReadMoreTextView = view!!.findViewById(R.id.enSavoirPlusText)
        val titleIconText: TextView = view!!.findViewById(R.id.titleIcon)

        activityId = args.activityId
        travelBandId = args.travelBandId

        getDetailsActivitiesByTravelBand(activityId, {
              activities -> activities

            val builder = StringBuilder()
            for (details in activities.languages) {
                builder.append(details + ", ")
            }

              Picasso.get().load(activities.pictures[0]).into(imageActivity)
              Picasso.get().load(activities.office.thumbnailUrl).into(iconActivity)
              nameText.text = activities.name.toString()
              locationText.text = "${activities.location.street.toString()}, ${activities.location.postalCode.toString()} ${activities.location.city.toString()}"
              durationText.text = "${activities.duration.toString()} heure"
              enSavoirPlus.text = activities.description.toString()
              //enSavoirPlus.setTrimExpandedText("Afficher la suite")
              //enSavoirPlus.setTrimCollapsedText("Montrer moins")
              //enSavoirPlus.setTrimLines(5)
              //enSavoirPlus.setColorClickableText(1)
              languageText.setText(builder.toString())
              titleIconText.text = "En savoir plus sur \"${activities.office.name.toString()}\""
        }, {
        })



        val action = DetailsActivitiesFragmentDirections.actionDetailsActivitiesFragmentToAddSpottersActivitiesFragment(travelBandId)

        btnAddSpotters.setOnClickListener {
            this.findNavController().navigate(action)
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        getDetailsActivitiesByTravelBand(activityId, {
            activities -> activities
            var longitude = activities.location.longitude
            var latitude = activities.location.latitude
            // Add a marker in Sydney and move the camera
            val sydney = LatLng(latitude.toDouble(),longitude.toDouble())
            mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            mMap.setMinZoomPreference(15.0f)
        }, {
        })
    }
}
