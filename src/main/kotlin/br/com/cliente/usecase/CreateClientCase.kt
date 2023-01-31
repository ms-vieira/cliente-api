package br.com.cliente.usecase

import br.com.cliente.infra.entity.ClientDocument
import br.com.cliente.infra.openfeign.OperationClient
import br.com.cliente.infra.openfeign.request.ClientOperationRequest
import br.com.cliente.infra.repository.ClientRepository
import br.com.cliente.infra.s3.S3Component
import br.com.cliente.usecase.model.Client
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class CreateClientCase(
    val repository: ClientRepository,
    val s3Client: S3Component,
    val operationClient: OperationClient
) {

    private val logger = LoggerFactory.getLogger(CreateClientCase::class.java)


    fun create(client: Client) {
        val attachDocument = s3Client.uploadFile(client.attachDocument!!)
        val clientDocument = ClientDocument(client, attachDocument)
        val findClient = repository.findByNumberDocument(clientDocument.numberDocument)
        if (findClient.isPresent && !findClient.get().isEmpty()) {
            findClient.get().first().getClientId()?.let { clientDocument.setClientId(it) }
            findClient.get().first().getCreatedAt()?.let { clientDocument.setCreatedAt(it) }
        }
        repository.save(clientDocument)
        val requestOperation =
            ClientOperationRequest("CREATION", clientDocument.numberDocument, LocalDateTime.now().toString())
        operationClient.createOperation(requestOperation)
    }
}