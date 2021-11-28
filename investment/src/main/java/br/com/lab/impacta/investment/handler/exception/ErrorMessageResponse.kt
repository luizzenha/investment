package br.com.lab.impacta.investment.handler.exception

import java.util.*

class ErrorMessageResponse (
    private var statusCode: Number,
    private var timestamp: Date,
    private var message: String?,
    private var description: String?,
        ) {
}