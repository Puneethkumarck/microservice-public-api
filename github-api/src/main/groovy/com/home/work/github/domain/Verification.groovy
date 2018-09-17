package com.home.work.github.domain

import groovy.transform.CompileStatic
import org.springframework.stereotype.Component

@CompileStatic
@Component
class Verification {

    boolean verified

    String reason

    String signature

    String payload
}
