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

    var getArticlesUseCase : GetArticlesUseCase? = null
    [Inject] set

    {
        (articlesFragment.getActivity().getApplication() as Qiitlin).component?.inject(this)
    }

    override fun onResume() {
        EventBus.getDefault().register(this)
        getArticlesUseCase?.execute(0)
    }

    override fun onPause() {
        EventBus.getDefault().unregister(this)
    }

    fun onEventMainThread(event: GetArticlesUseCase.OnGot) {
        articlesFragment.initAdapter(event.aritlces)
    }
}