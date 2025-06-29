package com.gym.management.domain.branch.repository

import com.gym.management.domain.branch.model.entity.Branch
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BranchRepository : JpaRepository<Branch, Int> {}