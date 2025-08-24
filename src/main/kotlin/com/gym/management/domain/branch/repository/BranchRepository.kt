package com.gym.management.domain.branch.repository

import com.gym.management.domain.branch.model.entity.Branch
import org.springframework.data.jpa.repository.JpaRepository

interface BranchRepository : JpaRepository<Branch, Int>, BranchRepositoryCustom {}