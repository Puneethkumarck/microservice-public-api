package com.home.work.adminserver

import de.codecentric.boot.admin.config.EnableAdminServer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient


@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
class AdminServerApplication {

	static void main(String[] args) {
		SpringApplication.run AdminServerApplication, args
	}
}
