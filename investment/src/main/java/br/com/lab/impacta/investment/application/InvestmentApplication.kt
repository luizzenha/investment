package br.com.lab.impacta.investment.application

import br.com.lab.impacta.investment.application.dto.request.InvestmentRequest
import br.com.lab.impacta.investment.application.dto.response.InvestmentResponse

interface InvestmentApplication {
    fun invest(accountId: Long, investmentRequest: InvestmentRequest): InvestmentResponse
}