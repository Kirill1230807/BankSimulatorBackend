package com.bank.commonlib

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CommonLibApplication

fun main(args: Array<String>) {
    runApplication<CommonLibApplication>(*args)
}
