package myapp.com.cityin.network

import android.util.Log
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import myapp.com.cityin.CityInApp
import myapp.com.cityin.network.response.*

class ActivitiesService {
    companion object {
        fun getActivitiesByTravelBandId(folderdId: String, success: (activities: Array<Activity>) -> Unit,
                failure: (VolleyError?) -> Unit) {
            val url = UrlBuilder.getActivitiesByTravelBand(folderdId)

            val request = BaseRequest.Builder<Array<Activity>>(Request.Method.GET,
                    url, Array<Activity>::class.java).listener(object: RequestListener<Array<Activity>> {
                override fun onFailure(request: Request<Array<Activity>>, response: NetworkResponse?, error: VolleyError?) {
                    failure(error)
                }

                override fun onSuccess(request: Request<Array<Activity>>, response: NetworkResponse, result: Array<Activity>?) {
                    val activities = result ?: emptyArray()

                    success(activities)
                }
            }).build()

            CityInApp.requestQueue.add(request)
        }

        fun getDetailsActivitiesByTravelBand(activityId: String, success: (activities: ActivityDetails) -> Unit,
                                             failure: (VolleyError?) -> Unit) {
            val url = UrlBuilder.getDetailsActivitiesByTravelBand(activityId)

            val request = BaseRequest.Builder<ActivityDetails>(Request.Method.GET,
                    url, ActivityDetails::class.java).listener(object: RequestListener<ActivityDetails> {
                override fun onFailure(request: Request<ActivityDetails>, response: NetworkResponse?, error: VolleyError?) {
                    failure(error)
                }

                override fun onSuccess(request: Request<ActivityDetails>, response: NetworkResponse, result: ActivityDetails?) {
                    val activities = result ?: ActivityDetails()

                    success(activities)
                }
            }).build()

            CityInApp.requestQueue.add(request)

        }

        fun getHighlightedActivities(success: (activities: Array<Activity>) -> Unit,
                                     failure: (VolleyError?) -> Unit) {
            val url = UrlBuilder.getHighlightedAcvtivities()

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

        fun searchActivitiesByQueryText(query: String?, categoryId: String?, success: (activities: Array<Activity>) -> Unit,
                                        failure: (VolleyError?) -> Unit) {
            val url = UrlBuilder.searchActivities(query, categoryId)
            Log.d("test", url)

            val request = BaseRequest.Builder<Activities>(Request.Method.GET,
                    url, Activities::class.java).listener(object: RequestListener<Activities> {

                override fun onSuccess(request: Request<Activities>, response: NetworkResponse, result: Activities?) {
                    val response = result?.activities ?: emptyArray()

                    success(response)
                }

                override fun onFailure(request: Request<Activities>, response: NetworkResponse?, error: VolleyError?) {
                    failure(error)
                }


            }).build()

            CityInApp.requestQueue.add(request)
        }

        fun shareActivityToTravelBand(activityId: String,
                                      travelBandId: String,
                                      success: (activity: Activity) -> Unit,
                                      failure: (VolleyError?) -> Unit) {

            val url = UrlBuilder.shareActivity(activityId)

            val body = hashMapOf("travelBandId" to travelBandId)

            val request = BaseRequest.Builder<ShareActivityResponse>(Request.Method.POST, url, ShareActivityResponse::class.java)
                    .json(body)
                    .listener(object: RequestListener<ShareActivityResponse> {
                        override fun onSuccess(request: Request<ShareActivityResponse>, response: NetworkResponse, result: ShareActivityResponse?) {
                            val response = result?.activity ?: Activity()

                            success(response)
                        }

                        override fun onFailure(request: Request<ShareActivityResponse>, response: NetworkResponse?, error: VolleyError?) {
                            failure(error)
                        }
                    }).build()

            CityInApp.requestQueue.add(request)
        }
    }
}