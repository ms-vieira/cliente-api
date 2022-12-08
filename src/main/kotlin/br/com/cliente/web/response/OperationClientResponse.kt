package br.com.cliente.web.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class OperationClientResponse(val operations: List<OperationsResponse>)