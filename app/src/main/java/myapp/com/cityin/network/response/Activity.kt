package myapp.com.cityin.network.response

class Activity {
    var capacity = 0
    var nbVotes = 0
    var mark = 0
    var price = 0
    var duration = 0

    lateinit var location: Location
    lateinit var services: Array<*>
    lateinit var folderId: String
    lateinit var pictures: Array<String>
    lateinit var activityId: String
    lateinit var name: String
    lateinit var language: String
    lateinit var travelBandId: String
    lateinit var category: String
    lateinit var description: String
    lateinit var id: String
}