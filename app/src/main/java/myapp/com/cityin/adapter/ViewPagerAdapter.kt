package myapp.com.cityin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: androidx.fragment.app.FragmentManager): androidx.fragment.app.FragmentPagerAdapter(fm){

    var mfm = fm
    var mFragmentItems: ArrayList<androidx.fragment.app.Fragment> = ArrayList()
    var mFragmentTitle : ArrayList<String> = ArrayList()

    fun addFragments(fragmentItem: androidx.fragment.app.Fragment, fragmentTitle:String){
        mFragmentItems.add(fragmentItem)
        mFragmentTitle.add(fragmentTitle)
    }

    override fun getItem(p0: Int): androidx.fragment.app.Fragment {
        return mFragmentItems[p0]
    }

    override fun getCount(): Int {
        return mFragmentItems.size
    }

}