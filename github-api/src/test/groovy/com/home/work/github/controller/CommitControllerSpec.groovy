package com.home.work.youtube.controller
import com.fasterxml.jackson.databind.ObjectMapper
import com.home.work.github.controller.BaseSpec
import com.home.work.github.controller.CommitController
import com.home.work.github.domain.Author
import com.home.work.github.domain.CommitDetail
import com.home.work.github.service.CommitService


class CommitControllerSpec extends BaseSpec {

    CommitService commitService

    CommitService commitService1

    CommitController commitController

    CommitController commitController2

    ObjectMapper objectMapper

    void setup() {
        commitService1=new CommitService()
        commitService=Mock(CommitService)
        objectMapper=new ObjectMapper()
        commitController=new CommitController(
                commitService: commitService,
                objectMapper: objectMapper
        )
        commitController2=new CommitController(
            commitService: commitService1
        )
    }




    def "test_get_commit_happy_path"(){

        given:"input data"
        Map responseMap = readResourceAsMap(basePath+response)

        when:"call commit controller"
        CommitDetail commitDetail= commitController.getCommit(owner,appName,sha)

        then:"stub commit service response"
        commitService.getCommit(owner,appName,sha)>> responseMap

        and:"validate response"
        commitDetail.author.name==author
        commitDetail.author.email==email
        commitDetail.author.date==date


        where:"for given input"
        owner               | appName            | sha                                      |response                   |author          |email                 |date
        "puneethkumarck"    |'WEB-TRADING-APP'   |'9790918b5e8dc29f5eee3fcf50581b1d16eee71f'|'/commit/getcommit.json'   |'PuneethKumarCk'|'punith.564@gmail.com'|'2016-11-17T15:15:18Z'
    }

    def "test_get_commit_validation_exception"(){

        given:"input data"
        readResourceAsMap(basePath+response)

        when:"check welcometext is not null or empty"
        commitController.getCommit(owner,appName,sha)

        then:"stub commit response"
        thrown(IllegalArgumentException)

        where:
        owner               | appName            | sha    |response                   |author          |email                 |date
        "puneethkumarck"    |'WEB-TRADING-APP'   |  ''    |'/commit/getcommit.json'   |'PuneethKumarCk'|'punith.564@gmail.com'|'2016-11-17T15:15:18Z'
    }



    def "test_get_authors"(){

        when:"call commit controller"
        List<Author> authorList= commitController2.getAutors()

        then:"stub commit service response"
        println(authorList.each {it.name + ' ' + it.email})

    }






}
