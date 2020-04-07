package com.rocksoft.groovyspringdata


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

import com.rocksoft.groovyspringdata.domain.EsrbRating
import com.rocksoft.groovyspringdata.domain.System
import com.rocksoft.groovyspringdata.domain.Title
import com.rocksoft.groovyspringdata.repository.EsrbRatingRepository
import com.rocksoft.groovyspringdata.repository.SystemRepository
import com.rocksoft.groovyspringdata.repository.TitleRepository

import spock.lang.Specification

@DataJpaTest
class RepositoryTestsSpec extends Specification {

	@Autowired
	TestEntityManager entityManager
	@Autowired
	EsrbRatingRepository esrbRatingRepository
	@Autowired
	SystemRepository systemRepository
	@Autowired
	TitleRepository titleRepository

	def 'ESRB Rating Repository'() {
		setup:
		def esrbRating = new EsrbRating(code: 'FOO', name: 'Foobar')
		entityManager.persist(esrbRating)
		entityManager.flush()

		when:
		Optional<EsrbRating> result = esrbRatingRepository.findById(esrbRating.id)

		then:
		result.present
		result.get() == esrbRating
	}

	def 'System Repository'() {
		setup:
		def system = new System(name: 'Foobar')
		entityManager.persist(system)
		entityManager.flush()

		when:
		Optional<System> result = systemRepository.findById(system.id)

		then:
		result.present
		result.get() == system
	}

	def 'Title Repository'() {
		def esrbRating = new EsrbRating(code: 'FOO', name: 'Foobar')
		def system = new System(name: 'Foobar')
		def title = new Title(name: 'Foobar', rating: esrbRating, system: system)
		entityManager.persist(esrbRating)
		entityManager.persist(system)
		entityManager.persist(title)
		entityManager.flush()

		when:
		Optional<Title> result = titleRepository.findById(title.id)

		then:
		result.present
		result.get() == title
	}
}
