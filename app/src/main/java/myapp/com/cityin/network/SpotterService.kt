package myapp.com.cityin.network

import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import myapp.com.cityin.CityInApp
import myapp.com.cityin.network.response.Activity
import myapp.com.cityin.network.response.Folder
import myapp.com.cityin.network.response.Spotters
import okhttp3.OkHttpClient

class SpotterService {
    companion object {
        fun getSpotters(folderdId: String, success: (spotter: Array<Spotters>) -> Unit,
                                        failure: (VolleyError?) -> Unit) {
            val url = UrlBuilder.getSpotterByTravelBand(folderdId)

            val request = BaseRequest.Builder<Array<Spotters>>(Request.Method.GET,
                    url, Array<Spotters>::class.java).listener(object: RequestListener<Array<Spotters>> {
                override fun onFailure(request: Request<Array<Spotters>>, response: NetworkResponse?, error: VolleyError?) {
                    failure(error)
                }

                override fun onSuccess(request: Request<Array<Spotters>>, response: NetworkResponse, result: Array<Spotters>?) {
                    val spotters = result ?: emptyArray()

                    success(spotters)
                }
            }).build()

            CityInApp.requestQueue.add(request)
        }

        fun getAddSpotters(name: String, success: (spotter: Array<Spotters>) -> Unit,
                        failure: (VolleyError?) -> Unit) {
            val url = UrlBuilder.getAddSpottersTravelBand(name)

            val request = BaseRequest.Builder<Array<Spotters>>(Request.Method.GET,
                    url, Array<Spotters>::class.java).listener(object: RequestListener<Array<Spotters>> {
                override fun onFailure(request: Request<Array<Spotters>>, response: NetworkResponse?, error: VolleyError?) {
                    failure(error)
                }

                override fun onSuccess(request: Request<Array<Spotters>>, response: NetworkResponse, result: Array<Spotters>?) {
                    val spotters = result ?: emptyArray()

                    success(spotters)
                }
            }).build()

            CityInApp.requestQueue.add(request)
        }

        fun inviteSpotter(travelBandId: String, spotterId: String, success: (spotter: Spotters) -> Unit,
                          failure: (VolleyError?) -> Unit) {

            val body = hashMapOf("spotterId" to spotterId)
            val headers = hashMapOf("X-Spotter" to CityInApp.spotterId)
            val url = UrlBuilder.getInviteSpotterToTravelBand(travelBandId)

            val request = BaseRequest.Builder<Spotters>(Request.Method.POST, url, Spotters::class.java)
                    .headers(headers)
                    .json(body)
                    .listener(object: RequestListener<Spotters> {
                        override fun onFailure(request: Request<Spotters>, response: NetworkResponse?, error: VolleyError?) {
                            failure(error)
                        }

                        override fun onSuccess(request: Request<Spotters>, response: NetworkResponse, result: Spotters?) {
                            val spotter = result ?: Spotters()
                            success(spotter)
                        }
                    }).build()

            CityInApp.requestQueue.add(request)
        }
    }
}