package myapp.com.cityin.network

class UrlBuilder {
    companion object {
        val baseUrl = "https://zi2xbgt2s3.execute-api.eu-west-1.amazonaws.com/staging"
        val travelBand = "${baseUrl}/travel-bands"
        fun getActivitiesByTravelBand(travelBandId: String): String {
            return "https://zi2xbgt2s3.execute-api.eu-west-1.amazonaws.com/staging/travel-bands/$travelBandId/activities"
        }
        fun getSpotterByTravelBand(travelBandId: String): String {
            return "https://zi2xbgt2s3.execute-api.eu-west-1.amazonaws.com/staging/travel-bands/$travelBandId/spotters"
        }
        fun getDetailsActivitiesByTravelBand(activityId: String): String {
            return "https://zi2xbgt2s3.execute-api.eu-west-1.amazonaws.com/staging/activities/$activityId"
        }
        fun getAddSpottersTravelBand(name: String): String {
            return "https://zi2xbgt2s3.execute-api.eu-west-1.amazonaws.com/staging/spotters?q=$name"
        }
    }
}