package kgmyshin.qiitlin.domain.repository

import kgmyshin.qiitlin.domain.entity.Comment
import java.util.ArrayList

/**
 * Created by kgmyshin on 2015/05/02.
 */
public trait CommentRepository {

    fun findAll(articleId:String) : ArrayList<Comment>

}