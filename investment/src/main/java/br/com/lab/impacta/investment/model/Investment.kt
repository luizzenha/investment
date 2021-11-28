package br.com.lab.impacta.investment.model

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Investment(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    val productId: Long,

    val accountId: Long,

    val value: Double,

    @CreationTimestamp
    private val date: Date,

    var privateInvestment: Boolean

) {
    constructor() : this(0, 0, 0, 0.0, Date(), false)

    constructor(productId: Long, accountId: Long, value: Double) : this(0, productId, accountId, value, Date(), false)

    fun getId(): Long {
       return id
    }
    fun getDate(): Date {
       return date
    }

    fun sufficientBalanceForInvestment(accountBalance: Double): Boolean {
        return value < accountBalance
    }

    fun verifyProductPrivateOrDefaultForInvestment(accountBalance: Double, product: Product): Boolean {
        if (!product.privateInvestment) {
            privateInvestment = false
            return true
        }
        if (product.privateInvestment && accountBalance >= product.minimumValueForInvestment) {
            privateInvestment = true
            return true
        }
        return false
    }

}