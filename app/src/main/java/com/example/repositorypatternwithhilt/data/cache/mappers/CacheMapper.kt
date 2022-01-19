package com.example.repositorypatternwithhilt.data.cache.mappers

import com.example.repositorypatternwithhilt.data.cache.model.BlogCacheEntity
import com.example.repositorypatternwithhilt.domain.model.Blog
import com.example.repositorypatternwithhilt.domain.util.EntityMapper

class CacheMapper : EntityMapper<BlogCacheEntity, Blog> {

    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }

    fun mapFromEntityList(entities: List<BlogCacheEntity>): List<Blog> {
        return entities.map { mapFromEntity(it) }
    }

}