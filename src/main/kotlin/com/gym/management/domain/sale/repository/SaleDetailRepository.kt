package com.gym.management.domain.sale.repository

import com.gym.management.domain.sale.model.entity.SalesDetail
import com.gym.management.domain.sale.model.entity.id.SalesDetailId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleDetailRepository : JpaRepository<SalesDetail, SalesDetailId> {
}