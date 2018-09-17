package com.home.work.youtube.service

import groovy.json.JsonOutput
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@CompileStatic
@Service
@Slf4j
class SubscriptionService {

    @Value('${subscrption.url}')
    String subsciptionUrl

    @Autowired RestTemplate restTemplate

    @Value('${api.key}')
    String apiKey

    String getSubscriptionList(String channelId,int resultSize){
        try{
          Map result= restTemplate.getForObject(getSubscriptionUrl(channelId,resultSize),Map.class)
            def json = JsonOutput.toJson(result)
            JsonOutput.prettyPrint(json)
        }catch(Exception e){
            log.error("Exception occurred while retrieving subscription list from youtube for the given channelID ${channelId}",e)
        }
    }

   private String getSubscriptionUrl(String channelId,int resultSize){
       "https://www.googleapis.com/youtube/v3/subscriptions?part=snippet,contentDetails&channelId=${channelId}&key=AIzaSyBXzXJz8GJI4DVLODvHUMIzg62IiQqE--c&maxResults=${resultSize}"
   }
}
