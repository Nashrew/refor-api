package com.nashsoft.refor_api

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(info = Info(title = "Refor API", version = "1.0", description = "API documentation for Refor API"))
class ReforApiApplication

fun main(args: Array<String>) {
	runApplication<ReforApiApplication>(*args)
}
