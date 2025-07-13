package com.gym.management.domain.sale.repository

import com.gym.management.domain.sale.model.entity.SaleDetail
import com.gym.management.domain.sale.model.entity.id.SaleDetailId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleDetailRepository : JpaRepository<SaleDetail, SaleDetailId> {
}