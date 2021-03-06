package br.com.lab.impacta.investment.repository

import br.com.lab.impacta.investment.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ProductRepository : JpaRepository<Product, Long>