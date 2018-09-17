package com.home.work.youtube.controller

import com.home.work.youtube.service.SubscriptionService
import groovy.json.JsonOutput


class SubscriptionControllerSpec extends BaseSpec {

    SubscriptionService subscriptionService

    SubscriptionController subscriptionController

    void setup() {
        subscriptionService=Mock(SubscriptionService)
        subscriptionController=new SubscriptionController(subscriptionService:subscriptionService)
    }

    def "GetSubscriptionList"() {

        given:
        channelId
        Map responseMap = readResourceAsMap(basePath+response)
        def json = JsonOutput.toJson(responseMap)


        when:
        Object subscriptionList= subscriptionController.getSubscriptionList(channelId,maxResult)

        then:
        subscriptionService.getSubscriptionList(_, _ )>> JsonOutput.prettyPrint(json)

        and:
        subscriptionList!=null

        where:
        channelId                   | maxResult |response
        'UCvG1tb-HKBfYqIu1cVTQMeA'  |5          |'/subscription/channel_subscription_list.json'

    }
}
