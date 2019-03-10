package myapp.com.cityin.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter(fm:FragmentManager): FragmentPagerAdapter(fm){

    var mfm = fm
    var mFragmentItems: ArrayList<Fragment> = ArrayList()
    var mFragmentTitle : ArrayList<String> = ArrayList()

    fun addFragments(fragmentItem:Fragment,fragmentTitle:String){
        mFragmentItems.add(fragmentItem)
        mFragmentTitle.add(fragmentTitle)
    }

    override fun getItem(p0: Int): Fragment {
       return mFragmentItems[p0]
    }

    override fun getCount(): Int {
        return mFragmentItems.size
    }

}