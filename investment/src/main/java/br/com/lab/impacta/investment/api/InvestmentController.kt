package br.com.lab.impacta.investment.api

import br.com.lab.impacta.investment.application.InvestmentApplication
import br.com.lab.impacta.investment.application.dto.request.InvestmentRequest
import br.com.lab.impacta.investment.application.dto.response.InvestmentResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/accounts")
class InvestmentController(
    private val investmentApplication: InvestmentApplication
) {
    @PostMapping("/{accountId}/investment")
    fun invest(
        @PathVariable accountId: Long,
        @RequestBody investmentRequest: InvestmentRequest): ResponseEntity<InvestmentResponse>? {
        val investmentResponse = investmentApplication.invest(accountId, investmentRequest)
        return ResponseEntity.ok(investmentResponse)
    }

}