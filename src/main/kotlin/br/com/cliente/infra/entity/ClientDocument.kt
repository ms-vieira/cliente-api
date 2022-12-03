package br.com.cliente.infra.entity

import br.com.cliente.infra.dynamodb.DynamoDBConfig
import br.com.cliente.usecase.model.Client
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted
import java.time.Instant
import java.time.Instant.now
import java.util.*

@DynamoDBTable(tableName = "cliente")
class ClientDocument(
    @field:DynamoDBHashKey
    @field:DynamoDBAttribute(attributeName = "cliente_id")
    var id: String = UUID.randomUUID().toString(),

    @field:DynamoDBAttribute(attributeName = "endereco_cliente")
    var addressClient: AddressClientDocument? = null,

    @field:DynamoDBAttribute(attributeName = "numero_documento")
    var numberDocument: String = "",

    @field:DynamoDBAttribute(attributeName = "observacao_cliente")
    var observationClient: String = "",

    @field:DynamoDBAttribute(attributeName = "documento_anexado")
    var attachDocument: String = "",

    @field:DynamoDBAttribute(attributeName = "criado_em")
    @field:DynamoDBTypeConverted(converter = DynamoDBConfig.Companion.LocalDateTimeConverter::class)
    var createdAt: Instant = now()
) {
    constructor(client: Client, attachDocument: String) : this(
        addressClient = AddressClientDocument(
            street = client.address.street,
            number = client.address.number,
            zipCode = client.address.zipCode,
            city = client.address.city,
            state = client.address.state,
            district = client.address.district
        ),
        numberDocument = client.numberDocument,
        observationClient = client.observationClient,
        attachDocument = attachDocument
    )

    constructor(client: ClientDocument, attachDocument: String) : this(
        addressClient = client.addressClient?.let {
            AddressClientDocument(
                street = it.street,
                number = client.addressClient!!.number,
                zipCode = client.addressClient!!.zipCode,
                city = client.addressClient!!.city,
                state = client.addressClient!!.state,
                district = client.addressClient!!.district
            )
        },
        numberDocument = client.numberDocument,
        observationClient = client.observationClient,
        attachDocument = attachDocument
    )
}
