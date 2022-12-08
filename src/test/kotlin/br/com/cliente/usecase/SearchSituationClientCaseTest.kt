package br.com.cliente.usecase

import org.junit.jupiter.api.Test

class SearchSituationClientCaseTest {

    @Test
    fun should_return_enum_type_give_a_clientId() {
        val result = SearchSituationClientCase().search("teste")
        println(result)
    }
}