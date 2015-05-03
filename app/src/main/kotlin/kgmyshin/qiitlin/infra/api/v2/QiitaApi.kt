package kgmyshin.qiitlin.infra.api.v2

import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.domain.entity.Comment
import kgmyshin.qiitlin.domain.entity.Tag
import retrofit.http.GET
import retrofit.http.Path
import retrofit.http.Query

/**
 * Created by kgmyshin on 2015/05/02.
 */
public trait QiitaApi {

    [GET("/items?per_page=100")]
    fun getArticles() : List<Article>

    [GET("/items?per_page=100")]
    fun getArticles([Query("page")] page:Int) : List<Article>

    [GET("/items/{item_id}/comments?per_page=100")]
    fun getComments([Path("item_id")] itemId: String) : List<Comment>

    [GET("/items/{item_id}/comments?per_page=100")]
    fun getComments([Path("item_id")] itemId: String, [Query("page")] page:Int) : List<Comment>

    [GET("/tags?per_page=100")]
    fun getTags() : List<Tag>

    [GET("/tags?per_page=100")]
    fun getTags([Query("page")] page:Int) : List<Tag>
}