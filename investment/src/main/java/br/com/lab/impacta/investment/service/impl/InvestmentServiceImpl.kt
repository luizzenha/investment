package br.com.lab.impacta.investment.service.impl

import br.com.lab.impacta.investment.handler.exception.InvestmentAccountIsNotDebitException
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountWithoutBalanceException
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountWithoutBalanceForProductPrivateException
import br.com.lab.impacta.investment.handler.exception.InvestmentProductDontExistException
import br.com.lab.impacta.investment.model.Investment
import br.com.lab.impacta.investment.model.Product
import br.com.lab.impacta.investment.repository.InvestmentRepository
import br.com.lab.impacta.investment.repository.ProductRepository
import br.com.lab.impacta.investment.service.InvestmentService
import br.com.lab.impacta.investment.service.facade.AccountFacade
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*


@Service
class InvestmentServiceImpl(
    @Value("\${lab.investment.exceptions.product-dont-exists-message}")
    private val messageExceptionProductDontExists: String,
    @Value("\${lab.investment.exceptions.product-dont-exists-description}")
    private val descriptionExceptionProductDontExists: String,
    @Value("\${lab.investment.exceptions.account-without-balance-message}")
    private val messageExceptionAccountWithoutBalance: String,
    @Value("\${lab.investment.exceptions.account-without-balance-description}")
    private val descriptionExceptionAccountWithoutBalance: String,
    @Value("\${lab.investment.exceptions.account-without-balance-for-product-private-message}")
    private val messageExceptionAccountWithoutBalanceForProductPrivate: String,
    @Value("\${lab.investment.exceptions.account-without-balance-for-product-private-description}")
    private val descriptionExceptionAccountWithoutBalanceForProductPrivate: String,
    @Value("\${lab.investment.exceptions.account-is-not-debited-message}")
    private val messageExceptionAccountIsNotDebited: String,
    @Value("\${lab.investment.exceptions.account-is-not-debited-description}")
    private val descriptionExceptionAccountIsNotDebited: String,
    private val investmentRepository: InvestmentRepository,
    private val productRepository: ProductRepository,
    private val accountFacade: AccountFacade
) : InvestmentService {

    override fun invest(productId: Long, accountId: Long, valueInvestment: Double): Investment {
        val product: Optional<Product> = productRepository.findById(productId)

        if (product.isEmpty) throw InvestmentProductDontExistException(
            messageExceptionProductDontExists,
            descriptionExceptionProductDontExists
        )

        val investment = Investment(productId, accountId, valueInvestment)

        val (_, balance) = accountFacade.getAccountBalanceById(accountId)

        if (!investment.sufficientBalanceForInvestment(balance)) throw InvestmentAccountWithoutBalanceException(
            messageExceptionAccountWithoutBalance,
            descriptionExceptionAccountWithoutBalance
        )

        if (!investment.verifyProductPrivateOrDefaultForInvestment(
                balance,
                product.get()
            )
        ) throw InvestmentAccountWithoutBalanceForProductPrivateException(
            messageExceptionAccountWithoutBalanceForProductPrivate,
            descriptionExceptionAccountWithoutBalanceForProductPrivate
        )

        val isDebited = accountFacade.debitAccount(accountId, valueInvestment)

        if (!isDebited) throw InvestmentAccountIsNotDebitException(
            messageExceptionAccountIsNotDebited,
            descriptionExceptionAccountIsNotDebited
        )

        investmentRepository.save(investment)

        return investment
    }
}