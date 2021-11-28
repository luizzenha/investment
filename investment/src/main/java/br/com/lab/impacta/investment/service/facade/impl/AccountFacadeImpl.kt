package br.com.lab.impacta.investment.service.facade.impl

import br.com.lab.impacta.investment.infraestructure.http.AccountClient
import br.com.lab.impacta.investment.service.facade.AccountFacade
import br.com.lab.impacta.investment.service.facade.dto.DebitAccountRequest
import br.com.lab.impacta.investment.service.facade.valueObject.AccountBalanceVO
import org.springframework.stereotype.Component


@Component
class AccountFacadeImpl(
    private val accountClient: AccountClient
) : AccountFacade {
    override fun getAccountBalanceById(accountId: Long): AccountBalanceVO {
        val accountBalanceVO = accountClient.accountBalance(accountId)

        return accountBalanceVO!!
    }

    override fun debitAccount(accountId: Long, valueOfInvestment: Double): Boolean {
        val debitAccountVO = accountClient.debit(accountId, DebitAccountRequest(valueOfInvestment))

        debitAccountVO?.let {
            return it.debited
        }
        return false
    }
}