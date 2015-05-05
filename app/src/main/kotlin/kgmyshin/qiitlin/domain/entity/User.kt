package kgmyshin.qiitlin.domain.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by kgmyshin on 2015/05/02.
 */
data public class User() : Parcelable {

    var id: String? = null

    var name: String? = null

    var description: String? = null

    [SerializedName("profile_image_url")]
    var profileImageUrl: String? = null

    constructor(parcelIn: Parcel) : this() {
        id = parcelIn.readString()
        name = parcelIn.readString()
        description = parcelIn.readString()
        profileImageUrl = parcelIn.readString()
    }

    companion object {
        val CREATOR = object : Parcelable.Creator<kgmyshin.qiitlin.domain.entity.User> {
            override fun createFromParcel(parcel: Parcel): User {
                return User(parcel)
            }

            override fun newArray(size: Int): Array<User> {
                return Array<User>(size, { i -> User() })
            }
        }
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(name)
        dest.writeString(description)
        dest.writeString(profileImageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

}
