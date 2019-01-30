package myapp.com.spotter

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class SpotterApp: Application() {

    companion object {
        lateinit var requestQueue: RequestQueue
    }

    override fun onCreate() {
        super.onCreate()

        requestQueue = Volley.newRequestQueue(this)
    }
}