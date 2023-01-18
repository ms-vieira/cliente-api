package br.com.cliente.web.request

data class AddressClientRequest(
    val street: String,
    val number: Int,
    val zipCode: String,
    val district: String,
    val city: String,
    val state: String
)
