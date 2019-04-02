package myapp.com.cityin.fragment.whislist_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs

import myapp.com.cityin.R

class WhislistFragmentTravelBandActivities : Fragment() {
    val args: WhislistFragmentTravelBandActivitiesArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_whislist_fragment_folder_activities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val folderId: String = args.folderId
        val editTextView: TextView = view.findViewById(R.id.whishlistFragmentFolderActivitiesTextView)

        editTextView.text = folderId
    }
}
