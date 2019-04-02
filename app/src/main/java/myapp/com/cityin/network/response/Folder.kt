package myapp.com.cityin.network.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty


@JsonIgnoreProperties(ignoreUnknown = true)
class Folder {
    var activityCount = 0

    lateinit var name: String
    lateinit var description: String
    lateinit var travelBandId: String
    lateinit var thumbnailUrl: String
    lateinit var folders: Array<*>
    lateinit var spotters: Array<*>
}