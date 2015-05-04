package kgmyshin.qiitlin.extension

import android.content.Context
import android.content.res.AssetManager
import android.webkit.WebView
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date

/**
 * Created by kgmyshin on 2015/05/03.
 */
fun Date.str() : String {
    val sdf = SimpleDateFormat("MM/dd HH:mm");
    return sdf.format(this)
}

fun Context.readAssetFile(path: String) : String {
    val assetManager: AssetManager = this.getResources().getAssets()
    val sb: StringBuilder = StringBuilder()
    val input: InputStream = assetManager.open(path)
    val br: BufferedReader = BufferedReader(InputStreamReader(input))
    var line: String? = null
    while (true) {
        line = br.readLine()
        if (line == null) {
            break
        }
        sb.append(line).append("\n")
    }
    br.close()
    input.close()
    return sb.toString()
}

fun WebView.loadDateWithFrame(body:String) {
    val wrap: String = this.getContext().readAssetFile("html/article.html")
    val doc: Document = Jsoup.parse(wrap)
    val org = doc.outerHtml()
    val elem: Element = doc.getElementById("content")
    elem.append(body)
    val html = doc.outerHtml()
    this.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "utf-8", null);
}