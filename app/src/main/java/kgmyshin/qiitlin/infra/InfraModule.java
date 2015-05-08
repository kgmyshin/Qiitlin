package kgmyshin.qiitlin.infra;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kgmyshin.qiitlin.domain.repository.ArticleRepository;
import kgmyshin.qiitlin.infra.repository.ArticleRepositoryImpl;

/**
 * Created by kgmyshin on 2015/05/02.
 */
@Module
public class InfraModule {

    @Provides
    @Singleton
    public ArticleRepository provideArticleRepository() {
        return new ArticleRepositoryImpl();
    }

}
