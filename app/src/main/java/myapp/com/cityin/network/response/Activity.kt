package myapp.com.cityin.network.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Activity {
    var price = 0
    var highlighted = false

    lateinit var office: Office
    lateinit var location: Location
    lateinit var pictures: Array<String>
    lateinit var activityId: String
    lateinit var name: String
    lateinit var languages: Array<String>
    lateinit var travelBandId: String
    lateinit var category: ActivityCategorie
    lateinit var description: String
    lateinit var reactions: MutableList<Spotters>
}