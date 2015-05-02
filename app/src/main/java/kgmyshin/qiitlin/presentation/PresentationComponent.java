package kgmyshin.qiitlin.presentation;

import dagger.Component;
import kgmyshin.qiitlin.presentation.presenter.ArticlesPresenter;

/**
 * Created by kgmyshin on 2015/05/03.
 */
public interface PresentationComponent {

    void inject(ArticlesPresenter instance);

}
