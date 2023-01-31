package br.com.cliente.usecase

import br.com.cliente.infra.openfeign.OperationClient
import br.com.cliente.web.response.OperationClientResponse
import br.com.cliente.web.response.OperationsResponse
import org.springframework.stereotype.Component

@Component
class SearchOperationClientCase(val operationClient: OperationClient) {
    fun search(clientId: String): List<OperationsResponse?> = operationClient.getOperations(clientId)
}