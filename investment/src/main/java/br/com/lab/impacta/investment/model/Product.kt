package br.com.lab.impacta.investment.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,
    val name: String,
    val minimumValueForInvestment : Double,
    val privateInvestment : Boolean

    ) {
    constructor() : this(0, "", 0.0, false)
}