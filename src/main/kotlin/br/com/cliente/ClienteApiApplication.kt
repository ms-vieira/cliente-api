package br.com.cliente

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ClienteApiApplication

fun main(args: Array<String>) {
	runApplication<ClienteApiApplication>(*args)
}
