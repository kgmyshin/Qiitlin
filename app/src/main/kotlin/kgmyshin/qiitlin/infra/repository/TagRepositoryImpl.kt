package kgmyshin.qiitlin.infra.repository

import kgmyshin.qiitlin.domain.entity.Tag
import kgmyshin.qiitlin.domain.repository.TagRepository
import java.util.ArrayList

/**
 * Created by kgmyshin on 2015/05/02.
 */
public class TagRepositoryImpl : TagRepository {
    override fun findAll(): ArrayList<Tag> {
        throw UnsupportedOperationException()
    }
}