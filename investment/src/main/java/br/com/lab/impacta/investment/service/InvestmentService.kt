package br.com.lab.impacta.investment.service

import br.com.lab.impacta.investment.model.Investment




interface InvestmentService {
    fun invest(productId: Long, accountId: Long, valueInvestment: Double): Investment
}