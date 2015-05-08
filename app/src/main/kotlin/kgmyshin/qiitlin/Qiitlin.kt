package kgmyshin.qiitlin

import kgmyshin.qiitlin.AppComponent

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class Qiitlin : BaseApplication() {

    public var component : AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        Initializer.init(this)
        component = createAppComponent()
    }

}