package com.home.work.edgeservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
class EdgeserviceApplication {

	static void main(String[] args) {
		SpringApplication.run EdgeserviceApplication, args
	}
}
