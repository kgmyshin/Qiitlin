package kgmyshin.qiitlin.presentation.fragment

import android.app.Fragment
import kotlin.platform.platformStatic

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class ArticleFragment : Fragment() {

    companion object  {
        platformStatic fun newInstance(): Fragment =  ArticleFragment()
    }

}