package kgmyshin.qiitlin.infra.repository

import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.domain.repository.ArticleRepository
import java.util.ArrayList

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class ArticleRepositoryImpl : ArticleRepository {

    override fun findAll(): ArrayList<Article> {
        throw UnsupportedOperationException()
    }

}