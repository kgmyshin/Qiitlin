package kgmyshin.qiitlin.domain.entity

import com.google.gson.annotations.SerializedName
import java.util.ArrayList
import java.util.Date

/**
 * Created by kgmyshin on 2015/05/02.
 */
data public class Article(
        val id:String,
        val body:String,
        [SerializedName("rendered_body")] val renderedBody:String,
        val tags: ArrayList<Tag>,
        val title:String,
        val url:String,
        val user:User,
        [SerializedName("created_at")] val createdAt: Date
)