package br.com.cliente.web.request

import javax.validation.constraints.NotBlank

data class AddressClientRequest(
    @field:NotBlank
    val street: String,
    @field:NotBlank
    val number: Int,
    @field:NotBlank
    val zipCode: String,
    @field:NotBlank
    val district: String,
    @field:NotBlank
    val city: String,
    @field:NotBlank
    val state: String
)
