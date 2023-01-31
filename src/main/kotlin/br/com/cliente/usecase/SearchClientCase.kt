package br.com.cliente.usecase

import br.com.cliente.infra.repository.ClientRepository
import br.com.cliente.web.response.ClientResponse
import org.springframework.stereotype.Component

@Component
class SearchClientCase(
    val repository: ClientRepository
) {

    fun search(clientId: String): ClientResponse? {
        val client = repository.findByNumberDocument(clientId)
        if (!client.get().isEmpty()) return ClientResponse(client.get().first())
        return null
    }
}