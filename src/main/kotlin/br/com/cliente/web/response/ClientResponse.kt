package br.com.cliente.web.response

import br.com.cliente.infra.entity.ClientDocument
import br.com.cliente.usecase.model.AddressClient
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ClientResponse(
    val address: AddressClient?,
    val numberDocument: String,
    val observationClient: String,
    val attachDocument: String,
    val name : String
) {
 constructor(clientDocument: ClientDocument) : this (
     address = clientDocument.addressClient?.let {
        AddressClient(
            street = it.street,
            number = clientDocument.addressClient!!.number,
            zipCode = clientDocument.addressClient!!.zipCode,
            city = clientDocument.addressClient!!.city,
            state = clientDocument.addressClient!!.state,
            district = clientDocument.addressClient!!.district
        )
    },
     numberDocument = clientDocument.numberDocument,
     observationClient = clientDocument.observationClient,
     attachDocument = clientDocument.attachDocument,
     name = clientDocument.name)
}

