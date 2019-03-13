package myapp.com.cityin.fragment.fragmentPeoplePage


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_folders.*
import myapp.com.cityin.R
import myapp.com.cityin.adapter.FolderAdapter
import myapp.com.cityin.network.FoldersService

class FoldersFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_folders, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activities_recyclerView.layoutManager = LinearLayoutManager(context)

        FoldersService.getFolders({
            folders -> folders.size
            activities_recyclerView.adapter = FolderAdapter(folders)
        }, {

        })
    }
}
