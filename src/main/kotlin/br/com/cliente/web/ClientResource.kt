package br.com.cliente.web

import br.com.cliente.usecase.CreateClientCase
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
class ClientResource(val createClientCase: CreateClientCase, val updateClientCase: UpdateClientCase) {

    fun create(@RequestBody @Valid request: ClientRequest): ResponseEntity<Void> {
        createClientCase.create(Client(request))
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PutMapping("/{clientId}")
    fun update(
        @RequestBody @Valid request: ClientRequest,
        @RequestParam @Valid clientId: String
    ): ResponseEntity<Void> {
        updateClientCase.update(Client(request), clientId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}