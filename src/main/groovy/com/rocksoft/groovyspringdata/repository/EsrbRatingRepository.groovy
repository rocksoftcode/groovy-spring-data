package com.rocksoft.groovyspringdata.repository

import org.springframework.data.repository.CrudRepository

import com.rocksoft.groovyspringdata.domain.EsrbRating


interface EsrbRatingRepository extends CrudRepository<EsrbRating, Long> {}