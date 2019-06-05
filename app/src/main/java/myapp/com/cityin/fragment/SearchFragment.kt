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
import myapp.com.cityin.CityInApp
import myapp.com.cityin.R
import myapp.com.cityin.adapter.ActivityCategoriesAdapter
import myapp.com.cityin.adapter.ActivityHighlightedAdapter
import myapp.com.cityin.network.ActivitiesService
import myapp.com.cityin.network.CategoriesService
import myapp.com.cityin.network.response.Category
import java.util.*
import kotlin.concurrent.schedule

class SearchFragment : androidx.fragment.app.Fragment(), ActivityCategoriesAdapter.CategoryListener {

    var query = ""
    var categoryId = ""


    private fun getActivityCategories() {

        activity_categories_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        CategoriesService.getActivityCategories({
            categories -> categories.size
            val adapter = ActivityCategoriesAdapter(categories)
            adapter.listener = this
            activity_categories_recycler_view.adapter = adapter
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

    private fun searchActivities() {
        CityInApp.requestQueue.cancelAll(this)

        var q: String? = null
        if (!query.isEmpty()) {
            q = query
        }

        var category: String? = null
        if (!categoryId.isEmpty()) {
            category = categoryId
        }

        Timer().schedule(500
        ) {
            ActivitiesService.searchActivitiesByQueryText(q, category, {
                activities -> activities.size
                search_results_recycler_view.adapter = ActivityHighlightedAdapter(activities)

                if (categoryId === "" && query === "") {
                    displayViews()
                } else {
                    hideViews()
                }
                ViewCompat.setNestedScrollingEnabled(search_results_recycler_view, false)

            }, {

            })
        }
    }

    private fun hideViews() {
        search_activity_title.visibility = View.GONE
        activity_highlights_recycler_view.visibility = View.GONE
        search_results_recycler_view.visibility = View.VISIBLE
    }

    private fun displayViews() {
        search_activity_title.visibility = View.VISIBLE
        activity_highlights_recycler_view.visibility = View.VISIBLE
        search_results_recycler_view.visibility = View.GONE
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        search_results_recycler_view.layoutManager = LinearLayoutManager(context)

        getActivityCategories()

        getHighlightedActivities()

        search_input.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (search_input.text.isEmpty()) {
                    query = ""
                } else {
                    query = s?.toString() ?: ""
                }

                searchActivities()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }

    override fun clicked(category: Category) {
        if (categoryId == category.categoryId) {
            categoryId = ""
        } else {
            categoryId = category.categoryId
        }
        searchActivities()
    }
}