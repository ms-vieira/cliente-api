package br.com.cliente.usecase.enums

enum class Situation(val number: Int) {

    ATIVO(1),
    INATIVO(2);

    companion object {
        fun from(findValue: Int): Situation = Situation.values()[findValue]
    }
}