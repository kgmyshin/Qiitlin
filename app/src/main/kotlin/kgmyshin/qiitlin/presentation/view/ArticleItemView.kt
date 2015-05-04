package kgmyshin.qiitlin.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import butterknife.bindView
import com.bumptech.glide.Glide
import jp.wasabeef.glide.transformations.CropCircleTransformation
import kgmyshin.qiitlin.R
import kgmyshin.qiitlin.domain.entity.Article
import kgmyshin.qiitlin.domain.entity.Tag
import kgmyshin.qiitlin.extension.str

/**
 * Created by kgmyshin on 2015/05/03.
 */
public class ArticleItemView : RelativeLayout {

    constructor(ctx: Context) : super(ctx) {
    }

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs) {
    }

    init {
        LayoutInflater.from(getContext()).inflate(R.layout.view_article_item, this)
    }

    val userImageView: ImageView by bindView(R.id.user_image_view)
    val titleView: TextView by bindView(R.id.title_text_view)
    val tagsView: TextView by bindView(R.id.tags_text_view)
    val timeView: TextView by bindView(R.id.time_text_view)

    public fun bindArticle(article: Article) {
        Glide.with(getContext()).load(article.user?.profileImageUrl).bitmapTransform(CropCircleTransformation(Glide.get(getContext()).getBitmapPool())).into(userImageView)
        titleView.setText(article.title)
        tagsView.setText(article.tags?.map { it.name!! }!!.join(" "))
        timeView.setText(article.createdAt?.str())
    }

}