package myapp.com.cityin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_groupe.*
import myapp.com.cityin.R
import myapp.com.cityin.adapter.ViewPagerAdapter
import myapp.com.cityin.fragment.fragmentPeoplePage.FoldersFragment
import myapp.com.cityin.fragment.fragmentPeoplePage.SuggestionFragment


class GroupeFragment : androidx.fragment.app.Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var adapter: ViewPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_groupe, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val manager = childFragmentManager

        adapter = ViewPagerAdapter(manager)
        adapter.addFragments(FoldersFragment(),"Activités")
        adapter.addFragments(SuggestionFragment(), "Suggestions")

        viewPager.adapter = adapter

        tabs.setupWithViewPager(viewPager)
    }

}