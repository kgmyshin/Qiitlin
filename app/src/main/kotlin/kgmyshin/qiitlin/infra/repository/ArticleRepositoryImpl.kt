package kgmyshin.qiitlin.infra.repository

import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.domain.repository.ArticleRepository
import kgmyshin.qiitlin.infra.api.v2.ApiClient

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class ArticleRepositoryImpl : ArticleRepository {

    override fun findAll(page: Int): List<Article> {
        val client = ApiClient()
        if (page != 0 || page != 1) {
            return client.getQiitaApi().getArticles()
        } else {
            return client.getQiitaApi().getArticles(page)
        }
    }

}