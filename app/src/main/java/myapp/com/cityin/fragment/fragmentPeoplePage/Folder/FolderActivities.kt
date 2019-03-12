package myapp.com.cityin.fragment.fragmentPeoplePage.Folder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs

import myapp.com.cityin.R

class FolderActivities : Fragment() {
    val args: FolderActivitiesArgs by navArgs()

    lateinit var folderId: String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_folder_activities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        folderId = args.folderId
        val tv:TextView = view.findViewById(R.id.folderActivitiesTextView)
        tv.text = folderId
    }
}
