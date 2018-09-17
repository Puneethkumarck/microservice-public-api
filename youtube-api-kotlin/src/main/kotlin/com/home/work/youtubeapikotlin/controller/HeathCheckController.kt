package com.home.work.youtubeapikotlin.controller

import com.google.gson.GsonBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.*

@RefreshScope
@RestController
@RequestMapping("/yk")
class HeathCheckController {

    @Value("\${application.name}")
    var applicationName:String = " "

    @Value("\${application.status}")
    var status:String = " "

    @Value("\${java.version}")
    var version:String=" "


    @GetMapping(value = "/healthcheck",produces = ["application/json"])
    @ResponseBody
    fun getHealthCheck():String{
        val gson = GsonBuilder().setPrettyPrinting().create()
        val responseMap = hashMapOf("appName" to applicationName, "version" to version,"status" to status)
        return gson.toJson(responseMap)
    }
}