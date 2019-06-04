package myapp.com.cityin.network

import android.util.Log
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import myapp.com.cityin.CityInApp
import myapp.com.cityin.network.response.Folder
import okhttp3.Headers
import java.lang.reflect.Parameter
import com.neopixl.spitfire.model.RequestData
import java.util.*


class FoldersService {
    companion object {
        fun getFolders(success: (folders: Array<Folder>) -> Unit,
                       failure: (VolleyError?) -> Unit) {
            val url = UrlBuilder.travelBand
            val headers = HashMap<String, String>()
            headers.put("X-Spotter", CityInApp.spotterId)

            val request = BaseRequest.Builder<Array<Folder>>(Request.Method.GET,
                    url, Array<Folder>::class.java).headers(headers).listener(object: RequestListener<Array<Folder>> {
                override fun onSuccess(request: Request<Array<Folder>>, response: NetworkResponse, result: Array<Folder>?) {
                    val folders = result ?: emptyArray()
                    success(folders)
                }

                override fun onFailure(request: Request<Array<Folder>>, response: NetworkResponse?, error: VolleyError?) {
                    failure(error)
                }

            }).build()

            CityInApp.requestQueue.add(request)
        }
        fun getFoldersWhislist(success: (folders: Array<Folder>) -> Unit,
                       failure: (VolleyError?) -> Unit) {
            val url = UrlBuilder.travelBand
            val headers = HashMap<String, String>()
            headers.put("X-Spotter", CityInApp.spotterId)

            val request = BaseRequest.Builder<Array<Folder>>(Request.Method.GET,
                    url, Array<Folder>::class.java).headers(headers).listener(object: RequestListener<Array<Folder>> {
                override fun onSuccess(request: Request<Array<Folder>>, response: NetworkResponse, result: Array<Folder>?) {
                    val folders = result ?: emptyArray()
                    success(folders)
                }

                override fun onFailure(request: Request<Array<Folder>>, response: NetworkResponse?, error: VolleyError?) {
                    failure(error)
                }

            }).build()

            CityInApp.requestQueue.add(request)
        }

        fun createTravelBand(name: String, description: String, success: (travelBand: Folder) -> Unit, failure: (VolleyError?) -> Unit) {
            val payload = hashMapOf("name" to name, "description" to description)

            val url = UrlBuilder.travelBand
            val headers = HashMap<String, String>()
            headers.put("X-Spotter", CityInApp.spotterId)

            val request = BaseRequest.Builder<Folder>(Request.Method.POST, url, Folder::class.java)
                    .headers(headers)
                    .json(payload)
                    .listener(object: RequestListener<Folder> {
                override fun onSuccess(request: Request<Folder>, response: NetworkResponse, result: Folder?) {
                    val travelBand = result ?: Folder()
                    success(travelBand)
                }

                override fun onFailure(request: Request<Folder>, response: NetworkResponse?, error: VolleyError?) {
                    failure(error)
                }
            }).build()

            CityInApp.requestQueue.add(request)
        }
    }
}