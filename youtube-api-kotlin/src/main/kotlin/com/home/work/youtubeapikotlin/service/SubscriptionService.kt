package com.home.work.youtubeapikotlin.service

import com.google.gson.GsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@RefreshScope
@Service
class SubscriptionService {

    @Autowired
    var restTemplate: RestTemplate? = null

    @Value("\${api.key}")
    var apiKey:String = " "

    @Value("\${subscription.url}")
    var subscriptionUrl:String="  "

    fun getSubscriptionList (channelId:String,resultSize:Int): String {
        val gson = GsonBuilder().setPrettyPrinting().create()
        val categories = restTemplate?.getForObject("$subscriptionUrl$channelId&key=$apiKey&maxResults=$resultSize", Map::class.java)
        return gson.toJson(categories)
    }
}