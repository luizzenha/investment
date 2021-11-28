package br.com.lab.impacta.investment.service.facade

import br.com.lab.impacta.investment.service.facade.valueObject.AccountBalanceVO

interface AccountFacade {
    fun getAccountBalanceById(accountId: Long): AccountBalanceVO
    fun debitAccount(accountId: Long, valueOfInvestment: Double): Boolean
}