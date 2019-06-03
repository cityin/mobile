package myapp.com.cityin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_search.*
import myapp.com.cityin.R
import myapp.com.cityin.adapter.ActivityCategoriesAdapter
import myapp.com.cityin.adapter.ActivityHighlightedAdapter
import myapp.com.cityin.network.ActivitiesService
import myapp.com.cityin.network.CategoriesService

class SearchFragment : androidx.fragment.app.Fragment() {


    private fun getActivityCategories() {

        activity_categories_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        CategoriesService.getActivityCategories({
            categories -> categories.size
            activity_categories_recycler_view.adapter = ActivityCategoriesAdapter(categories)
        }, {

        })

    }

    private fun getHighlightedActitivities() {
        activity_highlights_recycler_view.layoutManager = LinearLayoutManager(context)

        ActivitiesService.getHighlightedActivities({
            activities -> activities.size
            activity_highlights_recycler_view.adapter = ActivityHighlightedAdapter(activities)

            ViewCompat.setNestedScrollingEnabled(activity_highlights_recycler_view, false)
        }, {

        })

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        getActivityCategories()

        getHighlightedActitivities()

    }
}