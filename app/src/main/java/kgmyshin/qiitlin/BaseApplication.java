package kgmyshin.qiitlin;

import android.app.Application;

import kgmyshin.qiitlin.AppComponent;
import kgmyshin.qiitlin.AppModule;
import kgmyshin.qiitlin.DaggerAppComponent;
import kgmyshin.qiitlin.domain.DomainModule;
import kgmyshin.qiitlin.infra.InfraModule;

/**
 * Created by kgmyshin on 2015/05/02.
 */
public abstract class BaseApplication extends Application {

    protected AppComponent createAppComponent() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .domainModule(new DomainModule())
                .infraModule(new InfraModule())
                .infraModule(new InfraModule())
                .build();
    }

}
