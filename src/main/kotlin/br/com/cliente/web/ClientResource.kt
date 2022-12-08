package br.com.cliente.web

import br.com.cliente.infra.situation.SituationClient
import br.com.cliente.usecase.CreateClientCase
import br.com.cliente.usecase.SearchClientCase
import br.com.cliente.usecase.SearchOperationClientCase
import br.com.cliente.usecase.UpdateClientCase
import br.com.cliente.usecase.model.Client
import br.com.cliente.web.request.ClientRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Validated
@RestController
@RequestMapping("/client")
class ClientResource(
    val createClientCase: CreateClientCase,
    val updateClientCase: UpdateClientCase,
    val searchClientCase: SearchClientCase,
    val searchOperationClientCase: SearchOperationClientCase,
    val situationClient: SituationClient
) {

    @PostMapping
    fun create(@RequestBody @Valid request: ClientRequest): ResponseEntity<Void> {
        createClientCase.create(Client(request))
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PutMapping("/{clientId}")
    fun update(
        @RequestBody @Valid request: ClientRequest,
        @PathVariable @Valid clientId: String
    ): ResponseEntity<Void> {
        updateClientCase.update(Client(request), clientId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/{clientId}")
    fun searchClient(@PathVariable @Valid clientId: String) =
        searchClientCase.search(clientId)

    @GetMapping("/operation/{clientId}")
    fun searchOperations(@PathVariable @Valid clientId: String) =
        searchOperationClientCase.search(clientId)

    @GetMapping("/situation/{clientId}")
    fun searchSituation(@PathVariable @Valid clientId: String) = situationClient.search(clientId)
}