package kgmyshin.qiitlin.presentation.activity

import android.app.Activity
import android.app.FragmentManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kgmyshin.qiitlin.R
import kgmyshin.qiitlin.presentation.fragment.ArticlesFragment

public class ArticlesActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
        val manager = getFragmentManager()
        manager.beginTransaction().add(R.id.container, ArticlesFragment.newInstance()).commit()
    }

}