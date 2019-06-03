package myapp.com.cityin.network.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Activity {
    var capacity = 0
    var nbVotes = 0
    var mark = 0
    var price = 0
    var duration = 0
    var highlighted = false

    lateinit var office: Office
    lateinit var location: Location
    lateinit var services: Array<*>
    lateinit var folderId: String
    lateinit var pictures: Array<String>
    lateinit var activityId: String
    lateinit var name: String
    lateinit var language: Array<String>
    lateinit var travelBandId: String
    lateinit var category: Category
    lateinit var description: String
    lateinit var id: String
}