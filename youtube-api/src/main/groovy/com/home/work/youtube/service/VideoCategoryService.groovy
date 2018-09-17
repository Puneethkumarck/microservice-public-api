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
class VideoCategoryService {


    @Value('${subscrption.url}') String videoCategoryUrl

    @Autowired RestTemplate restTemplate

    @Value('${api.key}') String apiKey

    String getVideoCatogoriesList(String regionCode){
        try{
            log.info("property values are "+videoCategoryUrl +"and api key"+apiKey)
            Map result= restTemplate.getForObject(getSubscriptionUrl(regionCode),Map.class)
            def json = JsonOutput.toJson(result)
            JsonOutput.prettyPrint(json)
        }catch(Exception e){
            log.error("Exception occurred while retrieving videoCatogories for given region code ${regionCode}",e)
        }
    }


    private String getSubscriptionUrl(String regionCode){
        "https://www.googleapis.com/youtube/v3/videoCategories?part=snippet&regionCode=${regionCode}&key="+apiKey
    }
}
