package br.com.cliente.infra.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument

@DynamoDBDocument
class AddressClientDocument(
    var street: String? = "",
    var number: Int? = 0,
    var zipCode: String? = "",
    var district: String? = "",
    var city: String? = "",
    var state: String? = ""
)
