package br.com.cliente.web.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class OperationsResponse(val action: String, val clientId: String, val datProcess: String)
