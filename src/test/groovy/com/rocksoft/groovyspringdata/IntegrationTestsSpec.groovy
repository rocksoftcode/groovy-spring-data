package com.rocksoft.groovyspringdata

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.ResponseEntity

import com.rocksoft.groovyspringdata.domain.Title

import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTestsSpec extends Specification {

	@Autowired
	TestRestTemplate restTemplate

	def 'Retrieves item using projection'() {
		when:
		ResponseEntity<Title> entity = restTemplate.getForEntity('/titles/3?projection={projection}', Title, [projection: 'fullTitle'])

		then:
		entity.body
		entity.body.name
		entity.body.system
		entity.body.system.name
		entity.body.rating
		entity.body.rating.code
	}
}
