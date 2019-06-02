package myapp.com.cityin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_search.*
import myapp.com.cityin.R
import myapp.com.cityin.adapter.ActivityCategoriesAdapter
import myapp.com.cityin.network.response.Category

class SearchFragment : androidx.fragment.app.Fragment() {
    var categories: MutableList<Category> = mutableListOf()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        categories.add(Category("Sorties culturelles et touristiques", "https://a0.muscache.com/im/pictures/77d2c051-9492-4c16-a5ca-a8ea0e3e4c1d.jpg?aki_policy=poster"))
        categories.add(Category("Sorties culturelles et touristiques", "https://a0.muscache.com/im/pictures/77d2c051-9492-4c16-a5ca-a8ea0e3e4c1d.jpg?aki_policy=poster"))
        categories.add(Category("Sorties culturelles et touristiques", "https://a0.muscache.com/im/pictures/77d2c051-9492-4c16-a5ca-a8ea0e3e4c1d.jpg?aki_policy=poster"))
        categories.add(Category("Sorties culturelles et touristiques", "https://a0.muscache.com/im/pictures/77d2c051-9492-4c16-a5ca-a8ea0e3e4c1d.jpg?aki_policy=poster"))

        activity_categories_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        activity_categories_recycler_view.adapter = ActivityCategoriesAdapter(categories)

    }
}