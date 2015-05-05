package kgmyshin.qiitlin.domain.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class Tag() : Parcelable {

    var id: String? = null

    var name: String? = null

    constructor(parcelIn: Parcel) : this() {
        id = parcelIn.readString()
        name = parcelIn.readString()
    }

    companion object {
        val CREATOR = object : Parcelable.Creator<kgmyshin.qiitlin.domain.entity.Tag> {
            override fun createFromParcel(parcel: Parcel): Tag {
                return Tag(parcel)
            }

            override fun newArray(size: Int): Array<Tag> {
                return Array<Tag>(size, { i -> Tag() })
            }
        }
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

}