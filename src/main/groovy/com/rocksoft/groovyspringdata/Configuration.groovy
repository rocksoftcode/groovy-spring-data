package com.rocksoft.groovyspringdata

import org.springframework.context.annotation.Bean

import com.rocksoft.groovyspringdata.domain.EsrbRating
import com.rocksoft.groovyspringdata.domain.System
import com.rocksoft.groovyspringdata.domain.Title
import com.rocksoft.groovyspringdata.repository.EsrbRatingRepository
import com.rocksoft.groovyspringdata.repository.SystemRepository
import com.rocksoft.groovyspringdata.repository.TitleRepository

@org.springframework.context.annotation.Configuration
class Configuration {

	@Bean
	def config(EsrbRatingRepository esrbRatingRepository, SystemRepository systemRepository, TitleRepository titleRepository) {
		def rating = esrbRatingRepository.save(new EsrbRating(code: 'E', name: 'Everyone'))
		def system = systemRepository.save(new System(name: 'Atari 2600'))
		titleRepository.save(new Title(name: 'California Games', system: system, rating: rating))
		titleRepository.save(new Title(name: 'Night Racer', system: system, rating: rating))
		titleRepository.save(new Title(name: 'Pole Position', system: system, rating: rating))
	}
}
