package com.home.work.youtube.controller

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.home.work.youtube.service.VideoCategoryService
import groovy.json.JsonOutput



class VideoCategoriesControllerSpec extends BaseSpec {

    VideoCategoryService videoCategoryService

    VideoCategoriesController videoCategoriesController

    ObjectMapper objectMapper


    void setup() {
        JsonFactory factory = new JsonFactory()
        factory.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES)
        objectMapper=new ObjectMapper(factory)
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
        videoCategoryService=Mock(VideoCategoryService)
        videoCategoriesController=new VideoCategoriesController(videoCategoryService: videoCategoryService)
    }

    def "GetSubscriptionList"() {

        given:
        regionCode
        Map responseMap = readResourceAsMap(basePath+response)
        def json = JsonOutput.toJson(responseMap)


        when:
        Object videoResponse= videoCategoriesController.getVideoCategoriesList(regionCode)

        then:
        videoCategoryService.getVideoCatogoriesList(_ as String )>> JsonOutput.prettyPrint(json)

        and:
        videoResponse!=null

        where:
        regionCode | response
        'IN'       |'/videoCategories/video_categories_IN.json'
        'US'       |'/videoCategories/video_categories_US.json'
        'MH'       |'/videoCategories/video_categories_MH.json'

    }
}
