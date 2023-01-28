package br.com.cliente.usecase.model

import br.com.cliente.web.request.ClientUpdateRequest

data class ClientUpdate(
    val request: ClientUpdateRequest
) {
    val address: AddressClient = AddressClient(
        street = request.address.street,
        number = request.address.number,
        zipCode = request.address.zipCode,
        city = request.address.city,
        state = request.address.state,
        district = request.address.district
    )
    val numberDocument: String = request.numberDocument
    val observationClient: String = request.observationClient
    val name: String = request.name
    val attachDocument: String = request.attachDocument
}

