package kgmyshin.qiitlin.domain;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kgmyshin.qiitlin.domain.repository.ArticleRepository;
import kgmyshin.qiitlin.domain.usecase.GetArticlesUseCase;
import kgmyshin.qiitlin.domain.usecase.GetArticlesUseCaseImpl;

/**
 * Created by kgmyshin on 2015/05/02.
 */
@Module
public class DomainModule {

    @Provides
    @Singleton
    public GetArticlesUseCase provideGetArticlesUseCase(ArticleRepository articleRepository) {
        return new GetArticlesUseCaseImpl(articleRepository);
    }

}
