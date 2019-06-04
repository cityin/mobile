package myapp.com.cityin.network.response

import android.os.Parcel
import android.os.Parcelable

class Spotters() : Parcelable {

    lateinit var thumbnailUrl: String
    lateinit var spotterId: String
    lateinit var username: String
    lateinit var email: String

    constructor(parcel: Parcel) : this() {
        thumbnailUrl = parcel.readString()
        spotterId = parcel.readString()
        username = parcel.readString()
        email = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(thumbnailUrl)
        parcel.writeString(spotterId)
        parcel.writeString(username)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Spotters> {
        override fun createFromParcel(parcel: Parcel): Spotters {
            return Spotters(parcel)
        }

        override fun newArray(size: Int): Array<Spotters?> {
            return arrayOfNulls(size)
        }
    }
}