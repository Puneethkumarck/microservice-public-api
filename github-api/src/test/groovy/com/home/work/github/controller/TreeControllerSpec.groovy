package com.home.work.github.controller
import com.fasterxml.jackson.databind.ObjectMapper
import com.home.work.github.domain.TreeDetail
import com.home.work.github.service.TreeService

class TreeControllerSpec extends BaseSpec{

    TreeService treeService

    TreeController treeController

    ObjectMapper objectMapper

    void setup() {
        treeService=Mock(TreeService)
        objectMapper=new ObjectMapper()
        treeController=new TreeController(
                treeService: treeService,
                objectMapper: objectMapper
        )
    }



    def "test_get_tree_happy_path"(){

        given:"input data"
        Map responseMap = readResourceAsMap(basePath+response)

        when:"call tree controller"
        TreeDetail treeDetail= treeController.getTrees(owner,appName,sha)

        then:"stub tree service response"
        treeService.getTrees(owner,appName,sha)>> responseMap

        and:"validate response"
        treeDetail.sha==sha
        treeDetail.url==url

        where:"for given input"
        url                                                                                                                                  | truncated | sha                                      |response                |owner              |appName
        'https://api.github.com/repos/Puneethkumarck/cassandra-trading-app-cloud-enabled/git/trees/9c555dc546c35378a1422d3dbf3dfffe91a223cf' |false      |'9c555dc546c35378a1422d3dbf3dfffe91a223cf'|'/trees/getrees.json'   |'Puneethkumarck'   |'cassandra-trading-app-cloud-enabled'
    }



    def "test_get_tree_Validation_exception"(){

        given:"input data"
         readResourceAsMap(basePath+response)

        when:"call tree controller"
        treeController.getTrees(owner,appName,sha)

        then:"stub tree service response"
        thrown(IllegalArgumentException)

        where:"for given input"
        url                                                                                                                                  | truncated | sha  |response                |owner              |appName
        'https://api.github.com/repos/Puneethkumarck/cassandra-trading-app-cloud-enabled/git/trees/9c555dc546c35378a1422d3dbf3dfffe91a223cf' |false      |''    |'/trees/getrees.json'   |'Puneethkumarck'   |'cassandra-trading-app-cloud-enabled'
    }
}
