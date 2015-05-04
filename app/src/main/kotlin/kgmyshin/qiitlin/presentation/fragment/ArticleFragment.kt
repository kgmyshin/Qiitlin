package kgmyshin.qiitlin.presentation.fragment

import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import butterknife.bindView
import kgmyshin.qiitlin.R
import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.extension.loadDateWithFrame
import kgmyshin.qiitlin.presentation.presenter.ArticlesPresenter
import kgmyshin.qiitlin.presentation.view.ArticleItemView
import kotlin.platform.platformStatic

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class ArticleFragment : Fragment() {

    val articleItemView: ArticleItemView by bindView(R.id.article_summary_view)
    val webView: WebView by bindView(R.id.webview)
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
        article = getArguments().getParcelable(BUNDLE_ARTICLE)
        if (Build.VERSION.SDK_INT >= 21) {
            articleItemView.setTransitionName("article_summary")
        }
        articleItemView.bindArticle(article!!)
        webView.setWebChromeClient(WebChromeClient());
        webView.setVerticalScrollbarOverlay(true);
        var settings = webView.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        webView.loadDateWithFrame(article?.renderedBody!!)
    }
}