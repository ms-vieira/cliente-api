package br.com.cliente.web.response

import br.com.cliente.infra.entity.ClientDocument
import br.com.cliente.usecase.model.AddressClient
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ClientResponse(val clientDocument: ClientDocument) {
    val address: AddressClient? = clientDocument.addressClient?.let {
        AddressClient(
            street = it.street,
            number = clientDocument.addressClient!!.number,
            zipCode = clientDocument.addressClient!!.zipCode,
            city = clientDocument.addressClient!!.city,
            state = clientDocument.addressClient!!.state,
            district = clientDocument.addressClient!!.district
        )
    }
    val numberDocument: String = clientDocument.numberDocument
    val observationClient: String = clientDocument.observationClient
    val attachDocument: String = clientDocument.attachDocument
}