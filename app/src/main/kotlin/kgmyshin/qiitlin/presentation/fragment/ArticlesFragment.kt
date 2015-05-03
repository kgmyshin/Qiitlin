package kgmyshin.qiitlin.presentation.fragment

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
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
    val swipeRefreshLayout: SwipeRefreshLayout by bindView(R.id.swipe_refresh)
    var adapter : ArticleAdapter? = null

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = ArticleAdapter(getActivity())
        listView.setAdapter(adapter)
        listView.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScroll(absListView:AbsListView, firstVisibleItem:Int, visibleItemCount:Int, totalItemCount:Int) {
                if (totalItemCount != 0 && totalItemCount == firstVisibleItem + visibleItemCount) {
                    articlePresenter?.onListBottom()
                }
            }
            override fun onScrollStateChanged(absListView:AbsListView, i:Int) {
            }
        })
        swipeRefreshLayout.setColorSchemeResources(R.color.blue_500, R.color.yellow_500, R.color.red_500);
        swipeRefreshLayout.setOnRefreshListener {articlePresenter?.onRefresh()}
    }

    override fun onResume() {
        super.onResume()
        articlePresenter?.onResume()
    }

    override fun onPause() {
        super.onPause()
        articlePresenter?.onPause()
    }

    public fun update(articles:List<Article>) {
        if (swipeRefreshLayout.isRefreshing()) {
            adapter?.clear()
            swipeRefreshLayout.setRefreshing(false)
        }
        adapter?.addAll(articles)
        adapter?.notifyDataSetChanged()
    }

}