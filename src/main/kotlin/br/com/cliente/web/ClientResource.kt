package br.com.cliente.web

import br.com.cliente.infra.situation.SituationClient
import br.com.cliente.usecase.CreateClientCase
import br.com.cliente.usecase.SearchClientCase
import br.com.cliente.usecase.SearchOperationClientCase
import br.com.cliente.usecase.UpdateClientCase
import br.com.cliente.usecase.model.Client
import br.com.cliente.web.request.ClientRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
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

    @PostMapping(consumes = [MULTIPART_FORM_DATA_VALUE])
    fun create(
        @RequestParam("request") request: String,
        @RequestParam("attachDocument") attachDocument: MultipartFile
    ): ResponseEntity<Void> {
        val mapper = jacksonObjectMapper()
        val clientRequest = mapper.readValue<ClientRequest>(request)
        createClientCase.create(Client(clientRequest, attachDocument))
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PutMapping("/{clientId}")
    fun update(
        @PathVariable @Valid clientId: String,
        @RequestParam("request") request: String,
        @RequestParam("attachDocument") attachDocument: MultipartFile
    ): ResponseEntity<Void> {
        val mapper = jacksonObjectMapper()
        val clientRequest = mapper.readValue<ClientRequest>(request)
        updateClientCase.update(Client(clientRequest, attachDocument), clientId)
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