package myapp.com.cityin.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

    private fun getHighlightedActivities() {
        activity_highlights_recycler_view.layoutManager = LinearLayoutManager(context)

        ActivitiesService.getHighlightedActivities({
            activities -> activities.size
            activity_highlights_recycler_view.adapter = ActivityHighlightedAdapter(activities)

            ViewCompat.setNestedScrollingEnabled(activity_highlights_recycler_view, false)
        }, {

        })

    }

    private fun searchActivities(s: Editable?) {
        search_results_recycler_view.layoutManager = LinearLayoutManager(context)

        ActivitiesService.searchActivitiesByQueryText(s?.toString(), {
            activities -> activities.size
            search_results_recycler_view.adapter = ActivityHighlightedAdapter(activities)

            ViewCompat.setNestedScrollingEnabled(search_results_recycler_view, false)

        }, {

        })
    }

    private fun hideViews() {
        search_container.visibility = View.GONE
        search_results.visibility = View.VISIBLE

    }

    private fun displayViews() {
        search_container.visibility = View.VISIBLE
        search_results.visibility = View.GONE
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        getActivityCategories()

        getHighlightedActivities()


        search_input.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (search_input.text.isEmpty()) {

                    displayViews()

                } else {
                    hideViews()

                    searchActivities(s)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }
}