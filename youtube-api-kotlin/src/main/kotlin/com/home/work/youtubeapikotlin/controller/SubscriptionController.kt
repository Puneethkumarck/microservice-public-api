package com.home.work.youtubeapikotlin.controller

import com.home.work.youtubeapikotlin.service.SubscriptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/yk/subscription")
class SubscriptionController {

    @Autowired
    var  subscriptionService: SubscriptionService?=null

    @RequestMapping(value="/list",produces = ["application/json"])
    fun getVideoCategoriesList(@RequestParam channelId:String,@RequestParam maxResults:Int) :String {

        return subscriptionService?.getSubscriptionList(channelId,maxResults)?:"subscriptions not found"
    }
}