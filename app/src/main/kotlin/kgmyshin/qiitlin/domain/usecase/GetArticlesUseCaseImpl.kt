package kgmyshin.qiitlin.domain.usecase

import de.greenrobot.event.EventBus
import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.domain.repository.ArticleRepository
import java.util
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class GetArticlesUseCaseImpl(
        val articleRepository: ArticleRepository
) : GetArticlesUseCase {

    val executor: ExecutorService = Executors.newSingleThreadExecutor()
    var page: Int = 1

    override fun execute(page: Int) {
        this.page = page
        executor.submit(this)
    }

    override fun run() {
        if (page < 100) {
            val articles = articleRepository.findAll(page)
            val event = GetArticlesUseCase.OnGot(articles)
            EventBus.getDefault().post(event)
        }
    }

}