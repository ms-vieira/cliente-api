package br.com.cliente.infra.repository

import br.com.cliente.infra.entity.ClientDocument
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import java.util.*


@EnableScan
interface ClientRepository : CrudRepository<ClientDocument, String> {
    fun findByNumberDocument(number: String): Optional<ClientDocument>
}