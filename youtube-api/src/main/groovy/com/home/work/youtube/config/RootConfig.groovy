package com.home.work.youtube.config
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate


@Configuration
class RootConfig {

    @Bean
    ObjectMapper objectMapper(){
        ObjectMapper objectMapper=new ObjectMapper()
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true)
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES,false)
        objectMapper
    }

    @Bean
    RestTemplate restTemplate(){
        final RestTemplate restTemplate=new RestTemplate()
        SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory()
        requestFactory.setBufferRequestBody(false)
        requestFactory.readTimeout=5000
        requestFactory.connectTimeout=5000
        restTemplate.setRequestFactory(requestFactory)
        restTemplate
    }
}
