package myapp.com.cityin

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class CityInApp: Application() {


    companion object {
        lateinit var requestQueue: RequestQueue
        val spotterId = "bb44e065-04de-43da-864a-3a618852f950"
    }

    override fun onCreate() {
        super.onCreate()

        requestQueue = Volley.newRequestQueue(this)
    }
}