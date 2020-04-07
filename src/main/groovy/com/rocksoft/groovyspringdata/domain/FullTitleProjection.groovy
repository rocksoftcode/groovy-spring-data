package com.rocksoft.groovyspringdata.domain

import org.springframework.data.rest.core.config.Projection

@Projection(name = "fullTitle", types = [Title])
interface FullTitleProjection {
	String getName()
	EsrbRating getRating()
	System getSystem()
}