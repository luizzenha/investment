package br.com.lab.impacta.investment.application.adapter

import br.com.lab.impacta.investment.application.dto.response.InvestmentResponse

import br.com.lab.impacta.investment.model.Investment


class InvestmentAdapter {
    companion object {
        fun toDtoInvestment(investment: Investment): InvestmentResponse {
            return InvestmentResponse(investment.getId(), investment.value, investment.getDate())
        }
    }
}
