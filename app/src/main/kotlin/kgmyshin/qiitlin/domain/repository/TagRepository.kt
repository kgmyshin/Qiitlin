package kgmyshin.qiitlin.domain.repository

import kgmyshin.qiitlin.domain.entity.Tag
import java.util.ArrayList

/**
 * Created by kgmyshin on 2015/05/02.
 */
public trait TagRepository {

    fun findAll() : ArrayList<Tag>

}