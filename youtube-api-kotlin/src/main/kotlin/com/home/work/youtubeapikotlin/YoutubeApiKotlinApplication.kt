package com.home.work.youtubeapikotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.ComponentScan

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.home.work.*")
class YoutubeApiKotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(YoutubeApiKotlinApplication::class.java, *args)
}
