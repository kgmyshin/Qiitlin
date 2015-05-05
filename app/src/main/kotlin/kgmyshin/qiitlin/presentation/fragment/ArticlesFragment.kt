package kgmyshin.qiitlin.presentation.fragment

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.Toolbar
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AbsListView
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.RelativeLayout
import butterknife.bindView
import com.nineoldandroids.animation
import com.nineoldandroids.animation.Animator
import com.nineoldandroids.animation.ValueAnimator
import com.nineoldandroids.view.ViewHelper
import kgmyshin.qiitlin.R
import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.presentation.activity.ArticlesActivity
import kgmyshin.qiitlin.presentation.adapter.ArticleAdapter
import kgmyshin.qiitlin.presentation.presenter.ArticlesPresenter
import kotlin.platform.platformStatic

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class ArticlesFragment : Fragment() {

    val toolbar: Toolbar by bindView(R.id.toolbar)
    val listView: ListView by bindView(R.id.article_list_view)
    val swipeRefreshLayout: SwipeRefreshLayout by bindView(R.id.swipe_refresh)

    var adapter: ArticleAdapter? = null
    var toolbarVisiblity = true
    var articleActivity: ArticlesActivity? = null

    var articlePresenter: ArticlesPresenter? = null

    companion object {
        platformStatic fun newInstance(): Fragment = ArticlesFragment()
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        articleActivity = activity as ArticlesActivity
        articlePresenter = ArticlesPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_articles, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        toolbar.setTitle(R.string.app_name)
        //        toolbar.setNavigationIcon(...)
        //        toolbar.setNavigationOnClickListener {...}
        //        toolbar.inflateMenu(R.menu...)
        //        toolbar.setOnMenuItemClickListener {...}

        adapter = ArticleAdapter(getActivity())
        listView.setAdapter(adapter)
        listView.setOnScrollListener(object : AbsListView.OnScrollListener {
            var lastPos = 0
            override fun onScroll(absListView: AbsListView, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                if (totalItemCount != 0 && totalItemCount == firstVisibleItem + visibleItemCount) {
                    articlePresenter?.onListBottom()
                }
                if (lastPos > firstVisibleItem) {
                    if (firstVisibleItem != 0) {
                        updateToolbarVisibility(ScrollState.Up)
                    } else {
                        updateToolbarVisibility(ScrollState.Stop)
                    }
                } else if (lastPos < firstVisibleItem) {
                    updateToolbarVisibility(ScrollState.Down)
                }
                lastPos = firstVisibleItem
            }

            override fun onScrollStateChanged(absListView: AbsListView, i: Int) {
            }
        })
        listView.setOnItemClickListener {(adapterView, view, i, l) -> articleActivity?.moveArticle(view, adapter!!.getItem(i)) }
        swipeRefreshLayout.setColorSchemeResources(R.color.blue_500, R.color.yellow_500, R.color.red_500);
        swipeRefreshLayout.setOnRefreshListener { articlePresenter?.onRefresh() }
    }

    override fun onResume() {
        super.onResume()
        articlePresenter?.onResume()
    }

    override fun onPause() {
        super.onPause()
        articlePresenter?.onPause()
    }

    public fun update(articles: List<Article>) {
        if (swipeRefreshLayout.isRefreshing()) {
            adapter?.clear()
            swipeRefreshLayout.setRefreshing(false)
        }
        adapter?.addAll(articles)
        adapter?.notifyDataSetChanged()
    }

    private fun showToolbar() {
        toolbarVisiblity = true
        moveToolbar(0F);
    }

    private fun hideToolbar() {
        toolbarVisiblity = false
        moveToolbar(-toolbar.getHeight().toFloat());
    }

    private fun moveToolbar(toTranslationY: Float) {
        if (toolbar.getTranslationY() == toTranslationY) {
            return
        }
        val animator = ValueAnimator.ofFloat(ViewHelper.getTranslationY(toolbar), toTranslationY).setDuration(200)
        animator.addUpdateListener {
            animation: ValueAnimator ->
            val translationY = animation.getAnimatedValue() as Float
            ViewHelper.setTranslationY(toolbar, translationY)
            ViewHelper.setTranslationY(swipeRefreshLayout, translationY)
            val lp = swipeRefreshLayout.getLayoutParams() as FrameLayout.LayoutParams
            lp.height = (-translationY + getScreenHeight() - lp.topMargin).toInt()
            swipeRefreshLayout.requestLayout()
        }
        animator.start()

    }

    private fun getScreenHeight(): Int {
        val activity = getActivity();
        if (activity == null) {
            return 0;
        }
        return activity.findViewById(android.R.id.content).getHeight();
    }

    private fun updateToolbarVisibility(state: ScrollState) {
        if (state == ScrollState.Up) {
            if (toolbarVisiblity) {
                hideToolbar();
            }
        } else if (state == ScrollState.Down) {
            if (!toolbarVisiblity) {
                showToolbar();
            }
        } else if (state == ScrollState.Stop) {
            if (!toolbarVisiblity) {
                showToolbar();
            }
        }
    }

    enum class ScrollState {
        Up
        Down
        Stop
    }
}