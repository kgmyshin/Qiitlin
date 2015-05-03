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
        val articlesFragment : ArticlesFragment
) : Presenter {

    var next_page = 1

    var getArticlesUseCase : GetArticlesUseCase? = null
    [Inject] set

    {
        (articlesFragment.getActivity().getApplication() as Qiitlin).component?.inject(this)
    }

    override fun onResume() {
        EventBus.getDefault().register(this)
        fetchArticles()
    }

    override fun onPause() {
        EventBus.getDefault().unregister(this)
    }

    fun fetchArticles() {
        getArticlesUseCase?.execute(next_page)
    }

    public fun onListBottom() {
        fetchArticles()
    }

    fun onEventMainThread(event: GetArticlesUseCase.OnGot) {
        articlesFragment.initAdapter(event.aritlces)
        next_page++
    }
}