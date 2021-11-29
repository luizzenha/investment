package br.com.lab.impacta.investment.application.dto.response

import java.util.*

data class InvestmentResponse (
    val id: Long,
    val value: Double,
    val date: Date
        )