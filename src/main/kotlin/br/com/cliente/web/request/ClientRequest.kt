package br.com.cliente.web.request

import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotBlank

data class ClientRequest(
    @field:NotBlank
    val address: AddressClientRequest,
    @field:NotBlank
    val numberDocument: String,
    val observationClient: String,
    @field:NotBlank
    val attachDocument: MultipartFile
)
