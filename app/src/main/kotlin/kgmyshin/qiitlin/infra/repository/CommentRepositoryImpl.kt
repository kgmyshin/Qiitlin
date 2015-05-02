package kgmyshin.qiitlin.infra.repository

import kgmyshin.qiitlin.domain.entity.Comment
import kgmyshin.qiitlin.domain.repository.CommentRepository
import java.util.ArrayList

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class CommentRepositoryImpl : CommentRepository {
    override fun findAll(articleId: String): ArrayList<Comment> {
        throw UnsupportedOperationException()
    }
}