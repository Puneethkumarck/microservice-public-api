package com.home.work.youtubeapikotlin.controller

import com.home.work.youtubeapikotlin.service.VideoCategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/yk/videoCategories")
class VideoCategoriesController() {

    @Autowired var videoCategoryService: VideoCategoryService?=null

    @RequestMapping(value="/list",produces = ["application/json"])
    fun getVideoCategoriesList(@RequestParam regionCode:String) :String {
            return videoCategoryService?.getVideoCategoriesList(regionCode)?:"video categories not found"
    }
}
