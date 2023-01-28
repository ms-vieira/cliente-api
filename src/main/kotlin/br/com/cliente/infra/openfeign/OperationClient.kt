package br.com.cliente.infra.openfeign

import br.com.cliente.infra.openfeign.request.ClientOperationRequest
import br.com.cliente.web.response.OperationClientResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    name = "operationClient",
    url = "\${integration.client.operation-service}"
)
interface OperationClient {
    @GetMapping("/{clientId}")
    fun getOperations(@PathVariable clientId: String): OperationClientResponse

    @PostMapping
    fun createOperation(@RequestBody request: ClientOperationRequest)

}