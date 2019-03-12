package myapp.com.cityin.network

import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import myapp.com.cityin.CityInApp
import myapp.com.cityin.network.response.Folder

class FoldersService {
    companion object {
        fun getFolders(success: (folders: Array<Folder>) -> Unit,
                       failure: (VolleyError?) -> Unit) {
            val url = UrlBuilder.foldersUrl

            val request = BaseRequest.Builder<Array<Folder>>(Request.Method.GET,
                    url, Array<Folder>::class.java).listener(object: RequestListener<Array<Folder>> {
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
    }
}