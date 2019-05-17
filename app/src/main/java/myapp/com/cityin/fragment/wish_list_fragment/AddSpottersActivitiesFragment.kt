package myapp.com.cityin.fragment.wish_list_fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
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
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_add_spotters_activities.*
import kotlinx.android.synthetic.main.fragment_wish_list_fragment_folder_activities.*
import myapp.com.cityin.adapter.FolderActivitiesAdapter
import myapp.com.cityin.adapter.FolderAdapter
import myapp.com.cityin.adapter.SpotterAdapter
import myapp.com.cityin.network.FoldersService
import myapp.com.cityin.network.SpotterService
import myapp.com.cityin.network.response.Spotters


class AddSpottersActivitiesFragment : BottomSheetDialogFragment() {

    lateinit var travelBandId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        travelBandId = bundle?.getString("travelBandId").toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_spotters_activities, container, false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        spotterRecyclerView.layoutManager = LinearLayoutManager(context)

        SpotterService.getSpotters(travelBandId, {
            spotters -> spotters.size
            spotterRecyclerView.adapter = SpotterAdapter(spotters)
        }, {

        })

    }


}
