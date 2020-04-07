package com.rocksoft.groovyspringdata.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class EsrbRating {
	@Id
	@GeneratedValue
	Long id
	String code
	String name
}
