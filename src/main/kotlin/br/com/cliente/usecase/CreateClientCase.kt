package br.com.cliente.usecase

import br.com.cliente.infra.entity.ClientDocument
import br.com.cliente.infra.repository.ClientRepository
import br.com.cliente.infra.s3.S3Component
import br.com.cliente.usecase.model.Client
import org.springframework.stereotype.Component

@Component
class CreateClientCase(
    val repository: ClientRepository,
    val s3Client: S3Component
) {

    fun create(client: Client) {
        val attachDocument = s3Client.uploadFile(client.attachDocument)
        val clientDocument = ClientDocument(client, attachDocument)
        repository.save(clientDocument)
    }
}