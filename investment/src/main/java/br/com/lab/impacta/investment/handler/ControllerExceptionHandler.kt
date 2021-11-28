package br.com.lab.impacta.investment.handler

import br.com.lab.impacta.investment.handler.exception.*
import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*


@ControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(InvestmentProductDontExistException::class)
    fun errorProductDontExists(ex: InvestmentProductDontExistException): ResponseEntity<ErrorMessageResponse?>? {
        val message = ErrorMessageResponse(
            HttpStatus.NOT_FOUND.value(),
            Date(),
            ex.message,
            ex.getDescription()
        )
        return ResponseEntity<ErrorMessageResponse?>(message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(InvestmentAccountWithoutBalanceException::class)
    fun errorWithoutBalance(ex: InvestmentAccountWithoutBalanceException): ResponseEntity<ErrorMessageResponse?>? {
        val message = ErrorMessageResponse(
            HttpStatus.BAD_REQUEST.value(),
            Date(),
            ex.message,
            ex.getDescription()
        )
        return ResponseEntity<ErrorMessageResponse?>(message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(InvestmentAccountWithoutBalanceForProductPrivateException::class)
    fun errorWithoutBalanceForPrivate(ex: InvestmentAccountWithoutBalanceForProductPrivateException): ResponseEntity<ErrorMessageResponse?>? {
        val message = ErrorMessageResponse(
            HttpStatus.BAD_REQUEST.value(),
            Date(),
            ex.message,
            ex.getDescription()
        )
        return ResponseEntity<ErrorMessageResponse?>(message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(InvestmentAccountIsNotDebitException::class)
    fun errorWithoutBalanceForPrivate(ex: InvestmentAccountIsNotDebitException): ResponseEntity<ErrorMessageResponse?>? {
        val message = ErrorMessageResponse(
            HttpStatus.BAD_REQUEST.value(),
            Date(),
            ex.message,
            ex.getDescription()
        )
        return ResponseEntity<ErrorMessageResponse?>(message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(RuntimeException::class)
    fun errorGeneral(ex: RuntimeException): ResponseEntity<ErrorMessageResponse?>? {
        val message = ErrorMessageResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            Date(),
            ex.message,
            "Não foi possível processar sua requisição."
        )
        return ResponseEntity<ErrorMessageResponse?>(message, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}