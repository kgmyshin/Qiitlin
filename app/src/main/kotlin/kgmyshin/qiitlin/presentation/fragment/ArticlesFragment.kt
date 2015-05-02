package kgmyshin.qiitlin.presentation.fragment

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import butterknife.bindView
import kgmyshin.qiitlin.R
import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.presentation.adapter.ArticleAdapter
import kgmyshin.qiitlin.presentation.presenter.ArticlesPresenter
import kotlin.platform.platformStatic

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class ArticlesFragment : Fragment() {

    val listView: ListView by bindView(R.id.article_list_view)

    var articlePresenter : ArticlesPresenter? = null

    companion object  {
        platformStatic fun newInstance(): Fragment =  ArticlesFragment()
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        articlePresenter = ArticlesPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_articles, container, false)
        return view
    }

    override fun onResume() {
        super.onResume()
        articlePresenter?.onResume()
    }

    override fun onPause() {
        super.onPause()
        articlePresenter?.onPause()
    }

    public fun initAdapter(articles:List<Article>) {
        val adapter = ArticleAdapter(getActivity())
        adapter.addAll(articles)
        listView.setAdapter(adapter)
    }

}