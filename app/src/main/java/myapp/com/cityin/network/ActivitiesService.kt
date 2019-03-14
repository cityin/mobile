package myapp.com.cityin.network

import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import myapp.com.cityin.CityInApp
import myapp.com.cityin.network.response.Activity

class ActivitiesService {
    companion object {
        fun getActivities(success: (activities: Array<Activity>) -> Unit,
                          failure: (VolleyError?) -> Unit) {
            val url = UrlBuilder.suggestionsUrl

            val request = BaseRequest.Builder<Array<Activity>>(Request.Method.GET,
                    url, Array<Activity>::class.java).listener(object: RequestListener<Array<Activity>> {
                override fun onSuccess(request: Request<Array<Activity>>, response: NetworkResponse, result: Array<Activity>?) {
                    val activities = result ?: emptyArray()

                    success(activities)
                }

                override fun onFailure(request: Request<Array<Activity>>, response: NetworkResponse?, error: VolleyError?) {
                    failure(error)
                }

            }).build()

            CityInApp.requestQueue.add(request)
        }
    }
}