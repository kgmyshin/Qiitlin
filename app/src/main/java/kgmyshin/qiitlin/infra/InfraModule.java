package kgmyshin.qiitlin.infra;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kgmyshin.qiitlin.domain.repository.ArticleRepository;
import kgmyshin.qiitlin.domain.repository.CommentRepository;
import kgmyshin.qiitlin.domain.repository.TagRepository;
import kgmyshin.qiitlin.domain.repository.UserRepository;
import kgmyshin.qiitlin.infra.repository.ArticleRepositoryImpl;
import kgmyshin.qiitlin.infra.repository.CommentRepositoryImpl;
import kgmyshin.qiitlin.infra.repository.TagRepositoryImpl;
import kgmyshin.qiitlin.infra.repository.UserRepositoryImpl;

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

    @Provides
    @Singleton
    public CommentRepository provideCommentRepository() {
        return new CommentRepositoryImpl();
    }

    @Provides
    @Singleton
    public TagRepository provideTagRepository() {
        return new TagRepositoryImpl();
    }

    @Provides
    @Singleton
    public UserRepository provideUserRepository() {
        return new UserRepositoryImpl();
    }

}
