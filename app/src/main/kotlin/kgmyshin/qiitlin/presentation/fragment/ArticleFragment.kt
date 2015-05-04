package kgmyshin.qiitlin.presentation.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import kgmyshin.qiitlin.R
import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.presentation.presenter.ArticlesPresenter
import kgmyshin.qiitlin.presentation.view.ArticleItemView
import kotlin.platform.platformStatic

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class ArticleFragment : Fragment() {

    val articleItemView: ArticleItemView by bindView(R.id.article_summary_view)
    var article: Article? = null

    companion object  {
        val BUNDLE_ARTICLE = "article"
        platformStatic fun newInstance(article: Article): Fragment {
            val fragment = ArticleFragment()
            val bundle = Bundle()
            bundle.putParcelable(BUNDLE_ARTICLE, article)
            fragment.setArguments(bundle)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_article, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        articleItemView.setTransitionName("article_summary")
        articleItemView.bindArticle(getArguments().getParcelable(BUNDLE_ARTICLE))
    }
}