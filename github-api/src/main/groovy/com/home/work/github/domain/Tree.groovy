package com.home.work.github.domain

import groovy.transform.CompileStatic
import org.springframework.stereotype.Component

@CompileStatic
@Component
class Tree {

    String sha

    String url

    String type

    String path

    String mode

    String size

}
