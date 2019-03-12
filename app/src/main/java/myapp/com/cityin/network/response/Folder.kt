package myapp.com.cityin.network.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty


@JsonIgnoreProperties(ignoreUnknown = true)
class Folder {
    var nbActivities = 0

    @JsonProperty(value = "isDefault")
    var isDefault: Boolean = false

    lateinit var name: String
    lateinit var description: String
    lateinit var folderId: String
    lateinit var thumbnailUrl: String
}