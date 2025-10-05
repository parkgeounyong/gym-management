package com.gym.management.domain.sale.service

import com.gym.management.domain.sale.model.SaleDetailMapper.toEntity
import com.gym.management.domain.sale.model.SaleMapper.toEntity
import com.gym.management.domain.sale.model.dto.SaleDTO
import com.gym.management.domain.sale.model.dto.SaleDetailDTO
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
                saleRepository.save(it.toEntity())
            } catch (e: Exception) {
                logger.error("insert sale failed. sale: $it", e)
                notInsertedSaleIds.add(it.saleId)
            }
        }
        return notInsertedSaleIds
    }

    fun createSaleDetails(saleDetailsDTO: List<SaleDetailDTO>): MutableList<Int> {
        val notInsertedSaleIds: MutableList<Int> = mutableListOf()
        saleDetailsDTO.forEach {
            try {
                saleDetailRepository.save(it.toEntity())
            } catch (e: Exception) {
                logger.error("insert saleDetail failed. saleDetail: $it", e)
                notInsertedSaleIds.add(it.saleId)
            }
        }
        return notInsertedSaleIds
    }

    companion object : KLogging()
}