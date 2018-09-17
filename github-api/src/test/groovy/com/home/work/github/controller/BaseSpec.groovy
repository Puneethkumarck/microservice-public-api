package com.home.work.github.controller
import groovy.json.JsonSlurper
import spock.lang.Specification


class BaseSpec extends Specification {

    String basePath='src/test/resources/'

    static Map readResourceAsMap(String path) {
        new JsonSlurper().parse(new File(path)) as Map
    }

}
