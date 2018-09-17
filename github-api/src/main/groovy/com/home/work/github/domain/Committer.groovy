package com.home.work.github.domain

import groovy.transform.CompileStatic
import org.springframework.stereotype.Component

@CompileStatic
@Component
class Committer {

    String name

    String email

    String date
}
