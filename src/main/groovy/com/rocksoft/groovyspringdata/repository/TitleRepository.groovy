package com.rocksoft.groovyspringdata.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

import com.rocksoft.groovyspringdata.domain.FullTitleProjection
import com.rocksoft.groovyspringdata.domain.Title

@RepositoryRestResource(excerptProjection = FullTitleProjection)
interface TitleRepository extends CrudRepository<Title, Long> {}