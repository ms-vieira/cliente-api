package br.com.cliente.usecase.model

data class AddressClient(
    val street: String?,
    val number: Int?,
    val zipCode: String?,
    val district: String?,
    val city: String?,
    val state: String?)
