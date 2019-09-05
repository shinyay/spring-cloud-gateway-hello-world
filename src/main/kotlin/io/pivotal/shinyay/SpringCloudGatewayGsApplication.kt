package io.pivotal.shinyay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringCloudGatewayGsApplication {
	@Bean
	fun routing(builder: RouteLocatorBuilder) : RouteLocator = builder.routes()
			.route { p
				-> p.path("/get")
					.filters { f -> f.addRequestHeader("X-Request-Hello", "GetWorld") }
					.uri("http://httpbin.org")
			}.build()
}

fun main(args: Array<String>) {
	runApplication<SpringCloudGatewayGsApplication>(*args)
}
