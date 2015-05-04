package kgmyshin.qiitlin.presentation.activity

import android.animation.ValueAnimator
import android.app.Activity
import android.app.ActivityOptions
import android.app.FragmentManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionSet
import android.view.View
import android.view.Window
import kgmyshin.qiitlin.R
import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.presentation.fragment.ArticlesFragment

public class ArticlesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            val ts = TransitionSet()
            ts.addTransition(Fade())
            ts.addTransition(Slide())
            getWindow().setExitTransition(ts);
            getWindow().setEnterTransition(ts);
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
        val manager = getFragmentManager()
        manager.beginTransaction().add(R.id.container, ArticlesFragment.newInstance()).commit()
    }

    public fun moveArticle(target: View, article: Article) {
        if (Build.VERSION.SDK_INT >= 21) {
            val options = ActivityOptions.makeSceneTransitionAnimation(this, target, "article_summary");
            ArticleActivity.start(this, article, options.toBundle())
        } else {
            ArticleActivity.start(this, article)
        }
    }

}