package com.bank.applauncher

import io.github.cdimascio.dotenv.dotenv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.bank"])
class BankSimulatorBackendApplication

fun main(args: Array<String>) {

    val dotenv = dotenv {
        ignoreIfMissing = true
    }

    dotenv.entries().forEach { entry ->
        System.setProperty(entry.key, entry.value)
    }

    runApplication<BankSimulatorBackendApplication>(*args)
}