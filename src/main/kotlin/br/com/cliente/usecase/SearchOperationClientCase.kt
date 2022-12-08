package br.com.cliente.usecase

import br.com.cliente.infra.openfeign.OperationClient
import br.com.cliente.web.response.OperationClientResponse
import org.springframework.stereotype.Component

@Component
class SearchOperationClientCase(val operationClient: OperationClient) {
    fun search(clientId: String): OperationClientResponse? = operationClient.getOperations(clientId)
}