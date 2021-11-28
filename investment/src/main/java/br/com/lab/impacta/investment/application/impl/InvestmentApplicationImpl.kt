package br.com.lab.impacta.investment.application.impl

import br.com.lab.impacta.investment.application.InvestmentApplication
import br.com.lab.impacta.investment.application.adapter.InvestmentAdapter
import br.com.lab.impacta.investment.application.dto.request.InvestmentRequest
import br.com.lab.impacta.investment.application.dto.response.InvestmentResponse
import br.com.lab.impacta.investment.model.Investment
import br.com.lab.impacta.investment.service.InvestmentService
import org.springframework.stereotype.Component

@Component
class InvestmentApplicationImpl(
    private val investmentService: InvestmentService
) : InvestmentApplication {
    override fun invest(accountId: Long, investmentRequest: InvestmentRequest): InvestmentResponse {
        val investment: Investment = investmentService.invest(investmentRequest.productId, accountId,
        investmentRequest.value);

        return InvestmentAdapter.toDtoInvestment(investment);

    }

}