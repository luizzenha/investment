package br.com.lab.impacta.investment.config

import org.springframework.context.annotation.Configuration
import feign.Logger
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean

@Configuration
open class InvestmentConfig {

    @Bean
    open fun feignLoggerLevel() : Logger.Level {
        return Logger.Level.FULL
    }

    @Bean
    open fun client() : OkHttpClient {
        return OkHttpClient()
    }
}