package myapp.com.cityin.network.response

class ActivityDetails {

    var capacity = 0
    var nbVotes = 0
    var mark = 0
    var price = 0
    var duration = 0
    var highlighted = false

    lateinit var office: Office
    lateinit var location: Location
    lateinit var services: Array<*>
    lateinit var pictures: Array<String>
    lateinit var activityId: String
    lateinit var name: String
    lateinit var languages: Array<String>
    lateinit var category: ActivityCategorie
    lateinit var description: String
    lateinit var travelBandId: String
    lateinit var id: String
    lateinit var availabilities: Array<*>
}