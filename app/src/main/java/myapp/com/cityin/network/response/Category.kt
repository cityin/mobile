package myapp.com.cityin.network.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Category {
    lateinit var icon: String
    lateinit var name: String
    lateinit var description: String
    lateinit var categoryId: String
    lateinit var thumbnailUrl: String
}