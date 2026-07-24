package com.bank.applauncher

import io.github.cdimascio.dotenv.dotenv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.persistence.autoconfigure.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.boot.runApplication

@EntityScan(basePackages = ["com.bank"])
@EnableJpaRepositories(basePackages = ["com.bank"])
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
