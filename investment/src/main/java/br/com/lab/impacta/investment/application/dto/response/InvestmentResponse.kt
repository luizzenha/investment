package br.com.lab.impacta.investment.application.dto.response

import java.util.*

data class InvestmentResponse (
    private val id: Long,
    private val value: Double,
    private val date: Date
        )