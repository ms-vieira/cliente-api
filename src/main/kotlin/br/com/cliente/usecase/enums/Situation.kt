package br.com.cliente.usecase.enums

enum class Situation(val number: Int) {

    ACTIVE(1),
    INATIVE(2);

    companion object {
        fun from(findValue: Int): Situation = Situation.values()[findValue]
    }
}