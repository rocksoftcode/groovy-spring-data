package com.rocksoft.groovyspringdata.repository

import org.springframework.data.repository.CrudRepository

import com.rocksoft.groovyspringdata.domain.System


interface SystemRepository extends CrudRepository<System, Long> {}