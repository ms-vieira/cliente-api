package br.com.cliente

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ClientApiApplication

fun main(args: Array<String>) {
	runApplication<ClientApiApplication>(*args)
}
