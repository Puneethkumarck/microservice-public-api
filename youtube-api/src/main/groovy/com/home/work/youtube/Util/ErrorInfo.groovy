package com.home.work.youtube.Util

import groovy.transform.CompileStatic
import org.springframework.stereotype.Component


@CompileStatic
@Component
class ErrorInfo {

    String message

    String errorCode

    String cause
}
