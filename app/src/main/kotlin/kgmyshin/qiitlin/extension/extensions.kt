package kgmyshin.qiitlin.extension

import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by kgmyshin on 2015/05/03.
 */
fun Date.str() : String {
    val sdf = SimpleDateFormat("MM/dd HH:mm");
    return sdf.format(this)
}
