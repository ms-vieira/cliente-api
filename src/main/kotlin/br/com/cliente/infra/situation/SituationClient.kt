package br.com.cliente.infra.situation

import br.com.cliente.usecase.enums.Situation
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
@FunctionalInterface
class SituationClient {
    fun search(clientId: String): Situation = Situation.from(Random.nextInt(1, 2))
}