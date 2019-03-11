package myapp.com.cityin

import android.media.Image
import android.os.Parcel
import android.os.Parcelable
/*
data class Activity (var img: Image, var title: String = "", var price: String = "", val avis: String= "") : Parcelable{
    constructor(parcel: Parcel) : this(
            TODO("img"),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(price)
        parcel.writeString(avis)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Activity> {
        override fun createFromParcel(parcel: Parcel): Activity {
            return Activity(parcel)
        }

        override fun newArray(size: Int): Array<Activity?> {
            return arrayOfNulls(size)
        }
    }

}*/