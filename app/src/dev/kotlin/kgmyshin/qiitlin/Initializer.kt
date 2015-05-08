package kgmyshin.qiitlin

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import kotlin.platform.platformStatic

/**
 * Created by kgmyshin on 2015/05/09.
 */
public class Initializer {

    companion object {
        platformStatic fun init(app: Application) {
            LeakCanary.install(app);
        }
    }

}