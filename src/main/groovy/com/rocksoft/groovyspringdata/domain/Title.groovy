package com.rocksoft.groovyspringdata.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToOne

@Entity
class Title {
	@Id
	@GeneratedValue
	Long id
	String name
	@ManyToOne
	System system
	@OneToOne
	EsrbRating rating
}
