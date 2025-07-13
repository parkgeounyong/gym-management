package com.gym.management.domain.sale.repository

import com.gym.management.domain.sale.model.entity.Sale
import com.gym.management.domain.sale.model.entity.id.SaleId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleRepository : JpaRepository<Sale, SaleId> {
}