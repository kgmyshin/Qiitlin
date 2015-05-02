package kgmyshin.qiitlin.domain.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by kgmyshin on 2015/05/02.
 */
data public class User(
        val id:String,
        val name:String,
        val description:String,
        [SerializedName("profile_image_url")] val profileImageUrl:String
)