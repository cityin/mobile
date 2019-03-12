package myapp.com.cityin

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class CityInApp: Application() {

    companion object {
        lateinit var requestQueue: RequestQueue
    }

    override fun onCreate() {
        super.onCreate()

        requestQueue = Volley.newRequestQueue(this)
    }
}