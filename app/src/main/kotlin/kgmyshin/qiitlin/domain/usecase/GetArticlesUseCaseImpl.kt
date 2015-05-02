package kgmyshin.qiitlin.domain.usecase

import de.greenrobot.event.EventBus
import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.domain.repository.ArticleRepository
import java.util

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class GetArticlesUseCaseImpl(
        val articleRepository : ArticleRepository
) : GetArticlesUseCase {

    override fun execute(page:Int) {
        val articles = articleRepository.findAll(page)
        val event = GetArticlesUseCase.OnGot(articles)
        EventBus.getDefault().post(event)
    }

}