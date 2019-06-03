package myapp.com.cityin.network

class UrlBuilder {
    companion object {
        val baseUrl = "https://zi2xbgt2s3.execute-api.eu-west-1.amazonaws.com/staging"
        val travelBand = "$baseUrl/travel-bands"
        val foldersUrl = "https://zi2xbgt2s3.execute-api.eu-west-1.amazonaws.com/staging/travel-bands/15a992e1-8d3f-421e-99a3-2ba5d2131d09/folders"
        val suggestionsUrl = "https://zi2xbgt2s3.execute-api.eu-west-1.amazonaws.com/staging/travel-bands/15a992e1-8d3f-421e-99a3-2ba5d2131d09/activities"
        fun getActivitiesByTravelBand(travelBandId: String): String {
            return "https://zi2xbgt2s3.execute-api.eu-west-1.amazonaws.com/staging/travel-bands/$travelBandId/activities"
        }
        fun getDetailsActivitiesByTravelBand(test: String): String {
            return "https://zi2xbgt2s3.execute-api.eu-west-1.amazonaws.com/staging/activities/$test"
        }
        fun getHighlightedAcvtivities(): String {
            return "$baseUrl/activities/highlights"
        }
        fun getCategories(): String {
            return "$baseUrl/categories"
        }
        fun searchActivities(query: String?): String {
            return "$baseUrl/activities?q=$query"
        }
    }
}