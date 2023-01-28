package br.com.cliente.usecase

import br.com.cliente.infra.entity.ClientDocument
import br.com.cliente.infra.openfeign.OperationClient
import br.com.cliente.infra.openfeign.request.ClientOperationRequest
import br.com.cliente.infra.repository.ClientRepository
import br.com.cliente.usecase.model.ClientUpdate
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class UpdateClientCase(
    val repository: ClientRepository,
    val operationClient: OperationClient
) {

    fun update(clientRequest: ClientUpdate, clientId: String) {
        val client = repository.findByNumberDocument(clientId)
        if (client.isPresent) {
            val newClient = ClientDocument(clientRequest, clientRequest.attachDocument)
            client.get().getClientId()?.let { newClient.setClientId(it) }
            client.get().getCreatedAt()?.let { newClient.setCreatedAt(it) }
            repository.save(newClient)
            val requestOperation =
                ClientOperationRequest("UPDATE", newClient.numberDocument, LocalDateTime.now().toString())
            operationClient.createOperation(requestOperation)
        }
    }
}