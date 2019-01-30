package myapp.com.spotter.network.response

class Activity {
    var capacity = 0
    var price = 0
    var duration = 1

    lateinit var location: Location
    lateinit var services: Array<*>
    lateinit var category: String
    lateinit var activityId: String
    lateinit var description: String
    lateinit var picture: String
    lateinit var name: String
    lateinit var language: String
}