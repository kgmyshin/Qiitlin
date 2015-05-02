package kgmyshin.qiitlin.domain.usecase

import kgmyshin.qiitlin.domain.entity.Article

/**
 * Created by kgmyshin on 2015/05/02.
 */
public trait GetArticlesUseCase : UseCase {

    class OnGot(val aritlces:List<Article>)

    fun execute(page:Int)
}