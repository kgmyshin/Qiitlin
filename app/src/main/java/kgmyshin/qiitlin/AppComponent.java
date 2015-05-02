package kgmyshin.qiitlin;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import kgmyshin.qiitlin.domain.DomainModule;
import kgmyshin.qiitlin.infra.InfraModule;
import kgmyshin.qiitlin.presentation.PresentationComponent;

/**
 * Created by kgmyshin on 2015/05/02.
 */
@Singleton
@Component(
        modules = {
                InfraModule.class,
                DomainModule.class,
                AppModule.class
        }
)
public interface AppComponent extends PresentationComponent {
}