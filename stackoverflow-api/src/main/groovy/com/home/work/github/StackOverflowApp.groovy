package com.home.work.github

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class StackOverflowApp {

    static void main(String[] args) {
        SpringApplication.run StackOverflowApp, args
    }
}
