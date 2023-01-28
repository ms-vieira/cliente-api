package br.com.cliente.web.request

data class ClientUpdateRequest(
    val address: AddressClientRequest,
    val numberDocument: String,
    val observationClient: String,
    val name: String,
    val attachDocument: String
)
