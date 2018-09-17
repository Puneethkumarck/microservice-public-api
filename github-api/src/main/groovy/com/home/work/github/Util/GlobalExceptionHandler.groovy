package com.home.work.github.Util
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody


@CompileStatic
@ControllerAdvice
@Slf4j
class GlobalExceptionHandler {

    @ExceptionHandler(value = [Exception.class, RuntimeException.class])
   @ResponseBody ResponseEntity<ErrorInfo> errors(Exception e) {
        def stack = []
        ErrorInfo errorInfo=new ErrorInfo()
        for (frame in e.getStackTrace()) {
            stack << frame.toString()
        }

        log.error("Internal server error occurred" , stack.join('\n'))
        errorInfo.with {
            message=e.message
            errorCode='500'
            cause=e.cause
        }

       new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [IllegalArgumentException.class])
  @ResponseBody  ResponseEntity<ErrorInfo> validationError(Exception e) {
        def stack = []
        ErrorInfo errorInfo=new ErrorInfo()
        for (frame in e.getStackTrace()) {
            stack << frame.toString()
        }

        log.error("Validation exception occurred" , stack)
        errorInfo.with {
            errorCode='400'
            message=e.message
            cause=e.cause
        }
        new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST)
    }
}
