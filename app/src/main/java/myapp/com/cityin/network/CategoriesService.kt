package myapp.com.cityin.network

import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import myapp.com.cityin.CityInApp
import myapp.com.cityin.network.response.Categories
import myapp.com.cityin.network.response.Category

class CategoriesService {
    companion object {
        fun getActivityCategories(success: (categories: Array<Category>) -> Unit,
                                  failure: (VolleyError?) -> Unit) {

            val url = UrlBuilder.getCategories()

            val request = BaseRequest.Builder<Categories>(Request.Method.GET,
                    url, Categories::class.java).listener(object: RequestListener<Categories> {
                override fun onSuccess(request: Request<Categories>, response: NetworkResponse, result: Categories?) {
                    val response = result?.categories ?: emptyArray()

                    success(response)
                }

                override fun onFailure(request: Request<Categories>, response: NetworkResponse?, error: VolleyError?) {
                    failure(error)
                }


            }).build()

            CityInApp.requestQueue.add(request)
        }
    }
}