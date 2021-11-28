package br.com.lab.impacta.investment.infraestructure.http

import br.com.lab.impacta.investment.service.facade.dto.DebitAccountRequest
import br.com.lab.impacta.investment.service.facade.valueObject.AccountBalanceVO
import br.com.lab.impacta.investment.service.facade.valueObject.DebitAccountVO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping


@FeignClient(name= "\${lab.investment.paths.client-account-name}", url = "\${lab.investment.paths.client-account-base-url}")
interface AccountClient {
    @GetMapping("\${lab.investment.paths.client-account-balance-path-url}")
    fun accountBalance(@PathVariable("accountId") accountId: Long?): AccountBalanceVO?

    @PostMapping("\${lab.investment.paths.client-account-debit-path-url}")
    fun debit(@PathVariable("accountId") accountId: Long?, debitAccountRequest: DebitAccountRequest?): DebitAccountVO?
}