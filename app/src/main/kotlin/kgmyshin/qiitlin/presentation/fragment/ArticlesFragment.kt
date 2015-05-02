package kgmyshin.qiitlin.presentation.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import butterknife.bindView
import kgmyshin.qiitlin.R
import kotlin.platform.platformStatic

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class ArticlesFragment : Fragment() {

    val listView: ListView by bindView(R.id.article_list_view)

    companion object  {
        platformStatic fun newInstance(): Fragment =  ArticlesFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_articles, container, false)
        return view
    }
}