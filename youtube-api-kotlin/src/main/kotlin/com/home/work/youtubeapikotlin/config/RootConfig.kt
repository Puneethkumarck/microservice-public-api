package com.home.work.youtubeapikotlin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate


@Configuration
 class RootConfig {

    @Bean
     fun restTemplate(): RestTemplate {
        val restTemplate= RestTemplate()
        val requestFactory=SimpleClientHttpRequestFactory()
        requestFactory.setBufferRequestBody(false)
        requestFactory.setReadTimeout(5000)
        requestFactory.setConnectTimeout(5000)
        restTemplate.requestFactory=requestFactory
        return restTemplate
    }
}