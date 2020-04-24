package org.cloudchallenge.codex.admin

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableConfigurationProperties
@EnableAdminServer
@EnableDiscoveryClient
class AdminApplication

fun main(args: Array<String>) {
	runApplication<AdminApplication>(*args)
}
