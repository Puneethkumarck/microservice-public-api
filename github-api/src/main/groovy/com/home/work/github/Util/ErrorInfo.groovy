package com.home.work.github.Util

import com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile
import groovy.transform.CompileStatic
import org.springframework.stereotype.Component


@CompileStatic
@Component
class ErrorInfo {

    String message

    String errorCode

    String cause
}
