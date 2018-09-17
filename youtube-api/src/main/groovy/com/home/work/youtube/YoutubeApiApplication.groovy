package com.home.work.youtube

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.ComponentScan


@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(["com.home.work.youtube.*"])
@Slf4j
class YoutubeApiApplication {
    static void main(String[] args) {
        SpringApplication.run YoutubeApiApplication, args
    }
}
