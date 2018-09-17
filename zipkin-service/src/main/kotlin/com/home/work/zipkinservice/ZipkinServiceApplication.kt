package com.home.work.zipkinservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import zipkin.server.EnableZipkinServer


@EnableZipkinServer
@SpringBootApplication
class ZipkinServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(ZipkinServiceApplication::class.java, *args)
}
