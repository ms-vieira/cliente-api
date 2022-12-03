package br.com.cliente.usecase

import br.com.cliente.infra.repository.ClientRepository
import br.com.cliente.web.response.ClientResponse
import org.springframework.stereotype.Component

@Component
class SearchClientCase(
    val repository: ClientRepository
) {

    fun search(clientId: String): ClientResponse? {
        val client = repository.findById(clientId)
        if (client.isPresent) return ClientResponse(client.get())
        return null
    }
}