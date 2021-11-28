package br.com.lab.impacta.investment.handler.exception

class InvestmentAccountIsNotDebitException (
    message: String?,
    private val description: String,
) : RuntimeException(message) {

    fun getDescription() : String {
        return this.description
    }
}