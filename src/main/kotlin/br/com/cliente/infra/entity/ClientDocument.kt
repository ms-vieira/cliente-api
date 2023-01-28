package br.com.cliente.infra.entity

import br.com.cliente.usecase.model.Client
import br.com.cliente.usecase.model.ClientUpdate
import com.amazonaws.services.dynamodbv2.datamodeling.*
import org.springframework.data.annotation.Id
import java.util.Objects.isNull
import java.util.Objects.nonNull

@DynamoDBTable(tableName = "Client")
class ClientDocument(
    @Id
    @DynamoDBIgnore
    var id: ClientId? = ClientId(),

    @field:DynamoDBAttribute(attributeName = "AddressClient")
    var addressClient: AddressClientDocument? = null,

    @field:DynamoDBAttribute(attributeName = "NumberDocument")
    var numberDocument: String = "",

    @field:DynamoDBAttribute(attributeName = "ObservationClient")
    var observationClient: String = "",

    @field:DynamoDBAttribute(attributeName = "Name")
    var name: String = "",

    @field:DynamoDBAttribute(attributeName = "AttachDocument")
    var attachDocument: String = ""

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
        name = client.name,
        attachDocument = attachDocument
    )

    constructor(client: ClientUpdate, attachDocument: String) : this(
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
        name = client.name,
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
        name = client.name,
        attachDocument = attachDocument
    )

    @DynamoDBHashKey(attributeName = "ClientId")
    fun getClientId() = if (nonNull(id)) id?.clientId else null

    fun setClientId(clientId: String) {
        if (isNull(id))
            id = ClientId()
        id?.clientId = clientId
    }

    @DynamoDBRangeKey(attributeName = "CreatedAt")
    fun getCreatedAt() = if (nonNull(id)) id?.createdAt else null

    fun setCreatedAt(createdAt: String) {
        if (isNull(id))
            id = ClientId()
        id?.createdAt = createdAt
    }
}