package br.com.lab.impacta.investment.handler.exception

class InvestmentAccountWithoutBalanceForProductPrivateException(
    message: String?,
    private val description: String,
) : RuntimeException(message) {
    fun getDescription() : String {
        return this.description
    }
}