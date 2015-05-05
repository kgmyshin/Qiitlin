package kgmyshin.qiitlin.presentation.presenter

import de.greenrobot.event.EventBus
import kgmyshin.qiitlin.Qiitlin
import kgmyshin.qiitlin.domain.usecase.GetArticlesUseCase
import kgmyshin.qiitlin.presentation.fragment.ArticlesFragment
import javax.inject.Inject

/**
 * Created by kgmyshin on 2015/05/03.
 */
public class ArticlesPresenter(
        val articlesFragment: ArticlesFragment
) : Presenter {

    private var next_page = 1

    private var getArticlesUseCase: GetArticlesUseCase? = null
        [Inject] set

    init {
        (articlesFragment.getActivity().getApplication() as Qiitlin).component?.inject(this)
    }

    override fun onResume() {
        EventBus.getDefault().register(this)
        fetchArticles()
    }

    override fun onPause() {
        EventBus.getDefault().unregister(this)
    }

    public fun onListBottom() {
        fetchArticles()
    }

    public fun onRefresh() {
        next_page = 1
        fetchArticles()
    }

    fun fetchArticles() {
        getArticlesUseCase?.execute(next_page)
    }

    fun onEventMainThread(event: GetArticlesUseCase.OnGot) {
        articlesFragment.update(event.aritlces)
        next_page++
    }
}