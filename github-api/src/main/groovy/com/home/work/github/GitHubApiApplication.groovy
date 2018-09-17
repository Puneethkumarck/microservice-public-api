package com.home.work.mircoserviceapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.ComponentScan


@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(["com.home.work.github.*"])
class GitHubApiApplication {

	static void main(String[] args) {
		SpringApplication.run GitHubApiApplication, args
	}
}
