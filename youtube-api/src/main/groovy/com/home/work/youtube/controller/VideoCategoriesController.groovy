package com.home.work.youtube.controller

import com.home.work.youtube.service.VideoCategoryService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CompileStatic
@RestController
@RequestMapping("/youtube/videoCategories")
class VideoCategoriesController {

    @Autowired VideoCategoryService videoCategoryService

    @GetMapping(value="/list",produces = 'application/json')
    Object getVideoCategoriesList(@RequestParam String regionCode){

        Assert.notNull(regionCode,"regionCode should not be null")

        videoCategoryService.getVideoCatogoriesList(regionCode)
    }
}
