package com.gym.management.common.repository.branch

import com.gym.management.common.model.branch.entity.Branch
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BranchRepository : JpaRepository<Branch, Int> {}