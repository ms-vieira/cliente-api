package br.com.cliente.infra.openfeign

import br.com.cliente.web.response.OperationClientResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "operationClient",
    url = "\${integration.client.operation-service}"
)
interface OperationClient {
    @GetMapping("/{clientId}")
    fun getOperations(@PathVariable clientId: String): OperationClientResponse

}