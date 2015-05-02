package kgmyshin.qiitlin.domain.repository

import kgmyshin.qiitlin.domain.entity.Article

/**
 * Created by kgmyshin on 2015/05/02.
 */
public trait ArticleRepository {

    fun findAll(page:Int) : List<Article>

}