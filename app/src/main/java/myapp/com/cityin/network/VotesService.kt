package myapp.com.cityin.network

import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import myapp.com.cityin.CityInApp
import myapp.com.cityin.network.response.Spotters

class VotesService {
    companion object {
        fun postInterestVote(travelBandId: String, activityId: String, success: (spotter: Spotters) -> Unit,
                             failure: (VolleyError?) -> Unit) {
            val url = UrlBuilder.reactionRoutes(travelBandId, activityId)
            val body = hashMapOf("like" to true)
            val headers = hashMapOf("X-Spotter" to CityInApp.spotterId)

            val request = BaseRequest.Builder<Spotters>(Request.Method.POST,
                    url, Spotters::class.java)
                    .headers(headers)
                    .json(body)
                    .listener(object: RequestListener<Spotters> {
                        override fun onSuccess(request: Request<Spotters>, response: NetworkResponse, result: Spotters?) {
                            val res = result?: Spotters()

                            success(res)
                        }

                        override fun onFailure(request: Request<Spotters>, response: NetworkResponse?, error: VolleyError?) {
                           failure(error)
                        }

                    }).build()

            CityInApp.requestQueue.add(request)
        }

        fun postNonInterestVote(travelBandId: String, activityId: String, success: (spotter: Spotters) -> Unit,
                             failure: (VolleyError?) -> Unit) {
            val url = UrlBuilder.reactionRoutes(travelBandId, activityId)
            val body = hashMapOf("like" to false)
            val headers = hashMapOf("X-Spotter" to CityInApp.spotterId)

            val request = BaseRequest.Builder<Spotters>(Request.Method.POST,
                    url, Spotters::class.java)
                    .headers(headers)
                    .json(body)
                    .listener(object: RequestListener<Spotters> {
                        override fun onSuccess(request: Request<Spotters>, response: NetworkResponse, result: Spotters?) {
                            val res = result?: Spotters()

                            success(res)
                        }

                        override fun onFailure(request: Request<Spotters>, response: NetworkResponse?, error: VolleyError?) {
                            failure(error)
                        }

                    }).build()

            CityInApp.requestQueue.add(request)
        }

    }
}