package br.com.lab.impacta.investment.service.facade.valueObject

import com.fasterxml.jackson.annotation.JsonProperty

data class DebitAccountVO (
    @JsonProperty("debited")
    val debited: Boolean
)