package kgmyshin.qiitlin;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import kgmyshin.qiitlin.domain.DomainModule;
import kgmyshin.qiitlin.infra.InfraModule;

/**
 * Created by kgmyshin on 2015/05/02.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                DomainModule.class,
                InfraModule.class
        }
)
public interface AppComponent {

    void inject(Application instance);

}