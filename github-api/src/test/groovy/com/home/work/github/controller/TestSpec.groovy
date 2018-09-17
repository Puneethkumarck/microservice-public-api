package com.home.work.github.controller

import org.apache.commons.lang.StringUtils

class TestSpec extends BaseSpec{

    def "hello_spock_world"(){

        given:"welcome text"
        String welcomeText="Hello puneeth welcome to spock world"

        when:"check welcometext is not null or empty"
        StringUtils.isNotBlank(welcomeText)

        then:"match with inputText"
        assert inputText==welcomeText

        where:
        inputText                               | _
        "Hello puneeth welcome to spock world"  | _
    }
}
