package com.rocksoft.groovyspringdata.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class System {
	@Id
	@GeneratedValue
	Long id
	String name
}
