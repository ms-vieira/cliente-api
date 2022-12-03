package br.com.cliente.infra.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument

@DynamoDBDocument
data class AddressClientDocument(
    val street: String,
    val number: Int,
    val zipCode: String,
    val district: String,
    val city: String,
    val state: String
)
