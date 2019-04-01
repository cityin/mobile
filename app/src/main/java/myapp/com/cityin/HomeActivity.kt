package myapp.com.cityin

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import myapp.com.cityin.fragment.WhislitFragment
import myapp.com.cityin.fragment.IncomingFragment
import myapp.com.cityin.fragment.SearchFragment
import myapp.com.cityin.fragment.UserFragment

class HomeActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_search -> {
                startFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorite -> {
                startFragment(WhislitFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_incoming -> {
                startFragment(IncomingFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_user -> {
                startFragment(UserFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        startFragment(SearchFragment())
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun startFragment(view: androidx.fragment.app.Fragment){
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, view)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
