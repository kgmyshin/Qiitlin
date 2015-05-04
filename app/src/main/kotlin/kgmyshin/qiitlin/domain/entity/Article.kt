package kgmyshin.qiitlin.domain.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.ArrayList
import java.util.Date

/**
 * Created by kgmyshin on 2015/05/02.
 */
data public class Article() : Parcelable {

    var id: String? = null

    var body: String? = null

    SerializedName("rendered_body")
    var renderedBody: String? = null

    var tags: ArrayList<Tag>? = null

    var title: String? = null

    var url: String? = null

    var user: User? = null

    SerializedName("created_at")
    var createdAt: Date? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        body = parcel.readString()
        renderedBody = parcel.readString()
        tags = parcel.readParcelableArray(javaClass<Tag>().getClassLoader()).toArrayList() as ArrayList<Tag>
        title = parcel.readString()
        url = parcel.readString()
        user = parcel.readParcelable(javaClass<User>().getClassLoader())
        createdAt = parcel.readSerializable() as Date
    }

    companion object {
        val CREATOR = object : Parcelable.Creator<kgmyshin.qiitlin.domain.entity.Article> {
            override fun createFromParcel(parcel: Parcel): Article {
                return Article(parcel)
            }

            override fun newArray(size: Int): Array<Article> {
                return Array<Article>(size, { i -> Article() })
            }

        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(body)
        dest.writeString(renderedBody)
        dest.writeParcelableArray(Array(tags!!.size(), { it -> tags?.get(it)}), Parcelable.PARCELABLE_WRITE_RETURN_VALUE)
        dest.writeString(title)
        dest.writeString(url)
        dest.writeParcelable(user, Parcelable.PARCELABLE_WRITE_RETURN_VALUE)
        dest.writeSerializable(createdAt)
    }

}