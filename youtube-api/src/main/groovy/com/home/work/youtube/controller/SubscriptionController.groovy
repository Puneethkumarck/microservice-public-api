package com.home.work.youtube.controller

import com.home.work.youtube.service.SubscriptionService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CompileStatic
@RestController
@RequestMapping("/youtube/subscription")
class SubscriptionController {


   @Autowired SubscriptionService subscriptionService

    @GetMapping(value="/list",produces = 'application/json')
    Object getSubscriptionList(@RequestParam String channelId, @RequestParam int maxResults){

        Assert.notNull(channelId,"channelId should not be null")

        int resultSize=maxResults?maxResults:10

        subscriptionService.getSubscriptionList(channelId,resultSize)
    }
}
