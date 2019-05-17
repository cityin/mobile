package myapp.com.cityin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_wishlist.*
import myapp.com.cityin.R
import myapp.com.cityin.adapter.FolderAdapter
import myapp.com.cityin.network.FoldersService

class WishlistFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_wishlist, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        foldersRecyclerView.layoutManager = LinearLayoutManager(context)

        FoldersService.getFolders({
            folders -> folders.size
            foldersRecyclerView.adapter = FolderAdapter(folders)

            ViewCompat.setNestedScrollingEnabled(foldersRecyclerView, false);
        }, {

        })
    }
}