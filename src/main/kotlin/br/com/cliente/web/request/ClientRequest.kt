package br.com.cliente.web.request

data class ClientRequest(
    val address: AddressClientRequest,
    val numberDocument: String,
    val observationClient: String,
    val name: String
)
