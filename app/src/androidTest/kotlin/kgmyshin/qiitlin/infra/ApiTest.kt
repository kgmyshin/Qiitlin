package kgmyshin.qiitlin.infra

import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.infra.api.v2.ApiClient
import org.junit.Before
import org.junit.After
import org.junit.Test
import kotlin.test.*

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class ApiTest {

    Test fun testGetArticles() {
        val client = ApiClient()
        val articles = client.getQiitaApi().getArticles()
        assertNotEquals(0, articles.size())
    }

    Test fun testGetArticlesPage2() {
        val client = ApiClient()
        val articles = client.getQiitaApi().getArticles(2)
        assertNotEquals(0, articles.size())
    }

    Test fun testGetComments() {
        // http://qiita.com/kgmyshin/items/9299d785bea654fc98a2
        val client = ApiClient()
        val comments = client.getQiitaApi().getComments("9299d785bea654fc98a2")
        assertNotEquals(0, comments.size())
    }

    Test fun testGetTags() {
        val client = ApiClient()
        val tags = client.getQiitaApi().getTags()
        assertNotEquals(0, tags.size())
    }

    Test fun testGetTagsPage2() {
        val client = ApiClient()
        val tags = client.getQiitaApi().getTags(2)
        assertNotEquals(0, tags.size())
    }

}