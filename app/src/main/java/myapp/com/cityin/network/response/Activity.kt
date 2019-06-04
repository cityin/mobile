package myapp.com.cityin.network.response

class Activity {
    var capacity = 0
    var nbVotes = 0
    var mark = 0
    var price = 0
    var duration = 0

    lateinit var office: Office
    lateinit var location: Location
    lateinit var services: Array<*>
    lateinit var reactions: Array<*>
    lateinit var folderId: String
    lateinit var pictures: Array<String>
    lateinit var activityId: String
    lateinit var name: String
    lateinit var languages: Array<String>
    lateinit var travelBandId: String
    lateinit var category: ActivityCategorie
    lateinit var description: String
    lateinit var id: String
}