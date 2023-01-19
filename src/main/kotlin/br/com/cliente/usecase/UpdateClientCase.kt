package br.com.cliente.usecase

import br.com.cliente.infra.entity.ClientDocument
import br.com.cliente.infra.repository.ClientRepository
import br.com.cliente.infra.s3.S3Component
import br.com.cliente.usecase.model.Client
import org.springframework.stereotype.Component

@Component
class UpdateClientCase(
    val repository: ClientRepository,
    val s3Client: S3Component
) {

    fun update(client: Client, clientId: String) {
        val attachDocument = s3Client.uploadFile(client.attachDocument)
        val client = repository.findByNumberDocument(clientId)
        if (client.isPresent) {
            val newClient = ClientDocument(client.get(), attachDocument)
            repository.save(newClient)
        }
    }
}