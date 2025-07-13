package com.gym.management.domain.sale.service

import com.gym.management.domain.sale.model.dto.SaleDTO
import com.gym.management.domain.sale.model.entity.Sale
import com.gym.management.domain.sale.repository.SaleDetailRepository
import com.gym.management.domain.sale.repository.SaleRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class DSaleService(
    private val saleRepository: SaleRepository,
    private val saleDetailRepository: SaleDetailRepository
) {
    fun createSales(salesDTO: List<SaleDTO>): MutableList<Int> {
        val notInsertedSaleIds: MutableList<Int> = mutableListOf()
        salesDTO.forEach {
            try {
                saleRepository.save(Sale(it))
            } catch (e: Exception) {
                logger.error("insert sale failed. sale: $it", e)
                notInsertedSaleIds.add(it.saleId)
            }
        }
        return notInsertedSaleIds
    }

    companion object : KLogging()
}