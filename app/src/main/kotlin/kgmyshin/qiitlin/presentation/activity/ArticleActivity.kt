package kgmyshin.qiitlin.presentation.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import kgmyshin.qiitlin.R
import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.presentation.fragment.ArticleFragment
import kgmyshin.qiitlin.presentation.fragment.ArticlesFragment
import kotlin.platform.platformStatic

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class ArticleActivity : Activity() {

    companion object {
        val INTENT_EXTRA_ARTICLE = "article"
        platformStatic fun start(context: Context, article: Article, options:Bundle) {
            val intent = Intent(context, javaClass<ArticleActivity>())
            intent.putExtra(INTENT_EXTRA_ARTICLE, article)
            context.startActivity(intent, options)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val manager = getFragmentManager()
        manager.beginTransaction().add(R.id.container, ArticleFragment.newInstance(getIntent().getParcelableExtra(INTENT_EXTRA_ARTICLE))).commit()
    }
}