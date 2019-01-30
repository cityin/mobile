package myapp.com.spotter.network

import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import myapp.com.spotter.SpotterApp
import myapp.com.spotter.network.response.Activity
import myapp.com.spotter.network.response.ResultActivities

class ActivitiesService {
    companion object {
        fun getActivities(success: (activities: List<Activity>) -> Unit,
                          failure: (error: VolleyError?) -> Unit) {

            val url = UrlBuilder.activitiesUrl

            val request = BaseRequest.Builder<ResultActivities>(Request.Method.GET,
                    url, ResultActivities::class.java).listener(object : RequestListener<ResultActivities> {

                override fun onSuccess(request: Request<ResultActivities>, response: NetworkResponse, result: ResultActivities?) {

                    val activities = result?.activities ?: emptyList()

                    success(activities)
                }

                override fun onFailure(request: Request<ResultActivities>, response: NetworkResponse?, error: VolleyError?) {
                    failure(error)
                }
            }).build()

            SpotterApp.requestQueue.add(request)
        }
    }
}