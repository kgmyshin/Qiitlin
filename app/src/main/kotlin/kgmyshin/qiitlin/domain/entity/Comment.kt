package kgmyshin.qiitlin.domain.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class Comment() : Parcelable {

    var id: String? = null

    var body: String? = null

    constructor(parcelIn: Parcel) : this() {
        id = parcelIn.readString()
        body = parcelIn.readString()
    }

    companion object {
        val CREATOR = object : Parcelable.Creator<kgmyshin.qiitlin.domain.entity.Comment> {
            override fun createFromParcel(parcel: Parcel): Comment {
                return Comment(parcel)
            }

            override fun newArray(size: Int): Array<Comment> {
                return Array<Comment>(size, { i -> Comment() })
            }
        }
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(body)
    }

    override fun describeContents(): Int {
        return 0
    }

}