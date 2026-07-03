package com.bank.applauncher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.bank"])
class BankSimulatorBackendApplication

fun main(args: Array<String>) {
    runApplication<BankSimulatorBackendApplication>(*args)
}