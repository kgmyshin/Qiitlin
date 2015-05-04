package kgmyshin.qiitlin.presentation.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.presentation.view.ArticleItemView

/**
 * Created by kgmyshin on 2015/05/03.
 */
public class ArticleAdapter(context: Context) : ArrayAdapter<Article>(context, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val article = getItem(position)
        var view: ArticleItemView? = null
        if (convertView != null) {
            view = convertView as ArticleItemView
        } else {
            view = ArticleItemView(getContext())
        }
        view?.bindArticle(article)
        return view
    }
}