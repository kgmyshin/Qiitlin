package kgmyshin.qiitlin.presentation.activity

import android.animation.ValueAnimator
import android.app.Activity
import android.app.FragmentManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kgmyshin.qiitlin.R
import kgmyshin.qiitlin.presentation.fragment.ArticlesFragment

public class ArticlesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)

        val manager = getFragmentManager()
        manager.beginTransaction().add(R.id.container, ArticlesFragment.newInstance()).commit()
    }

}