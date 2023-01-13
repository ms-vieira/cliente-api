package br.com.cliente

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignAutoConfiguration

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration(FeignAutoConfiguration::class)
class ClientApiApplication

fun main(args: Array<String>) {
    runApplication<ClientApiApplication>(*args)
}
