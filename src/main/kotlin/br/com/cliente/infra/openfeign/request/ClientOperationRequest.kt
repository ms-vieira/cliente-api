package br.com.cliente.infra.openfeign.request

data class ClientOperationRequest(val action: String, val clientId: String, val datProcess: String)
