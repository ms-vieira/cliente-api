package br.com.cliente.web.request

import org.springframework.web.multipart.MultipartFile

data class ClientRequest(
    val address: AddressClientRequest,
    val numberDocument: String,
    val observationClient: String
)
